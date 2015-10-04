package swust.edu.cn.zzxt.model;

public class Area {
    private Integer areaId;

    private String areaName;

    private Integer areaParentid;

    private String areaCode;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaParentid() {
        return areaParentid;
    }

    public void setAreaParentid(Integer areaParentid) {
        this.areaParentid = areaParentid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}