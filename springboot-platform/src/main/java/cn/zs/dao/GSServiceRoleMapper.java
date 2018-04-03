package cn.zs.dao;

import cn.zs.entity.GSServiceRole;

public interface GSServiceRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(GSServiceRole record);

    int insertSelective(GSServiceRole record);

    GSServiceRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GSServiceRole record);

    int updateByPrimaryKey(GSServiceRole record);
}