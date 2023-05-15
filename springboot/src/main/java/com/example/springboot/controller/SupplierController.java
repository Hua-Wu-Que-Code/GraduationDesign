package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.mapper.SupplierMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 供货商的控制类
 * @date 2023/5/15 19:55:30
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController extends BaseController{
    /**
     * 获取供货商列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result getApplierList(@RequestBody ListQuery query) {
        List<Supplier> suppliers = supplierService.findSuppliersAdmin(query);
        for (Supplier supplier : suppliers) {
            String id = supplier.getId();
            User user = userService.findUserById(id);
            String sta = user.isStatus() ? "正常" : "停用";
            user.setStatusStr(sta);
            supplier.setUser(user);
        }
        return Result.succeed(suppliers);
    }
}
