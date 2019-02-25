package jit.manage.servicelmpl;

import jit.manage.mapper.DriverMapper;
import jit.manage.pojo.Driver;
import jit.manage.service.DriverSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class DriverServicelmpl implements DriverSerivce{
    @Autowired
    private DriverMapper driverMapper;

    @Override
    public MSG insert(Driver driver){
        if (driverMapper.insert(driver)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
}
