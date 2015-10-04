package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Ylbz;
import swust.edu.cn.zzxt.model.YlbzWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Ylbzbasicinfo;

public interface YlbzMapper {
    int deleteByPrimaryKey(Integer ylbzId);

    int insert(YlbzWithBLOBs record);

    int insertSelective(YlbzWithBLOBs record);

    YlbzWithBLOBs selectByPrimaryKey(Integer ylbzId);

    int updateByPrimaryKeySelective(YlbzWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(YlbzWithBLOBs record);

    int updateByPrimaryKey(Ylbz record);

	List<YlbzWithBLOBs> selectByStudId(Integer studId);

	List<Ylbzbasicinfo> selectAllYlbzbasiinfo();

	List<Ylbzbasicinfo> selectYlbzbasiinfoByinstId(Integer instId);

	List<Ylbzbasicinfo> selectYlbzbasiinfoBymajrId(Integer majrId);

	List<Ylbzbasicinfo> selectYlbzbasiinfoByclassId(Integer classId);

	List<Ylbzbasicinfo> selectYlbzbasiinfoBystudId(Integer studId);
}