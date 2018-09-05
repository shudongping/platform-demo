package com.shu.springboot.platform.controller;

import com.github.pagehelper.PageInfo;
import com.shu.springboot.platform.common.Result;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;
import com.shu.springboot.platform.rabbitmq.MQSender;
import com.shu.springboot.platform.service.IUserService;
import com.shu.springboot.platform.utils.JWTUtil;
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

    @Autowired
    private  MQSender sender;

    private static int countNum = 0;

    @PostMapping
    public Result<PlatformUser> saveUser(PlatformUser user) {

        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setAge(23);
        user.setMobile("12312312312");
        user.setUsername("test");
        userService.saveUser(user);

        return Result.success(user);
    }

    @ApiOperation(value = "获取redis中数据", notes = "通过redis获取数据")
    @GetMapping
    public Result<String> getRedis() {


        int max = 50;
        long count = RedisPoolUtil.incr("countKey");
        if(count > max){

        }else {
            countNum++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RedisPoolUtil.decr("countKey");
        return Result.success(countNum + "");

    }


    @GetMapping("/page")
    public Result<PageInfo<PlatformUser>> getUserPage(PageVo pageVo) {
        return Result.success(userService.getPage(pageVo));
    }

    @GetMapping("/event/user")
    public Result<String> eventTest() throws Exception {
        userService.sendUserEvent();
        return Result.success("ok");
    }

    @PostMapping("/login")
    public Result<String> login(String username) throws Exception {

        return Result.success(JWTUtil.createToken(username));

    }

    @GetMapping("/mq")
    public Result<String> mqTest(String msg) throws Exception{
        sender.sendMiaoshaMessage(msg);
        return Result.success(msg);
    }


    public static void main(String[] args) {
        String s = String.format("step:%s", "123");
        System.out.print(s);
    }


}
