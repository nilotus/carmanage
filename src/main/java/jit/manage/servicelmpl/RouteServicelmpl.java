package jit.manage.servicelmpl;

import jit.manage.Dto.RouteDto;
import jit.manage.Dto.TongjiDto;
import jit.manage.mapper.RouteMapper;
import jit.manage.pojo.Route;
import jit.manage.service.RouteSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class RouteServicelmpl implements RouteSerivce{
    @Autowired
    private RouteMapper routeMapper;

    @Override
    public MSG insert(Route route){
        if (routeMapper.add(route)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
    @Override
    public String selectAll(int page,int limit){
        int count = routeMapper.count();
        page = (page-1)*limit;
        List<Route> routes = routeMapper.selectAll(page, limit);
        for (Route route:routes){
            if (route.getState().equals("0"))
                route.setState("未开始");
            if (route.getState().equals("1"))
                route.setState("运行中");
            if (route.getState().equals("2"))
                route.setState("已结束");
            if (route.getState().equals("3"))
                route.setState("已取消");
        }
        MSG msg = new MSG(0,"",count,routes);
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public String select(RouteDto dto){
        int count = routeMapper.count2(dto);
        int page = dto.getPage();
        int limit = dto.getLimit();
        page = (page-1)*limit;
        dto.setPage(page);
        dto.setLimit(limit);
        List<Route> routes = routeMapper.find(dto);
        for (Route route:routes){
            if (route.getState().equals("0"))
                route.setState("未开始");
            if (route.getState().equals("1"))
                route.setState("运行中");
            if (route.getState().equals("2"))
                route.setState("已结束");
            if (route.getState().equals("3"))
                route.setState("已取消");
        }
        MSG msg = new MSG(0,"",count,routes);
        System.out.println(dto.toString());
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public String select1(int page,int limit){
        int count = routeMapper.count1();
        page = (page-1)*limit;
        MSG msg = new MSG(0,"",count,routeMapper.select1(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public String select2(int page,int limit){
        int count = routeMapper.count23();
        page = (page-1)*limit;
        List<Route> routes = routeMapper.select2(page, limit);
        List<Route> routes1 = new ArrayList<>();
        for (Route route:routes){
            if (route.getState().equals("2"))
                route.setState("已完成");
            if (route.getState().equals("3"))
                route.setState("已取消");
            routes1.add(route);
        }
        MSG msg = new MSG(0,"",count,routes1);
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public MSG state(String id){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(d);
        if (routeMapper.state(id,time)){
            return new MSG(1, "行程已结束");
        }else
            return new MSG(-1, "修改失败");
    }

    @Override
    public MSG routeTime(){
        String kind1 = "1天内行程";
        String kind2 = "1-3天行程";
        String kind3 = "3-7天行程";
        String kind4 = "7天外行程";
        List<TongjiDto> dtos =new ArrayList<>();
        TongjiDto dto = new TongjiDto(kind1,routeMapper.counta());
        TongjiDto dto2 = new TongjiDto(kind2,routeMapper.countb());
        TongjiDto dto3 = new TongjiDto(kind3,routeMapper.countc());
        TongjiDto dto4 = new TongjiDto(kind4,routeMapper.countd());
        dtos.add(dto);
        dtos.add(dto2);
        dtos.add(dto3);
        dtos.add(dto4);
        return new MSG(1, "sucess",dtos);
    }

    @Override
    public MSG cost(){
        int[] costs = new int[7];
        costs[0] = routeMapper.counta1();
        costs[1] = routeMapper.countb1();
        costs[2] = routeMapper.countc1();
        costs[3] = routeMapper.countd1();
        costs[4] = routeMapper.counte1();
        costs[5] = routeMapper.countf1();
        costs[6] = routeMapper.countg1();
        return new MSG(1,"sucess",costs);
    }
}
