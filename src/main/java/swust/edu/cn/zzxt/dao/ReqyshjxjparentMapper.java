package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Reqyshjxjparent;

public interface ReqyshjxjparentMapper {
    int deleteByPrimaryKey(Integer reqpId);

    int insert(Reqyshjxjparent record);

    int insertSelective(Reqyshjxjparent record);

    Reqyshjxjparent selectByPrimaryKey(Integer reqpId);

    int updateByPrimaryKeySelective(Reqyshjxjparent record);

    int updateByPrimaryKey(Reqyshjxjparent record);
}