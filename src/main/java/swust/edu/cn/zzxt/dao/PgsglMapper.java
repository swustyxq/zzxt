package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Pgsgl;
import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Pksglbasicinfo;

public interface PgsglMapper {
    int deleteByPrimaryKey(Integer pksgId);

    int insert(PgsglWithBLOBs record);

    int insertSelective(PgsglWithBLOBs record);

    PgsglWithBLOBs selectByPrimaryKey(Integer pksgId);

    int updateByPrimaryKeySelective(PgsglWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PgsglWithBLOBs record);

    int updateByPrimaryKey(Pgsgl record);

	PgsglWithBLOBs selectByStudId(Integer studId);

	Pksglbasicinfo selectPksgbasiinfoByStudId(Integer studId);

	List<Pksglbasicinfo> selectPksgbasiinfoByInstId(Integer instId);

	List<Pksglbasicinfo> selectPksgbasiinfoByClassId(Integer classId);

	List<Pksglbasicinfo> selectPksgbasiinfoByMajrId(Integer majrId);

	List<Pksglbasicinfo> selectAllPksgbasiinfo();
}