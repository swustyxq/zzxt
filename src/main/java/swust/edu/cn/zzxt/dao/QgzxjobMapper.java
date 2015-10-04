package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Qgzxjob;
import swust.edu.cn.zzxt.model.QgzxjobWithBLOBs;

public interface QgzxjobMapper {
    int deleteByPrimaryKey(Integer qjobId);

    int insert(QgzxjobWithBLOBs record);

    int insertSelective(QgzxjobWithBLOBs record);

    QgzxjobWithBLOBs selectByPrimaryKey(Integer qjobId);

    int updateByPrimaryKeySelective(QgzxjobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QgzxjobWithBLOBs record);

    int updateByPrimaryKey(Qgzxjob record);
}