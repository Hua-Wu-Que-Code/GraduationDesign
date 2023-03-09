package com.example.springboot;

import org.junit.jupiter.api.Test;

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
        System.out.println(UUID.randomUUID().toString());
    }
}
