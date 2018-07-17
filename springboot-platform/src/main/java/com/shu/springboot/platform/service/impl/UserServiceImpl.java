package com.shu.springboot.platform.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageParams;
import com.shu.springboot.platform.dao.PlatformUserMapper;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;
import com.shu.springboot.platform.event.DemoEvent;
import com.shu.springboot.platform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private PlatformUserMapper userMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(PlatformUser user){
        userMapper.insert(user);
    }

    @Override
    public PageInfo<PlatformUser> getPage(PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());

        List<PlatformUser>  list = userMapper.getPage();

        PageInfo<PlatformUser> platformUserPageInfo = new PageInfo<PlatformUser>(list);

        return platformUserPageInfo;


    }

    @Override
    public void sendUserEvent() throws Exception{

        PlatformUser user = new PlatformUser();
        user.setUsername("event");
        user.setId(UUID.randomUUID().toString().replace("-",""));
        applicationContext.publishEvent(new DemoEvent(this,user));

    }





}
