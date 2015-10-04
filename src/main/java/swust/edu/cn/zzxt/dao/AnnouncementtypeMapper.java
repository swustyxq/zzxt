package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Announcementtype;

public interface AnnouncementtypeMapper {
    int deleteByPrimaryKey(Integer antpId);

    int insert(Announcementtype record);

    int insertSelective(Announcementtype record);

    Announcementtype selectByPrimaryKey(Integer antpId);

    int updateByPrimaryKeySelective(Announcementtype record);

    int updateByPrimaryKeyWithBLOBs(Announcementtype record);

    int updateByPrimaryKey(Announcementtype record);
    
    List<Announcementtype> selectAllAnnoucementtype();
}