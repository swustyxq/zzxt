package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Reward;

public interface RewardService {

	Reward inputRewardByWAW(Integer gjlzWorkid, Integer GjlzId,
			String rewrTime1, String rewrName1, String rewrAwarded1);
 

	List<Reward> findRewardsByWorkId(Integer workId,String schoolershipId);
	
	boolean deleteRewardById(Integer rewrId);
	
	void insert(Reward reward);
	
}
   