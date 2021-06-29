package com.itauge.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itauge.service.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvideController {

    @Autowired
    ProvideService provideService;

    //spring el
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/test1")
    public String test1(){
        this.provideService.test();
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        this.provideService.test();
        return "test2";
    }

    @GetMapping("/hot")
    @SentinelResource("hot")
    public String hot(@RequestParam(value = "num1",required = false)Integer num1,
                      @RequestParam(value = "num2",required = false)Integer num2){
        return num1+"-"+num2;
    }

    @GetMapping("/api1/demo1")
    public String demo1(){
        return "demo";
    }

    @GetMapping("/api1/demo2")
    public String demo2(){
        return "demo";
    }

    @GetMapping("/api2/demo1")
    public String demo3(){
        return "demo";
    }

    @GetMapping("/api2/demo2")
    public String demo4(){
        return "demo";
    }
}
