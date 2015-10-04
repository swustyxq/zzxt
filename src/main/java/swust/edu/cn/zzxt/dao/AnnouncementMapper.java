package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Announcement;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer annoId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer annoId);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
    
    List<Announcement> selectByannoAntpid(int annoAntpid);
    
    List<Announcement> selectAllAnnouncements();
}