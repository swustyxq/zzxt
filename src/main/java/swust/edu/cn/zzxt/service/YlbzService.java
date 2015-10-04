package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.YlbzWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Ylbzbasicinfo;

public interface YlbzService {

	public YlbzWithBLOBs addOneRecord(YlbzWithBLOBs ylbz);

	public List<YlbzWithBLOBs> findYlbzByStudId(Integer studId);

	public YlbzWithBLOBs update(YlbzWithBLOBs ylbz);

	public YlbzWithBLOBs findYlbzByid(int ylbzId);
	
	public List<Ylbzbasicinfo> findAllYlbzBasicinfo();
	
	public List<Ylbzbasicinfo> findYlbzBasicinfoByinstId(Integer instId);
	
	public List<Ylbzbasicinfo> findYlbzBasicinfoBymajrId(Integer majrId);
	
	public List<Ylbzbasicinfo> findYlbzBasicinfoByclassId(Integer classId);
	
	public List<Ylbzbasicinfo> findYlbzBasicinfoBystudId(Integer studId);
	
	
}
