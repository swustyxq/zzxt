package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Learning;

public interface LearningMapper {
    int deleteByPrimaryKey(Integer learId);

    int insert(Learning record);

    int insertSelective(Learning record);

    Learning selectByPrimaryKey(Integer learId);

    int updateByPrimaryKeySelective(Learning record);

    int updateByPrimaryKey(Learning record);
    
    List<Learning> selectAllLearning(int stuId);

    Learning selectLearningByStudid(Integer learStudid);

    int updateByStudIdSelective(Learning learing);
}