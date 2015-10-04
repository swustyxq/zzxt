package swust.edu.cn.zzxt.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.WorkstepfolwMapper;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

@Service("workstepflowService")
public class WorkstepfolwServiceImpl implements WorkstepfolwService{
	private WorkstepfolwMapper workstepfolwMapper;
  public WorkstepfolwMapper getWorkstepfolwMapper() {
		return workstepfolwMapper;
	}
  @Autowired
	public void setWorkstepfolwMapper(WorkstepfolwMapper workstepfolwMapper) {
		this.workstepfolwMapper = workstepfolwMapper;
	}
	/**
	 * 按辅导员兼职情况situid和workid查询第一步
	 * @author chenwenhui 2014 7 22
	 * */
	@SuppressWarnings("finally")
	public Workstepfolw getWsflIdByWorkidAndSituation(int workId, int situation)
	{
		Workstepfolw workstepfolw=null;
		try {
			int order=1;//第一步
			workstepfolw =new Workstepfolw();
			Workstepfolw workstep = new Workstepfolw();
			workstep.setWsflWorkid(workId);
			workstep.setWsflSituid(situation);
			workstep.setWsflOrder(order);
			workstepfolw = workstepfolwMapper.selectByWorkidAndSituationAndOrder(workstep).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			return workstepfolw;
		}
	}
	@SuppressWarnings("finally")
	public Workstepfolw findWslfByWslfId(Integer Wsflid)
	{
		Workstepfolw workstepfolw = null;
		try {
			workstepfolw = new Workstepfolw();
			workstepfolw=workstepfolwMapper.selectByPrimaryKey(Wsflid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return workstepfolw;
		}
	}
}
