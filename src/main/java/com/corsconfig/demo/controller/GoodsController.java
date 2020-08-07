package com.corsconfig.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @GetMapping
    @RequestMapping("/one")
    public String one() {
        return "this is /goods/one";
    }
}
