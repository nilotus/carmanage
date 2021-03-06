package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Event {
    String carNumber;
    String eventTime;
    String place;
    String eventPlace;
    String eventKind;
    String driverIN;
    String eventReason;
    String eventInfo;

    public Event(String carNumber, String eventTime, String place, String eventPlace, String eventKind, String driverIN, String eventReason, String eventInfo) {
        this.carNumber = carNumber;
        this.eventTime = eventTime;
        this.place = place;
        this.eventPlace = eventPlace;
        this.eventKind = eventKind;
        this.driverIN = driverIN;
        this.eventReason = eventReason;
        this.eventInfo = eventInfo;
    }

    public Event(String carNumber, String eventTime, String eventPlace, String eventKind, String driverIN, String eventReason, String eventInfo) {
        this.carNumber = carNumber;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
        this.eventKind = eventKind;
        this.driverIN = driverIN;
        this.eventReason = eventReason;
        this.eventInfo = eventInfo;
    }

    public Event() {
    }


    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventKind() {
        return eventKind;
    }

    public void setEventKind(String eventKind) {
        this.eventKind = eventKind;
    }

    public String getDriverIN() {
        return driverIN;
    }

    public void setDriverIN(String driverIN) {
        this.driverIN = driverIN;
    }

    public String getEventReason() {
        return eventReason;
    }

    public void setEventReason(String eventReason) {
        this.eventReason = eventReason;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Event{" +
                "carNumber='" + carNumber + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", place='" + place + '\'' +
                ", eventPlace='" + eventPlace + '\'' +
                ", eventKind='" + eventKind + '\'' +
                ", driverIN='" + driverIN + '\'' +
                ", eventReason='" + eventReason + '\'' +
                ", eventInfo='" + eventInfo + '\'' +
                '}';
    }
}
