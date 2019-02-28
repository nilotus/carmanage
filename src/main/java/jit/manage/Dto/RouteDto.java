package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class RouteDto extends PageDto{
    String carNumber;
    String driverIN;
    String st;
    String et;
    String state;

    @Override
    public String toString() {
        return "RouteDto{" +
                "carNumber='" + carNumber + '\'' +
                ", driverIN='" + driverIN + '\'' +
                ", st='" + st + '\'' +
                ", et='" + et + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public RouteDto(String carNumber, String driverIN, String st, String et, String state) {
        this.carNumber = carNumber;
        this.driverIN = driverIN;
        this.st = st;
        this.et = et;
        this.state = state;
    }

    public RouteDto() {

    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDriverIN() {
        return driverIN;
    }

    public void setDriverIN(String driverIN) {
        this.driverIN = driverIN;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
