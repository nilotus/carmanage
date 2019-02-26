package jit.manage.util;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * Created by sunlotus on 2019/2/21.
 */
public class MSG {
    private int code;
    private String msg;
    private Object data;
    private int count;

    public MSG(){}

    public MSG(int code, String msg, int count,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }


    public MSG(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public MSG(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
