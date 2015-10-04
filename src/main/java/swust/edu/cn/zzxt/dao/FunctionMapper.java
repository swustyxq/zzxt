package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(Integer funcId);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer funcId);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKeyWithBLOBs(Function record);

    int updateByPrimaryKey(Function record);

    List<Function> selectAllfunction();//查所有的function
}