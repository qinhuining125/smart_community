package com.feather.community.controller;


import com.alibaba.fastjson.JSONObject;
import com.feather.common.annotation.ClearPage;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.ZhsqMj;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.*;

@Controller
@RequestMapping("/viid")
public class VideoAlarmController extends BaseController {
    public String accessToken;
    /**
     *
     */
    @PostMapping("/api/login")
    @ClearPage
    @ResponseBody
    public AjaxResult login() throws Exception {
        // BASE64("UserName")//编码
        final BASE64Encoder encoder = new BASE64Encoder();
        final String userName = "用户名";
        final byte[] userNameByte = userName.getBytes("UTF-8");
        final String encodedUserName = encoder.encode(userNameByte);
        System.out.println(encodedUserName);

        String urlStr = "http://127.0.0.1/service-wutanyuan/device/api/addShrz";
        Map<String, Object> params = new HashMap();
        JSONObject firstStr = this.doPostUrl(urlStr, params);
        String accessCode = (String) firstStr.get("AccessCode");
        params.put("UserName", "admin");
        params.put("AccessCode", accessCode);
        String loginSignature = encodeByMD5(encodedUserName + accessCode + encodeByMD5("用户密码"));
        params.put("LoginSignature", accessCode);
        JSONObject secondStr =  this.doPostUrl(urlStr, params);
        accessToken= (String) secondStr.get("AccessToken");
        String keepUrlStr = "http://127.0.0.1/service-wutanyuan/device/api/addShrz";

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @SneakyThrows
            public void run() {
                String keepResult=keep(keepUrlStr);
            }
        }, 0, 30000);


        Map<String, Object> paramsOpen = new HashMap();
        paramsOpen.put("Data", "http://208.208.101.245:8088/VIID/gethello");
        paramsOpen.put("Type", 0);
        String urlStrOpen = "http://server-addr:8088/VIID/alarm/open";
        doPostUrl(urlStrOpen,paramsOpen);
        return AjaxResult.success("成功");
    }



    /**
     * 登录保活     *
     * @return
     * @throws Exception
     */
    public static String keep(String url) throws Exception {
        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type",
                "application/text");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception(
                    "HTTP Request is not success, Response code is "
                            + httpURLConnection.getResponseCode());
        }

        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }
        return resultBuffer.toString();
    }
    /**
     * 登录
     *
     * @param url    post请求url
     * @param params 参数
     * @return
     * @throws Exception
     */
    public static JSONObject doPostUrl(String url, Map<String, Object> params) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        HttpClient httpclient = new DefaultHttpClient();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            BasicNameValuePair bnvp = null;
            for (Map.Entry<String, Object> p : params.entrySet()) {
                bnvp = new BasicNameValuePair(p.getKey(), (String) p.getValue());
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity respEntity = response.getEntity();//获得返回数据
        String text = EntityUtils.toString(respEntity, "UTF-8");
        JSONObject obj = (JSONObject) JSONObject.parse(text);
        httpclient.getConnectionManager().shutdown();
        return obj;
    }
    //十六进制下数字到字符的映射数组
    private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    /**
     * 对字符串进行MD5编码
     */
    private static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md5.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String result = byteArrayToHexString(results);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 轮换字节数组为十六进制字符串
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for(int i=0;i<b.length;i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    //将一个字节转化成十六进制形式的字符串
    private static String byteToHexString(byte b){
        int n = b;
        if(n<0)
            n=256+n;
        int d1 = n/16;
        int d2 = n%16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
