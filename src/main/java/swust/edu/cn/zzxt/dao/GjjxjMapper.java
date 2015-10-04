package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Gjjxj;
import swust.edu.cn.zzxt.model.GjjxjWithBLOBs;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.ListModal;

public interface GjjxjMapper {
    int deleteByPrimaryKey(Integer gjxjId);

    int insert(GjjxjWithBLOBs record);

    int insertSelective(GjjxjWithBLOBs record);

    GjjxjWithBLOBs selectByPrimaryKey(Integer gjxjId);

    int updateByPrimaryKeySelective(GjjxjWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GjjxjWithBLOBs record);

    int updateByPrimaryKey(Gjjxj record);

    Gjjxj selectGjjxjByStudid(Integer gjxjStudid);    

    List<GjjxjWithBLOBs> selectByStudid(Integer gjxjStudid);
    
    List<GjjxjWithBLOBs> selectAllInfo();
    
    List<ListModal> selectClassAllList(Integer userId);
    
    List<ListModal> selectAcademyAllList( Integer instId);

}