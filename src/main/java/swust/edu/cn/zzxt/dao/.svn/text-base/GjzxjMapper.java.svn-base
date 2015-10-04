package swust.edu.cn.zzxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swust.edu.cn.zzxt.model.Gjzxj;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.ListModal;

public interface GjzxjMapper {
    int deleteByPrimaryKey(Integer gzxjId);

    int insert(GjzxjWithBLOBs record);

    int insertSelective(GjzxjWithBLOBs record);

    GjzxjWithBLOBs selectByPrimaryKey(Integer gzxjId);
    
    List<GjzxjWithBLOBs> selectByStuId(Integer gzxjStuId);

    int updateByPrimaryKeySelective(GjzxjWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GjzxjWithBLOBs record);

    int updateByPrimaryKey(Gjzxj record);
    
    List<GjzxjWithBLOBs> selectAllInfo();
    
    List<ListModal> selectClassAllList(Integer userId);
    
    List<ListModal> selectAcademyAllList( Integer instId);
}