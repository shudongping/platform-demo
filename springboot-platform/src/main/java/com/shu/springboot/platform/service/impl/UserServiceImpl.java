package com.shu.springboot.platform.service.impl;

import com.shu.springboot.platform.dao.PlatformUserMapper;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shudongping on 2018/3/21 0021.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private PlatformUserMapper userMapper;

    @Override
    public void saveUser(PlatformUser user){
        userMapper.insert(user);
    }

}
