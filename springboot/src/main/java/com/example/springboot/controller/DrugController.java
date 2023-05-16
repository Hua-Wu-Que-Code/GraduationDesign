package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.ListVo;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 药品控制类
 * @date 2023/5/17 00:54:59
 */
@RestController
@RequestMapping("/drug")
public class DrugController extends BaseController{
    /**
     * 添加药品
     * @return
     */
    @RequestMapping("/add")
    @CrossOrigin
    @ResponseBody
    public Result addDrugList(@RequestBody Map map) {
        ArrayList<Drug> drugArray = (ArrayList<Drug>) map.get("json");
        String s = JSON.toJSONString(drugArray);
        List<Drug> drugList = JSONObject.parseArray(s, Drug.class);

        for (int i = 0;i<drugList.size();i++) {


            drugMapper.insertDrug(drugList.get(i).getDrugid(),drugList.get(i).getDrugname(),drugList.get(i).getManu(),drugList.get(i).getPzwh(),drugList.get(i).getClassifyid());
        }

        return Result.succeed();
    }


    /**
     * 获取药品列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result getDrugList(@RequestBody ListQuery query) {
        ArrayList<Drug> drugList = drugMapper.findDrugsAdmin(query);
        ListVo listVo = new ListVo(drugMapper.total(),drugList);
        return Result.succeed(listVo);
    }



}
