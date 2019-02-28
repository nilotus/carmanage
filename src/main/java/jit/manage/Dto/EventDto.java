package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class EventDto extends PageDto{
    String carNumber;
    String eventKind;
    String st;
    String et;

    public EventDto() {
    }

    public EventDto(String carNumber, String eventKind, String st, String et) {

        this.carNumber = carNumber;
        this.eventKind = eventKind;
        this.st = st;
        this.et = et;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEventKind() {
        return eventKind;
    }

    public void setEventKind(String eventKind) {
        this.eventKind = eventKind;
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

    @Override
    public String toString() {
        return "EventDto{" +
                "carNumber='" + carNumber + '\'' +
                ", eventKind='" + eventKind + '\'' +
                ", st='" + st + '\'' +
                ", et='" + et + '\'' +
                '}';
    }
}
