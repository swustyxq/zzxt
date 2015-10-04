package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Learning;


public interface LearningService {

    public List<Learning> findAllLearning(int stuId);
    
    public void deleteLearingById(int id);

    public void addormodifyLearing(Boolean addormodify,String semester, 
            int graderank,int passcourse,int requiredcourse, int selectcourse, 
            int toatlNumber, String iscompreRank,int comprank,int comtotoalnumvalue,
            int stuId,Double gradepoint,Double requirepoint);

    public Learning obtainLearningByStudid(Integer learStudid);

    public Learning findOneLearningById(int id);

	public boolean updateLearning(Learning learning);

}
