package com.example.springboot.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhuYouBin
 * @version 1.0.0
 * @Date: 2022/10/22 12:20
 * @Description FastJson 配置类
 */
@Configuration
public class CustomFastJsonConfig {

    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverters() {
        // 创建 FastJsonHttpMessageConverter 消息转换器对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        // 创建 FastJsonConfig 配置类对象
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 设置编码字符集
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        // 设置日期格式
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        // 设置序列化特征: SerializerFeature 是一个枚举，可以选择不同的序列化特征
        SerializerFeature[] serializerFeatures = new SerializerFeature[] {
                // WriteNullStringAsEmpty: 如果字符串等于 null，那么会被序列化成空字符串 ""
                SerializerFeature.WriteNullStringAsEmpty,
                // WriteNullNumberAsZero: 如果数字等于 null，那么会被序列化成 0
                SerializerFeature.WriteNullNumberAsZero,
                // WriteNullBooleanAsFalse: 如果布尔类型等于 null，那么会被序列化成 false
                SerializerFeature.WriteNullBooleanAsFalse,
                // PrettyFormat: 美化JSON
                SerializerFeature.PrettyFormat
        };
        fastJsonConfig.setSerializerFeatures(serializerFeatures);

        // 配置添加到消息转换器里面
        fastJsonHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        // 设置响应JSON格式数据
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON); // JSON 格式数据
        // 设置消息转换器支持的格式
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypeList);

        // 返回消息转换器
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

}