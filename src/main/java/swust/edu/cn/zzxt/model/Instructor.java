package swust.edu.cn.zzxt.model;

public class Instructor {
    private Integer instId;

    private Integer instUserid;

    private String instPhonenumber;

    private String instDescription;

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Integer getInstUserid() {
        return instUserid;
    }

    public void setInstUserid(Integer instUserid) {
        this.instUserid = instUserid;
    }

    public String getInstPhonenumber() {
        return instPhonenumber;
    }

    public void setInstPhonenumber(String instPhonenumber) {
        this.instPhonenumber = instPhonenumber;
    }

    public String getInstDescription() {
        return instDescription;
    }

    public void setInstDescription(String instDescription) {
        this.instDescription = instDescription;
    }
}