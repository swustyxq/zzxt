package swust.edu.cn.zzxt.model;

public class PgsglWithBLOBs extends Pgsgl {
    private String pksgSituation;

    private String pksgApplyreason;

    private String pksgCommunityopinion;

    private String pksgAcademyopinion;

    private String pksgNote;

    public String getPksgSituation() {
        return pksgSituation;
    }

    public void setPksgSituation(String pksgSituation) {
        this.pksgSituation = pksgSituation;
    }

    public String getPksgApplyreason() {
        return pksgApplyreason;
    }

    public void setPksgApplyreason(String pksgApplyreason) {
        this.pksgApplyreason = pksgApplyreason;
    }

    public String getPksgCommunityopinion() {
        return pksgCommunityopinion;
    }

    public void setPksgCommunityopinion(String pksgCommunityopinion) {
        this.pksgCommunityopinion = pksgCommunityopinion;
    }

    public String getPksgAcademyopinion() {
        return pksgAcademyopinion;
    }

    public void setPksgAcademyopinion(String pksgAcademyopinion) {
        this.pksgAcademyopinion = pksgAcademyopinion;
    }

    public String getPksgNote() {
        return pksgNote;
    }

    public void setPksgNote(String pksgNote) {
        this.pksgNote = pksgNote;
    }
}