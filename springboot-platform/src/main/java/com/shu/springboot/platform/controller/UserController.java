package com.shu.springboot.platform.controller;

import com.github.pagehelper.PageInfo;
import com.shu.springboot.platform.common.Result;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;
import com.shu.springboot.platform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping
    public Result<PlatformUser> saveUser(PlatformUser user){

        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setAge(23);
        user.setMobile("12312312312");
        user.setUsername("test");
        userService.saveUser(user);

        return Result.success(user);
    }


    @GetMapping
    public Result<String> getRedis(){

        redisTemplate.opsForValue().set("key1","key1");
        redisTemplate.opsForValue().set("key2","key2");
        String res = redisTemplate.opsForValue().get("key2").toString();

        return Result.success(res);

    }


    @GetMapping("/page")
    public Result<PageInfo<PlatformUser>> getUserPage(PageVo pageVo){
        return Result.success(userService.getPage(pageVo));
    }



    public static void main(String[] args){
        String s = String.format("step:%s","123");
        System.out.print(s);
    }


}
