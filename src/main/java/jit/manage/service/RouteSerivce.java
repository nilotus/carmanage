package jit.manage.service;

import jit.manage.Dto.RouteDto;
import jit.manage.pojo.Route;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface RouteSerivce {
    MSG insert(Route route);
    String selectAll(int page,int limit);
    String select(RouteDto dto);
    String select1(int page,int limit);
    MSG state(String id);
    MSG routeTime();
}
