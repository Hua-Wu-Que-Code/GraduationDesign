package com.example.springboot.service;

import com.example.springboot.entity.Result;
import com.example.springboot.entity.eneityVO.ExamInfo;
import com.example.springboot.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 体检服务层
 * @date 2023/5/19 17:36:41
 */
@Service
public class ExamInfoService {

    @Autowired
    CommonMapper commonMapper;
    public ExamInfo findDetailInfo() {

        ExamInfo examInfo = new ExamInfo();
        examInfo.setExefres(commonMapper.findExeFre());
        examInfo.setSmokes(commonMapper.findSmoke());
        examInfo.setDrinks(commonMapper.findDrinks());
        examInfo.setSports(commonMapper.findSports());
        examInfo.setSexes(commonMapper.findSex());
        examInfo.setLips(commonMapper.findLips());
        examInfo.setLintenings(commonMapper.findListenings());
        examInfo.setPharynxes(commonMapper.findPharynxes());
        return examInfo;
    }
}
