package com.shu.springboot.platform.dao;

import com.shu.springboot.platform.domain.pojo.PlatformUser;

import java.util.List;

public interface PlatformUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);

    List<PlatformUser> getPage();
}