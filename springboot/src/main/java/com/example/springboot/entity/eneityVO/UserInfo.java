package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.*;
import lombok.Data;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 用户基础信息类
 * @date 2023/4/16 23:57:14
 */
@Data
public class UserInfo {
    //健康表
    Healthrecord healthrecord;
    //体检表
    List<Medicalexaminationfile> medicalexaminationfile;
    //健康表基础信息
    HealthCareInfo healthCareInfo;
}
