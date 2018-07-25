package com.shu.springboot.platform.controller;

import com.github.pagehelper.PageInfo;
import com.shu.springboot.platform.common.Result;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;
import com.shu.springboot.platform.service.IUserService;
import com.shu.springboot.platform.utils.RedisPoolUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Result<PlatformUser> saveUser(PlatformUser user){

        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setAge(23);
        user.setMobile("12312312312");
        user.setUsername("test");
        userService.saveUser(user);

        return Result.success(user);
    }

    @ApiOperation(value="获取redis中数据", notes="通过redis获取数据")
    @GetMapping
    public Result<String> getRedis(){

        String res = RedisPoolUtil.get("key1");

        return Result.success(res);

    }


    @GetMapping("/page")
    public Result<PageInfo<PlatformUser>> getUserPage(PageVo pageVo){
        return Result.success(userService.getPage(pageVo));
    }

    @GetMapping("/event/user")
    public Result<String> eventTest() throws Exception{
        userService.sendUserEvent();
        return Result.success("ok");
    }


    public static void main(String[] args){
        String s = String.format("step:%s","123");
        System.out.print(s);
    }


}
