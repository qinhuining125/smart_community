package com.feather.community.controller;


import com.alibaba.fastjson.JSONObject;
import com.feather.common.annotation.ClearPage;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.ZhsqMj;
import lombok.SneakyThrows;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
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
    public static String accessToken;


    /**
     *登陆摄像头硬件
     */
    @PostMapping("/api/login")
    @ClearPage
    @ResponseBody
    public AjaxResult login() throws Exception {
        // BASE64("UserName")//编码
        String urlStr = "http://172.16.0.10:8088/VIID/login";
        Map<String, Object> params = new HashMap();
        String str="UTF-8";
        JSONObject jsonObject=new JSONObject();
        String firstStr=sendInfoPost(urlStr,"");
        System.out.println(firstStr);
        //String firstStr= send(urlStr,jsonObject,str);
        JSONObject jsonFirstObject =JSONObject.parseObject(firstStr);

        System.out.println("========"+jsonFirstObject);

        //第二次调用
        String accessCode = (String) jsonFirstObject.get("AccessCode");
        final BASE64Encoder encoder = new BASE64Encoder();
        final String userName = "loadmin";
        final byte[] userNameByte = userName.getBytes("UTF-8");
        final String encodedUserName = encoder.encode(userNameByte);

        String passwordMd=DigestUtils.md5DigestAsHex("*Ab123456".getBytes());
        String last=encodedUserName + accessCode +passwordMd;
        String loginSignature = DigestUtils.md5DigestAsHex(last.getBytes());
        //encodeByMD5(encodedUserName + accessCode + encodeByMD5("*Ab123456"));

        //放置参数进入
        Map map1 = new HashMap();
        map1.put("UserName", "loadmin");
        map1.put("LoginSignature", loginSignature);
        map1.put("AccessCode", accessCode);
        com.feather.common.json.JSONObject json1 = com.feather.common.json.JSONObject.toJSONObject(map1);
        String secondStr= sendInfoPost(urlStr,json1.toString());
        System.out.println("第二次访问结果====="+secondStr);
        //获取到token

        JSONObject jsonFirstObject2 =JSONObject.parseObject(secondStr);
        System.out.println("========"+jsonFirstObject2);
        accessToken = (String) jsonFirstObject.get("AccessToken");
        System.out.println("accessToken="+accessToken);
        return AjaxResult.success("成功");
    }



    /**
     *登陆摄像头硬件
     */
    @PostMapping("/api/OpenOrder")
    @ClearPage
    @ResponseBody
    public AjaxResult openOrder() throws Exception {

        // BASE64("UserName")//编码
        String urlStr = "http://172.16.0.10:8088/VIID/alarm/open";
        //放置参数
        Map<String, Object> paramsOpen = new HashMap();
        paramsOpen.put("Data", "http://127.0.0.1/service-wutanyuan/device/api/addSxtptgj");
        paramsOpen.put("Type", 0);
        com.feather.common.json.JSONObject jsonOpenAlarm = com.feather.common.json.JSONObject.toJSONObject(paramsOpen);
        String result= sendInfoPost(urlStr,jsonOpenAlarm.toString());
        System.out.println("result="+result);
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
     * 发送post请求
     * @param url  路径
     * @param jsonObject  参数(json类型)
     * @param encoding 编码格式
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, JSONObject jsonObject,String encoding) throws ParseException, IOException{
        String body = "";
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        //装填参数
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        //设置参数到请求对象中
        httpPost.setEntity(s);
        System.out.println("请求地址："+url);
//        System.out.println("请求参数："+nvps.toString());
        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
//        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
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


    /***
     *
     * @param url
     * @param param
     * @return 发送返回响应
     * @throws IOException
     */
    public static String sendInfoPost(String url,String param) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        httppost.addHeader("AccessToken", accessToken);

        String textMsg = param;
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);
        String result = null;
        org.apache.http.HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            result= EntityUtils.toString(response.getEntity(), "utf-8");
        }else{
            result= EntityUtils.toString(response.getEntity(), "utf-8");
        }

        return result;
    }

}
