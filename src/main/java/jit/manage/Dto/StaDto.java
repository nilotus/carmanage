package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/4/4.
 */
public class StaDto {
    private String routeld;
    private String place;
    private String time;
    private String cost;

    public StaDto(String routeld, String place, String time, String cost) {
        this.routeld = routeld;
        this.place = place;
        this.time = time;
        this.cost = cost;
    }

    public StaDto() {
    }

    @Override
    public String toString() {
        return "StaDto{" +
                "routeld='" + routeld + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", cost='" + cost + '\'' +
                '}';
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
