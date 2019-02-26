package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class CarDto extends extendDto{
    String CarNumber;
    String CarKind;
    String CarColor;
    Timestamp date;

    public CarDto( String carNumber, String carKind, String carColor, Timestamp date) {
        CarNumber = carNumber;
        CarKind = carKind;
        CarColor = carColor;
        this.date = date;
    }

    public CarDto() {
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

    public String getCarColor() {
        return CarColor;
    }

    public void setCarColor(String carColor) {
        CarColor = carColor;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
