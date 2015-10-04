package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Work;

public interface WorkService {

	public Work selectByWorkId(int workId);

	public Work update(Work work);

	public List<Work> findAllwork();

}
