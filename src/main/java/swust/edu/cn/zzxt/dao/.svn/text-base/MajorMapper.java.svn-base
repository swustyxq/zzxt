package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer majrId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majrId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKeyWithBLOBs(Major record);

    int updateByPrimaryKey(Major record);

	List<Major> selectByInstId(Integer instId);

	List<Major> selectByMajorId(Integer classMajrid);

	List<Major> selectClassByUserId(Integer userId);
}
