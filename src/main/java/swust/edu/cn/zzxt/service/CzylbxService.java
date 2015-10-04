package swust.edu.cn.zzxt.service;

import java.util.Collection;
import java.util.List;

import swust.edu.cn.zzxt.model.Czylbx;
import swust.edu.cn.zzxt.selfmodel.Czylbxbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;

public interface CzylbxService {
	List<Czylbx> findCzylbxsByStudentId(int studentId);
	public  void EditInfoByCzlybxId(int CzylbxId,int will );
	public List<Czylbx> findCzylbxsByYearAndStudentId(Integer studId, String year);
	public Czylbxbasicinfo findCzylbxbasiinfoByStudentId(Integer studId);
    public List<Czylbxbasicinfo> findCzylbxbasiinfoByInstId(Integer instId);
    public List<Czylbxbasicinfo> findCzylbxbasiinfoByClassId(Integer classId);
    public List<Czylbxbasicinfo> findCzylbxbasiinfoByMajrId(Integer majrId);
    public List<Czylbxbasicinfo> selectAllCzylbxbasiinfo();
}
