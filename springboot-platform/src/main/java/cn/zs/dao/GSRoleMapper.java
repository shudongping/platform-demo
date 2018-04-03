package cn.zs.dao;

import cn.zs.entity.GSRole;

public interface GSRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(GSRole record);

    int insertSelective(GSRole record);

    GSRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GSRole record);

    int updateByPrimaryKey(GSRole record);
}