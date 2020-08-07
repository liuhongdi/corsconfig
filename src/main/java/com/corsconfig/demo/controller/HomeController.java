package com.corsconfig.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    //允许跨域多个值
    @CrossOrigin(origins = {"http://127.0.0.1:1999","http://127.0.0.1:81","http://cas.baidu.com","http://do.baidu.com"},maxAge = 3600)
    @GetMapping
    @RequestMapping("/home")
    public String home() {
        return "this is /home/home";
    }

    //允许跨域,只有一个域
    //只写@CrossOrigin 表示允许所有域访问
    @CrossOrigin("http://127.0.0.1:1999")
    @GetMapping
    @RequestMapping("/index")
    public String index() {
        return "this is /home/index";
    }

}