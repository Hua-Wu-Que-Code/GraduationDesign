package com.example.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.springboot.entity.*;
import org.springframework.web.bind.annotation.*;


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
     * 获取医生列表
     * @return
     */
    @RequestMapping("/add")
    @CrossOrigin
    @ResponseBody
    public Result addDrugList(@RequestBody JSONArray jsonArray) {

        return Result.succeed();
    }

}
