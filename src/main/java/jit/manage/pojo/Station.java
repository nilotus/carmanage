package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Station {
    private String routeld;
    private String place;
    private String time;

    public Station(String routeld, String place, String time) {
        this.routeld = routeld;
        this.place = place;
        this.time = time;
    }

    public Station() {
    }

    public String getRouteld() {
        return routeld;
    }

    public void setRouteld(String routeld) {
        this.routeld = routeld;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Station{" +
                "routeld=" + routeld +
                ", place='" + place + '\'' +
                ", time=" + time +
                '}';
    }
}
