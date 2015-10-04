package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;

public interface StudentbasiinfoService {

	public List<Studentbasiinfo> findbasiinfoByinstUser(User instuser);

	public List<Studentbasiinfo> findbasiinfoByStudUser(User user);

	public List<Studentbasiinfo> findbasiinfoByOtherUser(User user);
	
}
