package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Function;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.NavigationModel;

public interface FunctionService {
	public List<NavigationModel> findFunListByUser(User user);

    public Function findFunctionById(Integer funcId);

    public List<Function> findAllFunction();//所有功能
}
