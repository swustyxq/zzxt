package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Sxpabx;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;

public interface SxpabxMapper {
    int deleteByPrimaryKey(Integer xspaId);

    int insert(Sxpabx record);

    int insertSelective(Sxpabx record);

    Sxpabx selectByPrimaryKey(Integer xspaId);

    int updateByPrimaryKeySelective(Sxpabx record);

    int updateByPrimaryKeyWithBLOBs(Sxpabx record);

    int updateByPrimaryKey(Sxpabx record);
    

    List<Sxpabx> selectBystudentId(int studentId);

    List<Sxpabx> selectByStutId_Annual(Sxpabx sxpabx);


    List<Pabxbasicinfo> selectPabxbasiinfoByStudId(Integer studId);

    List<Pabxbasicinfo> selectPabxbasiinfoByInstId(Integer instId);

    List<Pabxbasicinfo> selectPabxbasiinfoByClassId(Integer classId);

    List<Pabxbasicinfo> selectAllPabxbasiinfo();

    List<Pabxbasicinfo> selectPabxbasiinfoByMajrId(Integer majrId);
    
    
    
    //List<Sxpabx> selectByStudId(int id);//20121253
   // List<Sxpabx> findsxpabxByStudid(int studentId);
   // List<Sxpabx> findSxpabxBySxpabxStudid(int studentId);
}