package jit.manage.service;

import jit.manage.Dto.CarDto;
import jit.manage.pojo.Car;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface CarSerivce {
    MSG insert (Car car);
//    MSG select (CarDto dto);
    String selectAll(int page,int limit);
}
