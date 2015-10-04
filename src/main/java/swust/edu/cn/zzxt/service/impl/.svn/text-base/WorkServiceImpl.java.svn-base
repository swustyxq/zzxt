package swust.edu.cn.zzxt.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.WorkMapper;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.service.WorkService;

@Service("workService")
public class WorkServiceImpl implements WorkService{
	private WorkMapper workMapper;
	
	public WorkMapper getWorkMapper() {
        return workMapper;
    }
	@Autowired
    public void setWorkMapper(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }
	
	@SuppressWarnings("finally")
	public Work selectByWorkId(int workId) {
		Work work =null;
        try {
        	work = workMapper.selectByPrimaryKey(workId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return work;
        }
    }
	
	@SuppressWarnings("finally")
	public Work update(Work work) {
        try {
        	workMapper.updateByPrimaryKey(work);
        	work = workMapper.selectByPrimaryKey(work.getWorkId());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return work;
        }
    }
  /*  @SuppressWarnings("finally")
    public Learning obtainLearningByStudid(Integer learStudid) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return ;
        }
    }
*/
	@SuppressWarnings("finally")
	public List<Work> findAllwork(){
		List<Work> work = new ArrayList<Work>();
        try {
        	work = workMapper.selectAllWork();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return work;
        }
    }
    
}
