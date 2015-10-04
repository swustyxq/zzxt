package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Qyshjxj;
import swust.edu.cn.zzxt.model.QyshjxjWithBLOBs;

public interface QyshjxjMapper {
    int deleteByPrimaryKey(Integer qysjId);

    int insert(QyshjxjWithBLOBs record);

    int insertSelective(QyshjxjWithBLOBs record);

    QyshjxjWithBLOBs selectByPrimaryKey(Integer qysjId);

    int updateByPrimaryKeySelective(QyshjxjWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QyshjxjWithBLOBs record);

    int updateByPrimaryKey(Qyshjxj record);

    QyshjxjWithBLOBs selectShjxjByStuId(Integer studId);//yang
}