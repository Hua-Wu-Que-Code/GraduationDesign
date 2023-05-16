package com.example.springboot;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

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

}
