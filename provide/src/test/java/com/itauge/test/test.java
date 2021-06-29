package com.itauge.test;

import org.springframework.web.client.RestTemplate;

public class test {

    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 1000; i++) {
            restTemplate.getForObject("http://localhost:82/index",String.class);
            Thread.sleep(300);
        }
    }
}
