package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Czylbx;
import swust.edu.cn.zzxt.selfmodel.Czylbxbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;

public interface CzylbxMapper {
    int deleteByPrimaryKey(Integer czylId);

    int insert(Czylbx record);

    int insertSelective(Czylbx record);

    Czylbx selectByPrimaryKey(Integer czylId);

    int updateByPrimaryKeySelective(Czylbx record);

    int updateByPrimaryKeyWithBLOBs(Czylbx record);

    int updateByPrimaryKey(Czylbx record);
    
    List<Czylbx> findCzylbxsByczylStudid(int czylStudid);

	List<Czylbx> findCzylbxsByczylStudidAndYear(Integer studId, String year);

	List<Czylbx> findCzylbxsByczylStudidAndYear(Czylbx czylbx);

    Czylbxbasicinfo selectCzylbxbasiinfoByStudId(Integer studId);
    
    List<Czylbxbasicinfo> selectCzylbxbasiinfoByClassId(Integer classId);

    List<Czylbxbasicinfo> selectAllCzylbxbasiinfo();

    List<Czylbxbasicinfo> selectCzylbxbasiinfoByMajrId(Integer majrId);
    
    List<Czylbxbasicinfo> selectCzylbxbasiinfoByInstId(Integer instId);
    
}