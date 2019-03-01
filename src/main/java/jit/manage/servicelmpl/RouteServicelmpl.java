package jit.manage.servicelmpl;

import jit.manage.Dto.RouteDto;
import jit.manage.mapper.RouteMapper;
import jit.manage.pojo.Route;
import jit.manage.service.RouteSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        MSG msg = new MSG(0,"",count,routeMapper.selectAll(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }
    @Override
    public String select(RouteDto dto){
        int count = routeMapper.count2();
        int page = dto.getPage();
        int limit = dto.getLimit();
        page = (page-1)*limit;
        dto.setPage(page);
        dto.setLimit(limit);
        MSG msg = new MSG(0,"",count,routeMapper.find(dto));
        System.out.println(dto.toString());
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }
}
