package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.LearningMapper;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.service.LearningService;

import java.lang.String;
import java.util.List;

@Service("learningService")
public class LearningServiceImpl implements LearningService {
	private LearningMapper learningMapper;

	public LearningMapper getLearningMapper() {
		return learningMapper;
	}

	@Autowired
	public void setLearningMapper(LearningMapper learningMapper) {
		this.learningMapper = learningMapper;
	}

	@SuppressWarnings("finally")
	public void addormodifyLearing(Boolean addormodify, String semester,
			int graderank, int passcourse, int requiredcourse,
			int selectcourse, int toatlNumber, String iscompreRank,
			int comprank, int comtotoalnumvalue, int stuId, Double gradepoint,
			Double requirepoint) {

		try {
			Learning learing = new Learning();
			// 学生自己填的数据
			learing.setLearRanking(graderank);
			learing.setLearTotalnumber(toatlNumber);
			learing.setLearEvaluationtype(iscompreRank);
			if (iscompreRank.equals("是")) {
				learing.setLearComprehensive(comprank);
				learing.setLearComprehensivetotal(comtotoalnumvalue);
			} else {
				learing.setLearComprehensive(null);
				learing.setLearComprehensivetotal(null);
			}
			// 教务处读入的数据
			learing.setLearSemester(semester);
			learing.setLearPassnumber(passcourse);
			learing.setLearRequirednumber(requiredcourse);
			learing.setLearSelectivesnumber(selectcourse);
			learing.setLearGradepoint(gradepoint);
			learing.setLearGradepointrequired(requirepoint);

			String firstyearString = semester.substring(0, 4);
			String lastyearString = semester.substring(5, 9);
			String UporDown = semester.substring(10, 11);
			learing.setLearFirstsemesteryear(Integer.parseInt(firstyearString));
			System.out.println(Integer.parseInt(firstyearString) + "顶呱呱");
			learing.setLearSecondsemesteryear(Integer.parseInt(lastyearString));
			System.out.println(Integer.parseInt(lastyearString) + "顶呱呱");
			learing.setLearSemestersequence(Integer.parseInt(UporDown));
			System.out.println(Integer.parseInt(UporDown) + "顶呱呱");
			// 从相关联的表中得到的数据
			learing.setLearStudid(stuId);

			learing.setLearIseditable(1);
			learing.setLearState(1);

			if (addormodify == true) {
				learningMapper.insert(learing);
				System.out.println("顶呱呱");
			} else {
				learningMapper.updateByStudIdSelective(learing);
				System.out.println("不呱呱");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return;
		}
	}

	@SuppressWarnings("finally")
	public List<Learning> findAllLearning(int stuId) {
		List<Learning> allLearning = null;
		try {
			allLearning = learningMapper.selectAllLearning(stuId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return allLearning;
		}
	}

	public void deleteLearingById(int id) {
		learningMapper.deleteByPrimaryKey(id);
	}

	@SuppressWarnings("finally")
	public Learning obtainLearningByStudid(Integer learStudid) {
		Learning learning = new Learning();
		try {
			learning = learningMapper.selectLearningByStudid(learStudid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return learning;
		}
	}

	@SuppressWarnings("finally")
	public Learning findOneLearningById(int id) {
		Learning learning = new Learning();
		try {
			learning = learningMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return learning;
		}
	}

	@SuppressWarnings("finally")
	public boolean updateLearning(Learning learning) {
		// TODO Auto-generated method stub
		try {
			learningMapper.updateByPrimaryKeySelective(learning);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return true;
		}
	}

}
