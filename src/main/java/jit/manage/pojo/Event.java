package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Event {
    String CarNumber;
    Timestamp EventTime;
    String EventPlace;
    String EventKind;
    String DriverIN;
    String EventReason;
    String EventInfo;

    public Event(String carNumber, Timestamp eventTime, String eventPlace, String eventKind, String driverIN, String eventReason, String eventInfo) {
        CarNumber = carNumber;
        EventTime = eventTime;
        EventPlace = eventPlace;
        EventKind = eventKind;
        DriverIN = driverIN;
        EventReason = eventReason;
        EventInfo = eventInfo;
    }

    public Event() {
    }


    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public Timestamp getEventTime() {
        return EventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        EventTime = eventTime;
    }

    public String getEventPlace() {
        return EventPlace;
    }

    public void setEventPlace(String eventPlace) {
        EventPlace = eventPlace;
    }

    public String getEventKind() {
        return EventKind;
    }

    public void setEventKind(String eventKind) {
        EventKind = eventKind;
    }

    public String getDriverIN() {
        return DriverIN;
    }

    public void setDriverIN(String driverIN) {
        DriverIN = driverIN;
    }

    public String getEventReason() {
        return EventReason;
    }

    public void setEventReason(String eventReason) {
        EventReason = eventReason;
    }

    public String getEventInfo() {
        return EventInfo;
    }

    public void setEventInfo(String eventInfo) {
        EventInfo = eventInfo;
    }
}
