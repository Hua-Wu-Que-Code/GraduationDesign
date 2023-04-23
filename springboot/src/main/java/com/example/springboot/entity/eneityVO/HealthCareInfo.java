package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.*;
import lombok.Data;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 健康档案基础信息
 * @date 2023/4/17 11:02:30
 */
@Data
public class HealthCareInfo {

    //民族列表
    List<Ethnicgroup> ethnicgroup;

    //血型列表
    List<Bloodtype> bloodtype;

    //教育经历列表
    List<Education> education;

    //婚姻状况列表
    List<Marriage> marriage;

    //支付方式列表
    List<Pamentmeth> pamentmeth;

    //过敏列表
    List<Allergyhistory> allergyhistory;

    //工作列表
    List<Work> works;

    //性别列表
    List<Sex> sexes;

    //疾病列表
    List<Disease> diseases;

    //残疾列表
    List<Disability> disabilities;

    //遗传病列表
    List<HeritageDisease> heritageDiseases;

}
