package com.shu.concurrency.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shudp
 * @create 2018/3/27.
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
