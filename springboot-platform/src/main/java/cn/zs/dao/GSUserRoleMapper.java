package cn.zs.dao;

import cn.zs.entity.GSUserRole;

public interface GSUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(GSUserRole record);

    int insertSelective(GSUserRole record);

    GSUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GSUserRole record);

    int updateByPrimaryKey(GSUserRole record);
}