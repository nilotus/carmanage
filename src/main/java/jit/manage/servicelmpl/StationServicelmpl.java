package jit.manage.servicelmpl;

import jit.manage.Dto.StaDto;
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
    public MSG insert(StaDto station){
        Route route = routeMapper.selectbyId(station.getRouteld());
        System.out.println(route.toString());
        if (route.getState().equals("0")){
            routeMapper.state1(route.getRouteId());
        }
        if (route.getDestination().equals(station.getPlace())) {
            System.out.println("目的地");
            routeMapper.state2(station.getRouteld(), station.getTime());
            return new MSG(1, "到达目的地，行程已结束");
        }else{
            Station station1 = new Station(station.getRouteld(),station.getPlace(),station.getTime());
            if (stationMapper.insert(station1)){
                if (routeMapper.cost(station.getRouteld(),station.getCost()))
                    return new MSG(1, "增加成功");
                return new MSG(-1, "增加失败");
            }

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
        return new MSG(1,"查询路线",stationMapper.state(id),stationMapper.route(id));
    }

    @Override
    public MSG routeids(){
        return new MSG(1,"查询执行中的ids",stationMapper.select1());
    }
}
