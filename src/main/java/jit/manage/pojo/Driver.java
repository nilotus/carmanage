package jit.manage.pojo;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Driver {
    String LN;
    String Name;
    String Sex;
    int Age;
    String Phone;
    String LK;

    public Driver(String LN, String name, String sex, int age, String phone, String LK) {
        this.LN = LN;
        Name = name;
        Sex = sex;
        Age = age;
        Phone = phone;
        this.LK = LK;
    }

    public Driver() {
    }

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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLK() {
        return LK;
    }

    public void setLK(String LK) {
        this.LK = LK;
    }
}
