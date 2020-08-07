package com.corsconfig.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*1、浏览器限制
2、跨域（协议，域名，端口不一样都是跨域）
3、XHR（XMLHttpRequest请求）
以上三个条件满足，产生跨域问题
注意:localhost和127.0.0.1也会被认为是跨域
*
*/

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    //指定允许跨域的多个域
    private static final String[] ALLOWED_ORIGINS = {"http://www.baidu.com","http://127.0.0.1:81","https://blog.csdn.net"};
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        //添加跨域的cors配置
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/goods/**").   //可以被跨域的路径,/**表示无限制,
                        allowedOrigins(ALLOWED_ORIGINS). //允许跨域的域名，如果值为*,则表示允许任何域名使用
                        allowedMethods("*"). //允许任何方法，值可以为： "GET", "POST" ...
                        allowedHeaders("*"). //允许任何请求头
                        allowCredentials(true). //允许带cookie信息
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600):表示3600秒内，不需要再发送预检验请求，是结果可以缓存的时长
                /*
                registry.addMapping("/home/home").
                        allowedOrigins(ALLOWED_ORIGINS). //允许跨域的域名，如果值为*,则表示允许任何域名使用
                        allowedMethods("*"). //允许任何方法，值可以为： "GET", "POST" ...
                        allowedHeaders("*"). //允许任何请求头
                        allowCredentials(true). //允许带cookie信息
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
                */
            }
        };
    }
}