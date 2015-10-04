package swust.edu.cn.zzxt.dao;

import swust.edu.cn.zzxt.model.Workinstitutiontemoneyamount;

public interface WorkinstitutiontemoneyamountMapper {
    int deleteByPrimaryKey(Integer wimaId);

    int insert(Workinstitutiontemoneyamount record);

    int insertSelective(Workinstitutiontemoneyamount record);

    Workinstitutiontemoneyamount selectByPrimaryKey(Integer wimaId);
    
    Workinstitutiontemoneyamount selectByInstAndWork(Workinstitutiontemoneyamount wism);

    int updateByPrimaryKeySelective(Workinstitutiontemoneyamount record);

    int updateByPrimaryKey(Workinstitutiontemoneyamount record);
}