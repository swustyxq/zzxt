package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Regjzxjparent;

public interface RegjzxjparentMapper {
    int deleteByPrimaryKey(Integer regpId);

    int insert(Regjzxjparent record);

    int insertSelective(Regjzxjparent record);

    Regjzxjparent selectByPrimaryKey(Integer regpId);

    int updateByPrimaryKeySelective(Regjzxjparent record);

    int updateByPrimaryKey(Regjzxjparent record);
}