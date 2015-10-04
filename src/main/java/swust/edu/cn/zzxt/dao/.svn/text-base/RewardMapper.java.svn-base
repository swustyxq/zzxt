package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Reward;

public interface RewardMapper {
    int deleteByPrimaryKey(Integer rewrId);

    int insert(Reward record);

    int insertSelective(Reward record);

    Reward selectByPrimaryKey(Integer rewrId);
    
    List<Reward> selectByWorkId(Integer workId,String schoolershipId);

    int updateByPrimaryKeySelective(Reward record);

    int updateByPrimaryKey(Reward record);

	List<Reward> findRewardByWAW(Reward reward);
	
}