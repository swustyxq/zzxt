package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.RewardMapper;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.service.RewardService;

@Service("/RewardService")
public class RewardServiceImpl implements RewardService {
	private RewardMapper rewardMapper;
	
	public RewardMapper getRewardMapper() {
		return rewardMapper;
	}@Autowired
	public void setRewardMapper(RewardMapper rewardMapper) {
		this.rewardMapper = rewardMapper;
	}
	public Reward inputRewardByWAW(Integer gjlzWorkid, Integer GjlzId,
			String rewrTime1, String rewrName1, String rewrAwarded1) {
		Reward reward = new Reward();
		if(rewrTime1 == ""){
			
		}
		else{	
			System.out.println(gjlzWorkid+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+GjlzId);
			reward.setRewrWorkid(gjlzWorkid);
			reward.setRewrScholarshipid(GjlzId.toString());
			reward.setRewrName(rewrName1);
			reward.setRewrTime(rewrTime1);
			reward.setRewrAwarded(rewrAwarded1);
			rewardMapper.insertSelective(reward);
		}
		return reward;
	}
	
	
	@SuppressWarnings("finally")
    public List<Reward> findRewardsByWorkId(Integer workId,String schoolershipId) {
        List<Reward> reward = new ArrayList<Reward>();
        Reward reward0 = new Reward();
        try {
        	reward0.setRewrWorkid(workId);
        	reward0.setRewrScholarshipid(schoolershipId);
            reward = rewardMapper.findRewardByWAW(reward0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return reward;
        }
    }
	
	@SuppressWarnings("finally")
    public boolean deleteRewardById(Integer rewrId) {;
        try {
            rewardMapper.deleteByPrimaryKey(rewrId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return true;
        }
    }
	
	
	@SuppressWarnings("finally")
    public void insert(Reward reward) {;
        try {
            rewardMapper.insert(reward);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return;
        }
    }
}
