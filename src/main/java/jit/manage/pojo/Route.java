package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Route {
    String CarNumber;
    Timestamp StartTime;
    String StartPlace;
    Timestamp EndTime;
    String Destination;
    String DriverIN;
    int State;
    int Cost;

    public Route() {
    }

    public Route(String carNumber, Timestamp startTime, String startPlace, Timestamp endTime, String destination, String driverIN, int state, int cost) {
        CarNumber = carNumber;
        StartTime = startTime;
        StartPlace = startPlace;
        EndTime = endTime;
        Destination = destination;
        DriverIN = driverIN;
        State = state;
        Cost = cost;
    }


    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public Timestamp getStartTime() {
        return StartTime;
    }

    public void setStartTime(Timestamp startTime) {
        StartTime = startTime;
    }

    public String getStartPlace() {
        return StartPlace;
    }

    public void setStartPlace(String startPlace) {
        StartPlace = startPlace;
    }

    public Timestamp getEndTime() {
        return EndTime;
    }

    public void setEndTime(Timestamp endTime) {
        EndTime = endTime;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDriverIN() {
        return DriverIN;
    }

    public void setDriverIN(String driverIN) {
        DriverIN = driverIN;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }
}
