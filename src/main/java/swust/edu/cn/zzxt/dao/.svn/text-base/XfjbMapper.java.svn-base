package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Xfjb;
import swust.edu.cn.zzxt.selfmodel.XfjbListModel;

public interface XfjbMapper {
    int deleteByPrimaryKey(Integer xfjbId);

    int insert(Xfjb record);

    int insertSelective(Xfjb record);

    Xfjb selectByPrimaryKey(Integer xfjbId);

    int updateByPrimaryKeySelective(Xfjb record);

    int updateByPrimaryKey(Xfjb record);

	List<XfjbListModel> findAllXfjbListByAll();

	List<XfjbListModel> findAllXfjbListByinstUserId(Integer userId);

	List<XfjbListModel> findAllXfjbListByinstId(Integer userInstid);

	List<XfjbListModel> findJbByConditions(XfjbListModel xfjbListModel);

	Xfjb findXfjbInfoByStuId(int studId);

	List<XfjbListModel> findJbListByStudentId(Integer userId);

	List<Xfjb> findXfjbListByClassId(Integer classId);

	List<Xfjb> findXfjbListByMajorId(Integer majrId);

	List<Xfjb> findXfjbListByInsId(Integer instId);
}