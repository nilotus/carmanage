package jit.manage.Dto;

import java.sql.Timestamp;

/**
 * Created by sunlotus on 2019/2/25.
 */
public class extendDto {
    Timestamp st;
    Timestamp et;

    public Timestamp getSt() {
        return st;
    }

    public void setSt(Timestamp st) {
        this.st = st;
    }

    public Timestamp getEt() {
        return et;
    }

    public void setEt(Timestamp et) {
        this.et = et;
    }
}
