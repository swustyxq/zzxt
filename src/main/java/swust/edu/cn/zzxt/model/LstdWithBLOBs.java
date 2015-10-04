package swust.edu.cn.zzxt.model;

public class LstdWithBLOBs extends Lstd {
    private String lstdNotloan;

    private String lstdClassopinion;

    private String lstdAcademyopinion;
    
    private String lstdApplyReason;
    private String lstdRepayWay;
    private String lstdDisaster;
    private String lstdPaymentReason;

   

	public String getLstdApplyReason() {
		return lstdApplyReason;
	}

	public void setLstdApplyReason(String lstdApplyReason) {
		this.lstdApplyReason = lstdApplyReason;
	}

	public String getLstdRepayWay() {
		return lstdRepayWay;
	}

	public void setLstdRepayWay(String lstdRepayWay) {
		this.lstdRepayWay = lstdRepayWay;
	}

	public String getLstdDisaster() {
		return lstdDisaster;
	}

	public void setLstdDisaster(String lstdDisaster) {
		this.lstdDisaster = lstdDisaster;
	}

	public String getLstdPaymentReason() {
		return lstdPaymentReason;
	}

	public void setLstdPaymentReason(String lstdPaymentReason) {
		this.lstdPaymentReason = lstdPaymentReason;
	}

	public String getLstdNotloan() {
        return lstdNotloan;
    }

    public void setLstdNotloan(String lstdNotloan) {
        this.lstdNotloan = lstdNotloan;
    }

    public String getLstdClassopinion() {
        return lstdClassopinion;
    }

    public void setLstdClassopinion(String lstdClassopinion) {
        this.lstdClassopinion = lstdClassopinion;
    }

    public String getLstdAcademyopinion() {
        return lstdAcademyopinion;
    }

    public void setLstdAcademyopinion(String lstdAcademyopinion) {
        this.lstdAcademyopinion = lstdAcademyopinion;
    }
}