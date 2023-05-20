package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.*;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 体检表信息
 * @date 2023/5/19 16:13:40
 */
@Data
public class ExamInfo {
    ArrayList<Exefre> exefres;
    ArrayList<Smoke> smokes;

    ArrayList<Drink> drinks;
    ArrayList<Sport> sports;
    ArrayList <Sex> sexes;
    ArrayList <Lip> lips;
    ArrayList<Lintening> lintenings;
    ArrayList<Pharynx> pharynxes;
}
