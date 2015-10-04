package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.WorkWithBLOBs;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(WorkWithBLOBs record);

    int insertSelective(WorkWithBLOBs record);

    WorkWithBLOBs selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(WorkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WorkWithBLOBs record);

    int updateByPrimaryKey(Work record);

	List<Work> selectAllWork();
}