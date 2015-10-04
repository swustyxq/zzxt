package swust.edu.cn.zzxt.model;

import java.util.Date;

public class Work {
    private Integer workId;

    private Integer workFlag;

    private Date workStarttime;

    private Date workEndtime;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getWorkFlag() {
        return workFlag;
    }

    public void setWorkFlag(Integer workFlag) {
        this.workFlag = workFlag;
    }

    public Date getWorkStarttime() {
        return workStarttime;
    }

    public void setWorkStarttime(Date workStarttime) {
        this.workStarttime = workStarttime;
    }

    public Date getWorkEndtime() {
        return workEndtime;
    }

    public void setWorkEndtime(Date workEndtime) {
        this.workEndtime = workEndtime;
    }
}