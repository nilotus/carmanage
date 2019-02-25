package jit.manage.servicelmpl;

import jit.manage.mapper.RouteMapper;
import jit.manage.pojo.Route;
import jit.manage.service.RouteSerivce;
import jit.manage.util.MSG;
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
        if (routeMapper.insert(route)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
}
