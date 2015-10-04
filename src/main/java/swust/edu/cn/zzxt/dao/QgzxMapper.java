package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Qgzx;
import swust.edu.cn.zzxt.model.QgzxWithBLOBs;

public interface QgzxMapper {
    int deleteByPrimaryKey(Integer qgzxId);

    int insert(QgzxWithBLOBs record);

    int insertSelective(QgzxWithBLOBs record);

    QgzxWithBLOBs selectByPrimaryKey(Integer qgzxId);

    int updateByPrimaryKeySelective(QgzxWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QgzxWithBLOBs record);

    int updateByPrimaryKey(Qgzx record);
}