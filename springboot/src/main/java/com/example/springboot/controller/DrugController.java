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
     * 添加药品类别
     * @return
     */
    @RequestMapping("/addClass")
    @CrossOrigin
    @ResponseBody
    public Result addDrugClass(@RequestBody Map map) {
        ArrayList<Drugclass> drugArray = (ArrayList<Drugclass>) map.get("json");
        String s = JSON.toJSONString(drugArray);
        List<Drugclass> drugList = JSONObject.parseArray(s, Drugclass.class);

        for (int i = 0;i<drugList.size();i++) {
            drugMapper.insertDrugClass(drugList.get(i).getClassname(),drugList.get(i).getClassify(),drugList.get(i).getClassifyid());
        }

        return Result.succeed();
    }

    /**
     * 添加药品详细信息
     * @return
     */
    @RequestMapping("/addDetail")
    @CrossOrigin
    @ResponseBody
    public Result addDrugDetail(@RequestBody Map map) {
        ArrayList<DrugInfo> drugInfoArrayList = (ArrayList<DrugInfo>) map.get("drug");
        String s = JSON.toJSONString(drugInfoArrayList);
        List<DrugInfo> drugInfos = JSONObject.parseArray(s, DrugInfo.class);


        for (int i = 0;i<drugInfos.size();i++) {
            DrugInfo drugInfo = drugInfos.get(i);
            String drugId = drugInfo.getDrugid();
            String drugName = drugInfo.getDrugName();
            String jj = drugInfo.getJj();
            String xz = drugInfo.getXz();
            String spmc = drugInfo.getSpmc();
            String jx = drugInfo.getJx();
            String syz = drugInfo.getSyz();
            String yfyl = drugInfo.getYfyl();
            String zycf = drugInfo.getZycf();
            String zysx = drugInfo.getZysx();
            String etyy = drugInfo.getEtyy();
            String gg = drugInfo.getGg();
            String yfjbrqfnyy = drugInfo.getYfjbrqfnyy();
            String manu = drugInfo.getManu();
            String zc = drugInfo.getZc();
            String hypy = drugInfo.getHypy();
            String tymc = drugInfo.getTymc();
            String pzwh = drugInfo.getPzwh();
            String zxbz = drugInfo.getZxbz();
            String ywxhzy = drugInfo.getYwxhzy();
            String yxq = drugInfo.getYxq();
            String blfy = drugInfo.getBlfy();
            String lryy = drugInfo.getLryy();
            String price = drugInfo.getPrice();
            if (drugMapper.findDrugInfoById(drugId) == null)
            drugMapper.insertDrugInfo(drugId,drugName,jj,gg,xz,spmc,jx,syz,yfyl,zycf,zysx,etyy,yfjbrqfnyy,manu,zc,hypy,tymc,pzwh,zxbz,ywxhzy,yxq,blfy,lryy,price);
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
    /**
     * 获取药品详情
     * @return
     */
    @RequestMapping("/drugDetail")
    @CrossOrigin
    @ResponseBody
    public Result getDrugDetail(@RequestBody DrugInfo drugInfo) {
        String id = drugInfo.getDrugid();
        DrugInfo drugInfo1 = drugMapper.findDrugInfoById(id);
        return Result.succeed(drugInfo1);
    }


}
