//package com.itauge.config;
//
//import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean registrationBean(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new CommonFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY,"false");
//        registrationBean.setName("sentinelFilter");
//        return registrationBean;
//    }
//}