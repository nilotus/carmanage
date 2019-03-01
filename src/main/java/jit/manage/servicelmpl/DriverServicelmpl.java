package jit.manage.servicelmpl;

import jit.manage.Dto.DriverDto;
import jit.manage.mapper.DriverMapper;
import jit.manage.pojo.Driver;
import jit.manage.service.DriverSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;
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
        if (driverMapper.add(driver)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }

    @Override
    public String selectAll(int page,int limit){
        int count = driverMapper.count();
        page = (page-1)*limit;
        MSG msg = new MSG(0,"",count,driverMapper.selectAll(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }
    public String select(DriverDto dto){
        int count = driverMapper.count2(dto);
        int page = dto.getPage();
        int limit = dto.getLimit();
        page = (page-1)*limit;
        dto.setPage(page);
        dto.setLimit(limit);
        MSG msg = new MSG(0,"",count,driverMapper.find(dto));
        System.out.println(dto.toString());
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }
}
