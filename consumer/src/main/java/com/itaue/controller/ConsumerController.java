package com.itaue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class ConsumerController {

    //自動裝載
    @Autowired
    private DiscoveryClient discoveryClient;

    //不會自動裝載，要設置配置文件或啓動類
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/instance")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> provide = this.discoveryClient.getInstances("provide");
        return provide;
    }

    @GetMapping("/index")
    public String index(){
        //調用provide服務的index方法
        //1. 找到provide實例
        List<ServiceInstance> list = this.discoveryClient.getInstances("provide");
        int index = ThreadLocalRandom.current().nextInt(list.size());
        ServiceInstance serviceInstance = list.get(index);
        String url =serviceInstance.getUri()+"/index";
        log.info(url);
        //2. 調用
        log.info("調用了端口是,{}",serviceInstance.getPort());
        return "現在調用了端口為:"+serviceInstance.getPort()+"的服務，返回結果是，"+this.restTemplate.getForObject(url,String.class);

    }

//    @GetMapping("/index")
//    public String index(){
//        return this.restTemplate.getForObject("http://provide/index",String.class);
//    }
}
