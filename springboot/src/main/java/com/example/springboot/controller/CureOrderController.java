package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description
 * @date 2023/5/19 23:03:30
 */
@RestController
@RequestMapping("/cureOrder")
public class CureOrderController extends BaseController{

    /**
     * 新增体检
     * @return
     */
    @RequestMapping("/insertCure")
    @CrossOrigin
    @ResponseBody
    public Result insertDetail(@RequestBody Map map) {
        String doctorId = (String) request.getAttribute("id");

        Object map1 = new Object();
        map1 =  map.get("CureOrder");
        String s = JSON.toJSONString(map1);
        Cureorder cureorder = JSON.parseObject(s,Cureorder.class);
        cureorder.setDoctorid(doctorId);
        String id = UUID.randomUUID().toString();
        cureorder.setId(id);
        cureOrderMapper.insert(cureorder);

        ArrayList<Cureorderitem> cureorderitems = cureorder.getCureorderitems();
        cureorderitems.forEach(item -> {
            item.setCureorderid(id);
            cureorderitemMapper.insert(item);
        });

        return Result.succeed("成功");
    }
}
