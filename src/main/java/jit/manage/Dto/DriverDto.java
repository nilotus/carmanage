package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class DriverDto extends extendDto{
    String LN;
    String Name;
    String Sex;
    int Age;
    String LK;

    public String getLN() {
        return LN;
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getLK() {
        return LK;
    }

    public void setLK(String LK) {
        this.LK = LK;
    }

    public DriverDto() {

    }

    public DriverDto(String LN, String name, String sex, int age, String LK) {

        this.LN = LN;
        Name = name;
        Sex = sex;
        Age = age;
        this.LK = LK;
    }
}
