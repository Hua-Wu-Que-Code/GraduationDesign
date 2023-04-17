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
    List<Ethnicgroup> ethnicgroup;
    List<Bloodtype> bloodtype;
    List<Education> education;
    List<Marriage> marriage;
    List<Pamentmeth> pamentmeth;
    List<Allergyhistory> allergyhistory;
}
