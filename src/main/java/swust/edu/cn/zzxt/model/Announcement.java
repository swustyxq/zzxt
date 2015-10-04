package swust.edu.cn.zzxt.model;

import java.util.Date;

public class Announcement {
    private Integer annoId;

    private String annoContent;

    private String annoTitle;

    private Date annoPublishtime;

    private Date annoLastmodifytime;

    private Integer annoUserid;

    private Integer annoIsdeleted;

    private Integer annoAntpid;

    public Integer getAnnoId() {
        return annoId;
    }

    public void setAnnoId(Integer annoId) {
        this.annoId = annoId;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
    }

    public String getAnnoTitle() {
        return annoTitle;
    }

    public void setAnnoTitle(String annoTitle) {
        this.annoTitle = annoTitle;
    }

    public Date getAnnoPublishtime() {
        return annoPublishtime;
    }

    public void setAnnoPublishtime(Date annoPublishtime) {
        this.annoPublishtime = annoPublishtime;
    }

    public Date getAnnoLastmodifytime() {
        return annoLastmodifytime;
    }

    public void setAnnoLastmodifytime(Date annoLastmodifytime) {
        this.annoLastmodifytime = annoLastmodifytime;
    }

    public Integer getAnnoUserid() {
        return annoUserid;
    }

    public void setAnnoUserid(Integer annoUserid) {
        this.annoUserid = annoUserid;
    }

    public Integer getAnnoIsdeleted() {
        return annoIsdeleted;
    }

    public void setAnnoIsdeleted(Integer annoIsdeleted) {
        this.annoIsdeleted = annoIsdeleted;
    }

    public Integer getAnnoAntpid() {
        return annoAntpid;
    }

    public void setAnnoAntpid(Integer annoAntpid) {
        this.annoAntpid = annoAntpid;
    }
}