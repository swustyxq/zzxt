package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Workstepfolw;

public interface WorkstepfolwMapper {
    int deleteByPrimaryKey(Integer wsflId);

    int insert(Workstepfolw record);

    int insertSelective(Workstepfolw record);

    Workstepfolw selectByPrimaryKey(Integer wsflId);

    int updateByPrimaryKeySelective(Workstepfolw record);

    int updateByPrimaryKey(Workstepfolw record);

	List<Workstepfolw> selectByWorkidAndSituationAndOrder(Workstepfolw workstep);

	
}