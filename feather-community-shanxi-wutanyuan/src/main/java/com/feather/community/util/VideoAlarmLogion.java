package com.feather.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.*;

@Component
public class VideoAlarmLogion {
    public static String accessToken;
    public static String keepResult;

    //    "0 0 12 * * ?" 每天中午12点触发
    @Scheduled(cron = "0 0 12 * * ?")
//    @PostConstruct
    public static void corn() throws Exception {
        System.out.printf("登录测试");
        // BASE64("UserName")//编码
        String urlStr = "http://172.16.0.10:8088/VIID/login";
        Map<String, Object> params = new HashMap();
        String str = "UTF-8";
        JSONObject jsonObject = new JSONObject();
        String firstStr = sendInfoPost(urlStr, "");
        System.out.println(firstStr);
        //String firstStr= send(urlStr,jsonObject,str);
        JSONObject jsonFirstObject = JSONObject.parseObject(firstStr);

        System.out.println("========" + jsonFirstObject);

        //第二次调用
        String accessCode = (String) jsonFirstObject.get("AccessCode");
        final BASE64Encoder encoder = new BASE64Encoder();
        final String userName = "loadmin";
        final byte[] userNameByte = userName.getBytes("UTF-8");
        final String encodedUserName = encoder.encode(userNameByte);

        String passwordMd = DigestUtils.md5DigestAsHex("*Ab123456".getBytes());
        String last = encodedUserName + accessCode + passwordMd;
        String loginSignature = DigestUtils.md5DigestAsHex(last.getBytes());
        //encodeByMD5(encodedUserName + accessCode + encodeByMD5("*Ab123456"));

        //放置参数进入
        Map map1 = new HashMap();
        map1.put("UserName", "loadmin");
        map1.put("LoginSignature", loginSignature);
        map1.put("AccessCode", accessCode);
        com.feather.common.json.JSONObject json1 = com.feather.common.json.JSONObject.toJSONObject(map1);
        String secondStr = sendInfoPost(urlStr, json1.toString());
        System.out.println("第二次访问结果=====" + secondStr);
        //获取到token

        JSONObject jsonFirstObject2 = JSONObject.parseObject(secondStr);
        System.out.println("========" + jsonFirstObject2);
        accessToken = (String) jsonFirstObject2.get("AccessToken");
        System.out.println("accessToken=" + accessToken);
    }

    /***
     *
     * @param url
     * @param param
     * @return 发送返回响应
     * @throws IOException
     */
    public static String sendInfoPost(String url, String param) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        httppost.addHeader("AccessToken", accessToken);

        String textMsg = param;
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);
        String result = null;
        org.apache.http.HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } else {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }

        return result;
    }

    @Scheduled(cron = "0/30 * * * * *")
    public static void keep() throws Exception {
//        System.out.println("《《《《《>>>>《保活");
        String keepUrlStr = "http://172.16.0.10:8088/VIID/token/alive/keep";
//        String keepUrlStr = "http://localhost/service-wutanyuan/zhzl/api/getZdsjList";
        keepResult = getParams(keepUrlStr);
        System.out.println("keep--->定时测试。accessToken:"+accessToken + ";keepResult"+keepResult);

    }

    /**
     * 登录保活     *
     *
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

    public static String getParams(String url) {

        // 获取连接客户端工具
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String entityStr = null;
        CloseableHttpResponse response = null;

        try {
            /*
             * 由于GET请求的参数都是拼装在URL地址后方，所以我们要构建一个URL，带参数
             */
            URIBuilder uriBuilder = new URIBuilder(url);


            // 根据带参数的URI对象构建GET请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            /*
             * 添加请求头信息
             */
            // 浏览器表示
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            // 传输的类型
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            // 传输的类型
            httpGet.addHeader("Authorization", accessToken);

            // 执行请求
            response = httpClient.execute(httpGet);
            // 获得响应的实体对象
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(entity, "UTF-8");
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.err.println("URI解析异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            // 释放连接
            if (null != response) {
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                    e.printStackTrace();
                }
            }
        }

        // 打印响应内容
        System.out.println(entityStr);
        return entityStr;
    }

}