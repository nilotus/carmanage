package jit.manage.pojo;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Station {
    int StationId;
    int Routeld;
    String Place;
    Timestamp time;

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
    }

    public int getRouteld() {
        return Routeld;
    }

    public void setRouteld(int routeld) {
        Routeld = routeld;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Station() {

    }

    public Station(int stationId, int routeld, String place, Timestamp time) {

        StationId = stationId;
        Routeld = routeld;
        Place = place;
        this.time = time;
    }
}
