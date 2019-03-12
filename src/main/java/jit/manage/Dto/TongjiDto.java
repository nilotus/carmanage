package jit.manage.Dto;

/**
 * Created by sunlotus on 2019/3/6.
 */
public class TongjiDto {
    private String kind;
    private int count;

    public TongjiDto(String kind, int count) {
        this.kind = kind;
        this.count = count;
    }

    public TongjiDto() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TongjiDto{" +
                "kind='" + kind + '\'' +
                ", count=" + count +
                '}';
    }
}
