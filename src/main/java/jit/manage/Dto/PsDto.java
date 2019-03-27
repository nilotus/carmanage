package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/3/27.
 */
public class PsDto {
    String userid;
    String ops;
    String nps;

    public PsDto(String userid, String ops, String nps) {
        this.userid = userid;
        this.ops = ops;
        this.nps = nps;
    }

    public PsDto() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public String getNps() {
        return nps;
    }

    public void setNps(String nps) {
        this.nps = nps;
    }

    @Override
    public String toString() {
        return "PsDto{" +
                "userid='" + userid + '\'' +
                ", ops='" + ops + '\'' +
                ", nps='" + nps + '\'' +
                '}';
    }
}
