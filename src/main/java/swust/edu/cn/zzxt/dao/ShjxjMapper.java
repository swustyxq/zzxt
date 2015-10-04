package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Shjxj;
import swust.edu.cn.zzxt.model.ShjxjWithBLOBs;

public interface ShjxjMapper {
    int deleteByPrimaryKey(Integer sjxjId);

    int insert(ShjxjWithBLOBs record);

    int insertSelective(ShjxjWithBLOBs record);

    ShjxjWithBLOBs selectByPrimaryKey(Integer sjxjId);

    int updateByPrimaryKeySelective(ShjxjWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShjxjWithBLOBs record);

    int updateByPrimaryKey(Shjxj record);

    ShjxjWithBLOBs selectShjxjByStuId(Integer sjxjStudid);

    int updateByStudIdSelective(ShjxjWithBLOBs shjxj);

    List<ShjxjWithBLOBs> selectAllShjxj();

}