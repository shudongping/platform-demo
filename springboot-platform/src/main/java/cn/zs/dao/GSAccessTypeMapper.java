package cn.zs.dao;

import cn.zs.entity.GSAccessType;

public interface GSAccessTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GSAccessType record);

    int insertSelective(GSAccessType record);

    GSAccessType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GSAccessType record);

    int updateByPrimaryKey(GSAccessType record);
}