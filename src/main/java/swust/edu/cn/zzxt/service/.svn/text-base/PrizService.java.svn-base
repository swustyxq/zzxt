package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Prize;

public interface PrizService {
	public Prize updateStuPrizInfo(String prizname, String prizlevel,
			String prizawarded, String priztime, int prizisIndividual,
			int prizStudId);

	public List<Prize> findStuPrizInfoByprizStuId(int prizStudId);

	public Prize deleteByPrizeId(int prizId);

	public Prize findPrizInfoByPrizId(int prizId);

	public Prize EditPrizInfoByPrizId(int prizId, String prizname,
			String prizlevel, String prizawarded, String priztime,
			int prizisIndividual, int prizStudid);

	public List<Prize> findPrizInfoByStudId(Integer studId);

	public boolean updatePrize(Prize prize);


}
