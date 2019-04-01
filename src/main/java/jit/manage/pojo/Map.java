package jit.manage.pojo;

/**
 * Created by sunlotus on 2019/3/27.
 */
public class Map {
    String sp;
    String ep;
    long distance;

    public Map(String sp, String ep, long distance) {
        this.sp = sp;
        this.ep = ep;
        this.distance = distance;
    }

    public Map() {
    }

    public String getSp() {

        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Map{" +
                "sp='" + sp + '\'' +
                ", ep='" + ep + '\'' +
                ", distance=" + distance +
                '}';
    }
}
