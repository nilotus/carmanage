package jit.manage.service;

import jit.manage.Dto.StaDto;
import jit.manage.pojo.Station;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface StationSerivce {
    MSG insert(StaDto station);
    MSG selectAll();
    MSG route(String id);
    MSG routeids();
}
