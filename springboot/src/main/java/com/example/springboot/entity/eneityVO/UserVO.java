package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的抽离类
 * @date 2023/3/10 11:07:53
 */
@Data
@Builder
public class UserVO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 住址
     */
    private String address;
    /**
     * 权限
     */
    private List<String> roles;
    /**
     * 头像
     */
    private String avatar;


}
