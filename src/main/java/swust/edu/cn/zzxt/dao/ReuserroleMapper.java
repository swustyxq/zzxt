package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Reuserrole;

public interface ReuserroleMapper {
    int deleteByPrimaryKey(Integer reurId);

    int insert(Reuserrole record);

    int insertSelective(Reuserrole record);

    Reuserrole selectByPrimaryKey(Integer reurId);

    int updateByPrimaryKeySelective(Reuserrole record);

    int updateByPrimaryKey(Reuserrole record);
    
    List<Reuserrole> selectByUserId(int reurUserid);

    Reuserrole selectByUserAndRole(Reuserrole reuserrole);
}