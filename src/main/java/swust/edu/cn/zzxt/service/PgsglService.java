package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Pksglbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pksgltongjiinfo;

public interface PgsglService {

	public PgsglWithBLOBs findPkByStudId(Integer studId);

	public PgsglWithBLOBs addOneRecord(PgsglWithBLOBs pgsgl1);

	public PgsglWithBLOBs update(PgsglWithBLOBs pgsgl);

	public Pksglbasicinfo findPksgbasiinfoByStudentId(Integer studId);

	public List<Pksglbasicinfo> findPksgbasiinfoByInstId(Integer instId);

	public List<Pksglbasicinfo> findPksgbasiinfoByClassId(Integer classId);

	public List<Pksglbasicinfo> findPksgbasiinfoByMajrId(Integer majrId);

	public List<Pksglbasicinfo> findAllPksgbasiinfo();

	public List<Pksgltongjiinfo> findAlltongjiinfo();

	public List<Pksgltongjiinfo> findAlltongjiinfoByinstId(Integer userInstid);

	public List<Pksgltongjiinfo> findAllmajrtongjiinfoByinstId(
			Integer userInstid);
}
