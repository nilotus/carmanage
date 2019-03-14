package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Route {
    String RouteId;
    String carNumber;
    String startTime;
    String startPlace;
    String endTime;
    String destination;
    String driverIN;
    int state;
    int cost;

    public Route() {
    }

    public Route(String routeId, String carNumber, String startTime, String startPlace, String endTime, String destination, String driverIN, int state, int cost) {
        RouteId = routeId;
        this.carNumber = carNumber;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endTime = endTime;
        this.destination = destination;
        this.driverIN = driverIN;
        this.state = state;
        this.cost = cost;
    }

    public Route(String carNumber, String startTime, String startPlace, String endTime, String destination, String driverIN, int state, int cost) {
        this.carNumber = carNumber;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endTime = endTime;
        this.destination = destination;
        this.driverIN = driverIN;
        this.state = state;
        this.cost = cost;
    }

    public String getRouteId() {
        return RouteId;
    }

    public void setRouteId(String routeId) {
        RouteId = routeId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
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

    @Override
    public String toString() {
        return "Route{" +
                "carNumber='" + carNumber + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startPlace='" + startPlace + '\'' +
                ", endTime='" + endTime + '\'' +
                ", destination='" + destination + '\'' +
                ", driverIN='" + driverIN + '\'' +
                ", state=" + state +
                ", cost=" + cost +
                '}';
    }
}
