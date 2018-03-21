package com.shu.springboot.platform.dao;

import com.shu.springboot.platform.domain.pojo.PlatformUser;

public interface PlatformUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);
}