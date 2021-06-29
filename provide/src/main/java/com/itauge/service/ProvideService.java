package com.itauge.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ProvideService {

    @SentinelResource("test")
    public void test(){
        System.out.println("test");
    }
}
