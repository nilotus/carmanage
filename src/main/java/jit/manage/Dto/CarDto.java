package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class CarDto extends PageDto{
    String carNumber;
    String carKind;
    String st;
    String et;
//    String CarColor;
//    Timestamp date;


    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public CarDto(String carNumber, String carKind, String st, String et) {

        this.carNumber = carNumber;
        this.carKind = carKind;
        this.st = st;
        this.et = et;
    }

    public CarDto() {
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarKind() {
        return carKind;
    }

    public void setCarKind(String carKind) {
        this.carKind = carKind;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carNumber='" + carNumber + '\'' +
                ", carKind='" + carKind + '\'' +
                ", st='" + st + '\'' +
                ", et='" + et + '\'' +
                '}';
    }
}
