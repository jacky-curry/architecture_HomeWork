package com.example.lab3.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("/test")
    public String getJson(){
//        Person person = new Person("student1",111);
//        System.out.println("Person" + person);
//        System.out.println("Person" + JSONUtil.toJsonStr(person));
        JSONObject obj = JSONUtil.createObj();
        obj.append("name","ccy");
        obj.append("id",111);

        return obj.toString();
    }
}
