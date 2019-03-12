package jit.manage.pojo;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class Driver {
    String LN;
    String name;
    String sex;
    String age;
    String phone;
    String LK;
    String date;

    public Driver() {
    }

    public Driver(String LN, String name, String sex, String age, String phone, String LK) {

        this.LN = LN;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.LK = LK;

    }

    public Driver(String LN, String name, String sex, String age, String phone, String LK, String date) {
        this.LN = LN;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.LK = LK;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "LN='" + LN + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", LK='" + LK + '\'' +
                '}';
    }

    public String getLN() {
        return LN;
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLK() {
        return LK;
    }

    public void setLK(String LK) {
        this.LK = LK;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
