package swust.edu.cn.zzxt.model;

public class Situation {
    private Integer situId;

    private String situName;

    private Integer situRoleid;

    private String situDescription;

    public Integer getSituId() {
        return situId;
    }

    public void setSituId(Integer situId) {
        this.situId = situId;
    }

    public String getSituName() {
        return situName;
    }

    public void setSituName(String situName) {
        this.situName = situName;
    }

    public Integer getSituRoleid() {
        return situRoleid;
    }

    public void setSituRoleid(Integer situRoleid) {
        this.situRoleid = situRoleid;
    }

    public String getSituDescription() {
        return situDescription;
    }

    public void setSituDescription(String situDescription) {
        this.situDescription = situDescription;
    }
}