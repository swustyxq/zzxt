package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Refunctionaction;

public interface RefunctionactionMapper {
    int deleteByPrimaryKey(Integer refaId);

    int insert(Refunctionaction record);

    int insertSelective(Refunctionaction record);

    Refunctionaction selectByPrimaryKey(Integer refaId);

    int updateByPrimaryKeySelective(Refunctionaction record);

    int updateByPrimaryKey(Refunctionaction record);
}