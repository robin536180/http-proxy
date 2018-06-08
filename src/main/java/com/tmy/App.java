package com.tmy;

import java.util.Map;

import javax.servlet.Servlet;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.ImmutableMap;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public Servlet proxyServlet(){
        return new ProxyServlet();
    }
    
    @Bean
    public ServletRegistrationBean proxyServletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(proxyServlet(), "/*");
        Map<String, String> params = ImmutableMap.of(
                "targetUri", "http://baidu.com", 
                "log", "true");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }
}
