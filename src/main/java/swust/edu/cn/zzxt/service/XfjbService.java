package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Xfjb;
import swust.edu.cn.zzxt.selfmodel.XfjbListModel;
import swust.edu.cn.zzxt.selfmodel.XfjbTjModel;

public interface XfjbService {
	List<XfjbListModel> findAllXfjbList(User user);

	List<XfjbListModel> selectJbByConditions(XfjbListModel xfjbListModel);

	Xfjb findjbInfoByStuId(int studId);

	List<XfjbTjModel> findXfjbCountInfo(User user);
}
