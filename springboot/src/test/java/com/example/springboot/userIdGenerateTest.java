package com.example.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
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
        String path = "/drugDetail";
        String method = "GET";
        String appcode = "1cdb65cec93042a09afa8146875f4fae";
        boolean flag = true;
        do {
            flag = false;
        }while (flag);
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("classifyId", "599ad282600b2149d689b5d5");
        querys.put("maxResult", "10");
        querys.put("page", "1");
        querys.put("searchKey", "59c9aa2e0b5b76e52ff0c431");
        querys.put("searchType", "4");


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
            /*HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            String str = EntityUtils.toString(response.getEntity());
            JSONObject json = JSONObject.parseObject(str);
            System.out.println(json.toJSONString());
            //json数据按key取值
            String body = json.getString("showapi_res_body");
            JSONObject jsonBody = JSONObject.parseObject(body);
            System.out.println(jsonBody);
            String drug = jsonBody.getString("drugList");
            System.out.println("药品是:"+drug);
            String str1 = drug.substring(1, drug.length() - 1);
            System.out.println(str1);
            JSONObject drugInfo = JSONObject.parseObject(str1);
            DrugInfo drugdetail= JSON.toJavaObject(drugInfo, DrugInfo.class);
            System.out.println(drugdetail.getPzwh());*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
