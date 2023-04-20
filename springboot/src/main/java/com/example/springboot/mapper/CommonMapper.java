package com.example.springboot.mapper;

import com.example.springboot.entity.Disability;
import com.example.springboot.entity.Disease;
import com.example.springboot.entity.UserDisability;
import com.example.springboot.entity.UserDisease;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 通用查找类
 * @date 2023/4/20 17:14:59
 */
@Mapper
public interface CommonMapper {
    @Select("select * from disease")
    List<Disease> healthCareInfoDisease();

    @Select("select * from disease where id = #{id}")
    Disease diseaseInfo(int id);

    /*@Select("select * from user_disease where userID = #{userId}")
    @Results(value = {
            @Result(
                    property = "diseases",
                    column = "diseaseID",
                    one = @One(select = "com.example.springboot.mapper.CommonMapper.diseaseInfo")
            )
    })
    List<Disease> userInfoDisease(String userId);*/

    @Select("select * from user_disease where userID = #{userId}")
    List<UserDisease> userInfoUserDisease(String userId);

    @Select("select * from user_disability where user_id = #{userId}")
    List<UserDisability> userInfoUserDisability(String userId);

    @Select("select * from disability")
    List<Disability> healthCareInfoUserDisability();
}
