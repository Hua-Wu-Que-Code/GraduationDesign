package com.example.springboot;

import com.example.springboot.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 生成用户名的测试类
 * @date 2023/3/9 21:42:02
 */
public class userIdGenerateTest {
    @Test
    void IDGenerate() {
        for (int i = 0;i< 10;i++)
        System.out.println(UUID.randomUUID().toString()
        );
    }

    @Test
    void Time() {
        Date date  = new Date();
        LocalTime time = LocalTime.now();

        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        System.out.println("hour=" + hour);
        System.out.println("minute="+minutes);
    }

    @Test
    void ApiTest() {
        String host = "http://drug.market.alicloudapi.com";
        String path = "/drugInfo";
        String method = "GET";
        String appcode = "1cdb65cec93042a09afa8146875f4fae";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("classifyId", "599ad2a0600b2149d689b75a");
        querys.put("maxResult", "20");
        querys.put("page", "1");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
