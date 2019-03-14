package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class RouteDto extends PageDto{
    String carNumber;
    String driverIN;
    String startTime;
    String endTime;
    String state;

    @Override
    public String toString() {
        return "RouteDto{" +
                "carNumber='" + carNumber + '\'' +
                ", driverIN='" + driverIN + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public RouteDto(String carNumber, String driverIN, String startTime, String endTime, String state) {
        this.carNumber = carNumber;
        this.driverIN = driverIN;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
