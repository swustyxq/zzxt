package swust.edu.cn.zzxt.selfmodel;

public class CzylCountModel {


    private String name;
    private int instid;
    private int applyYessum;
    private int sum;
    private int applyNosum;
    private int nullsum;
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public int getApplyYessum() {
        return applyYessum;
    }
    public void setApplyYessum(int applyYessum) {
        this.applyYessum = applyYessum;
    }
    public int getInstid() {
        return instid;
    }
    public void setInstid(int instid) {
        this.instid = instid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getApplyNosum() {
        return applyNosum;
    }
    public void setApplyNosum(int applyNosum) {
        this.applyNosum = applyNosum;
    }
    public int getNullsum() {
        return nullsum;
    }
    public void setNullsum(int nullsum) {
        this.nullsum = nullsum;
    }

}


