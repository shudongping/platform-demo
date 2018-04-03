package cn.zs.dao;

import cn.zs.entity.GSUser;

public interface GSUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(GSUser record);

    int insertSelective(GSUser record);

    GSUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GSUser record);

    int updateByPrimaryKey(GSUser record);
}