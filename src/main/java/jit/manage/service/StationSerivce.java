package jit.manage.service;

import jit.manage.pojo.Station;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface StationSerivce {
    MSG insert(Station station);
    MSG selectAll();
}
