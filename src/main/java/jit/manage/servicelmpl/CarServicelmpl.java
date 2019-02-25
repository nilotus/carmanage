package jit.manage.servicelmpl;

import jit.manage.mapper.CarMapper;
import jit.manage.pojo.Car;
import jit.manage.service.CarSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class CarServicelmpl implements CarSerivce{
    @Autowired
    private CarMapper carMapper;

    @Override
    public MSG insert (Car car){
        if (carMapper.add(car)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
}
