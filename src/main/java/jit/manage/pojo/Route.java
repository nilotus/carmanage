package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Route {
    String carNumber;
    String st;
    String startPlace;
    String et;
    String destination;
    String driverIN;
    int state;
    int cost;

    public Route() {
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriverIN() {
        return driverIN;
    }

    public void setDriverIN(String driverIN) {
        this.driverIN = driverIN;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Route(String carNumber, String st, String startPlace, String et, String destination, String driverIN, int state, int cost) {

        this.carNumber = carNumber;
        this.st = st;
        this.startPlace = startPlace;
        this.et = et;
        this.destination = destination;
        this.driverIN = driverIN;
        this.state = state;
        this.cost = cost;
    }
}
