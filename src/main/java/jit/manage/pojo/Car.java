package jit.manage.pojo;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Car {
    String CarNumber;
    String CarKind;
    int CarSeat;
    String CarLoad;
    String CarFactory;
    String CarColor;
    String CarState;
    String CarOwner;
    String  CarON;
    String date;

    public Car(String carNumber, String carKind, int carSeat, String carLoad, String carFactory, String carColor, String carState, String carOwner, String carON, String date) {
        CarNumber = carNumber;
        CarKind = carKind;
        CarSeat = carSeat;
        CarLoad = carLoad;
        CarFactory = carFactory;
        CarColor = carColor;
        CarState = carState;
        CarOwner = carOwner;
        CarON = carON;
        this.date = date;
    }

    public Car(){

    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public String getCarKind() {
        return CarKind;
    }

    public void setCarKind(String carKind) {
        CarKind = carKind;
    }

    public int getCarSeat() {
        return CarSeat;
    }

    public void setCarSeat(int carSeat) {
        CarSeat = carSeat;
    }

    public String getCarLoad() {
        return CarLoad;
    }

    public void setCarLoad(String carLoad) {
        CarLoad = carLoad;
    }

    public String getCarFactory() {
        return CarFactory;
    }

    public void setCarFactory(String carFactory) {
        CarFactory = carFactory;
    }

    public String getCarColor() {
        return CarColor;
    }

    public void setCarColor(String carColor) {
        CarColor = carColor;
    }

    public String getCarState() {
        return CarState;
    }

    public void setCarState(String carState) {
        CarState = carState;
    }

    public String getCarOwner() {
        return CarOwner;
    }

    public void setCarOwner(String carOwner) {
        CarOwner = carOwner;
    }

    public String getCarON() {
        return CarON;
    }

    public void setCarON(String carON) {
        CarON = carON;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarNumber='" + CarNumber + '\'' +
                ", CarKind='" + CarKind + '\'' +
                ", CarSeat=" + CarSeat +
                ", CarLoad='" + CarLoad + '\'' +
                ", CarFactory='" + CarFactory + '\'' +
                ", CarColor='" + CarColor + '\'' +
                ", CarState='" + CarState + '\'' +
                ", CarOwner='" + CarOwner + '\'' +
                ", CarON='" + CarON + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
