package com.shu.springboot.platform.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageParams;
import com.shu.springboot.platform.dao.PlatformUserMapper;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;
import com.shu.springboot.platform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private PlatformUserMapper userMapper;

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

}
