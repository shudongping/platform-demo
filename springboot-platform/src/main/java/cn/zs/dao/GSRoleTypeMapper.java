package cn.zs.dao;

import cn.zs.entity.GSRoleType;

public interface GSRoleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GSRoleType record);

    int insertSelective(GSRoleType record);

    GSRoleType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GSRoleType record);

    int updateByPrimaryKey(GSRoleType record);
}