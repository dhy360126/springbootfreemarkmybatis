package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.User;
import com.example.demo.service.CommodityService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ControllerFreemarker {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UserService userService;

    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map){
        map.put("name", "我是谁");
        map.put("sex", 1);
        return "freemarker";

    }

    @RequestMapping("/mybatis/{id}")
    @ResponseBody
    public String mybatis(@PathVariable int id){
        Commodity commodity = commodityService.findById(id);
        return commodity.getName();

    }

    @RequestMapping("/mybatis/insertCommodity")
    @ResponseBody
    public String insertCommodity(){
        Commodity commodity = new Commodity();
        commodity.setId(4);
        commodity.setStandard("lisista");
        commodity.setTemperature("lisitem");
        commodity.setName("lisi");
        commodity.setPrice(3);
        commodity.setDescription("test");
        commodityService.insertCommodity(commodity);
        return "插入商品表成功";

    }

    @RequestMapping("/mybatis/insertUser")
    @ResponseBody
    public String insertUser(){
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("李四");
        user.setAddr("测试地址");
        user.setSex(1);
        userService.insertUser(user);
        return "插入用户表成功";


    }


}
