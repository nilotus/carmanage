package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class DriverDto extends PageDto{
    String LN;
    String LK;

    public DriverDto() {
    }

    public DriverDto(String LN, String LK) {
        this.LN = LN;
        this.LK = LK;
    }

    public String getLN() {

        return LN;
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public String getLK() {
        return LK;
    }

    public void setLK(String LK) {
        this.LK = LK;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "LN='" + LN + '\'' +
                ", LK='" + LK + '\'' +
                '}';
    }
}
