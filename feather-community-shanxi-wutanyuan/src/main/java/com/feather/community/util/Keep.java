package com.feather.community.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Component
public class Keep {
  public static String keepResult;
    @Scheduled(cron = "0/30 * * * * *")
    public static void corn() throws Exception {
//        System.out.println("《《《《《>>>>《保活");
        String keepUrlStr = "http://172.16.0.10:8088/VIID/token/alive/keep";
//        String keepUrlStr = "http://localhost/service-wutanyuan/zhzl/api/getZdsjList";
        keepResult=keep(keepUrlStr);
        System.out.println("《《《《《>>>>《定时测试"+keepResult);

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
}