package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/3/14.
 */
public class StationDto {

    private String CarNumber;
    private String DriverIN;
    private String Name;
    private String StartPlace;
    private String StartTime;
    private String Place;
    private String Time;

    public StationDto(String carNumber, String driverIN, String name, String startPlace, String startTime, String place, String time) {
        CarNumber = carNumber;
        DriverIN = driverIN;
        Name = name;
        StartPlace = startPlace;
        StartTime = startTime;
        Place = place;
        Time = time;
    }

    public StationDto() {
    }

    public String getDriverIN() {
        return DriverIN;
    }

    public void setDriverIN(String driverIN) {
        DriverIN = driverIN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartPlace() {
        return StartPlace;
    }

    public void setStartPlace(String startPlace) {
        StartPlace = startPlace;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "CarNumber='" + CarNumber + '\'' +
                ", DriverIN='" + DriverIN + '\'' +
                ", Name='" + Name + '\'' +
                ", StartPlace='" + StartPlace + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", Place='" + Place + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
