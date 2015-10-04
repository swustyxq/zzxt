package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.PrizeMapper;
import swust.edu.cn.zzxt.model.Prize;
import swust.edu.cn.zzxt.service.PrizService;

@Service("prizService")
public class PrizServiceImpl implements PrizService {
	private PrizeMapper prizeMapper;

	public PrizeMapper getPrizeMapper() {
		return prizeMapper;
	}

	@Autowired
	public void setPrizeMapper(PrizeMapper prizeMapper) {
		this.prizeMapper = prizeMapper;
	}

	@SuppressWarnings("finally")
	public Prize updateStuPrizInfo(String prizname, String prizlevel,
			String prizawarded, String priztime, int prizisIndividual,
			int prizStudId) {
		Prize prize = new Prize();
		try {
			prize.setPrizAwarded(prizawarded);
			prize.setPrizLevel(prizlevel);
			prize.setPrizName(prizname);
			prize.setPrizTime(priztime);
			prize.setPrizStudid(prizStudId);
			prize.setPrizIsindividual(prizisIndividual);
			prize.setPrizIseditable(1);
			prize.setPrizState(1);
			prizeMapper.insert(prize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return prize;
		}
	}

	@SuppressWarnings("finally")
	public List<Prize> findStuPrizInfoByprizStuId(int prizStudId) {
		List<Prize> prize = new ArrayList<Prize>();
		try {
			prize = prizeMapper.selectByPrizStudId(prizStudId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return prize;
		}
	}
	@SuppressWarnings("finally")
	public Prize deleteByPrizeId(int prizId)
	{
		Prize prize = new Prize();
		try {
			prizeMapper.deleteByPrimaryKey(prizId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return prize;
		}
	}
	@SuppressWarnings("finally")
	public Prize findPrizInfoByPrizId(int prizId)
	{
		Prize prize = new Prize();
		try {
			prize = prizeMapper.selectByPrimaryKey(prizId);
			System.out.println(prize.getPrizName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
		return prize;
		}
	}
	@SuppressWarnings("finally")
	public Prize EditPrizInfoByPrizId(int prizId, String prizname,
			String prizlevel, String prizawarded, String priztime,
			int prizisIndividual,int prizStudid){
		Prize prize= new Prize();
		try {
			prize.setPrizId(prizId);
			prize.setPrizName(prizname);
			prize.setPrizLevel(prizlevel);
			prize.setPrizAwarded(prizawarded);
			prize.setPrizName(prizname);
			prize.setPrizStudid(prizStudid);
			prize.setPrizIsindividual(prizisIndividual);
			prizeMapper.updateByPrimaryKeySelective(prize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return prize;
		}
		
	}

	@SuppressWarnings("finally")
	public List<Prize> findPrizInfoByStudId(Integer studId) {
		List<Prize> prize = new ArrayList<Prize>();
		try {
			prize = prizeMapper.selectByPrizStudId(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return prize;
		}
	}
	@SuppressWarnings("finally")
	public boolean updatePrize(Prize prize) {
		try {
		 prizeMapper.updateByPrimaryKeySelective(prize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return true;
		}
	}
}
