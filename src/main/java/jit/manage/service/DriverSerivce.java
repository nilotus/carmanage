package jit.manage.service;

import jit.manage.pojo.Driver;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface DriverSerivce {
    MSG insert(Driver driver);
    MSG selectAll();
}
