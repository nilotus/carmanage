package jit.manage.servicelmpl;

import jit.manage.mapper.RouteMapper;
import jit.manage.mapper.StationMapper;
import jit.manage.pojo.Route;
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
    @Autowired
    private RouteMapper routeMapper;
    @Override
    public MSG insert(Station station){
        Route route = routeMapper.selectbyId(station.getRouteld());
        if (route.getDestination().equals(station.getPlace())) {
            System.out.println("目的地");
            routeMapper.state2(station.getRouteld(), station.getTime());
            return new MSG(1, "到达目的地，行程已结束");
        }else{  if (stationMapper.insert(station))
                return new MSG(1, "增加成功");
            else
                return new MSG(-1, "增加失败");
        }

    }
    @Override
    public MSG selectAll(){
        return new MSG(1,"查询所有车辆信息",stationMapper.selectAll());
    }

    @Override
    public MSG route(String id){
        return new MSG(1,"查询路线",stationMapper.route(id));
    }

    @Override
    public MSG routeids(){
        return new MSG(1,"查询执行中的ids",stationMapper.select1());
    }
}
