package jit.manage.servicelmpl;

import jit.manage.mapper.StationMapper;
import jit.manage.pojo.Station;
import jit.manage.service.StationSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class StationServicelmpl implements StationSerivce{
    @Autowired
    private StationMapper stationMapper;

    @Override
    public MSG insert(Station station){
        if (stationMapper.insert(station))
            return new MSG(1, "增加成功");
        else
            return new MSG(-1, "增加失败");
    }
    @Override
    public MSG selectAll(){
        return new MSG(1,"查询所有车辆信息",stationMapper.selectAll());
    }
}
