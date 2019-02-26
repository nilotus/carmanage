package jit.manage.controller;

import jit.manage.pojo.Driver;
import jit.manage.service.DriverSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverSerivce driverSerivce;

    @PostMapping("/selectAll")
    public MSG selectAll(){
        return driverSerivce.selectAll();
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Driver driver){
        return driverSerivce.insert(driver);
    }
}
