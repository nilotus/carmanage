package jit.manage.controller;

import jit.manage.Dto.DriverDto;
import jit.manage.pojo.Driver;
import jit.manage.service.DriverSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverSerivce driverSerivce;

    @PostMapping("/selectAll")
    public String selectAll(@RequestParam int page, @RequestParam int limit){
        return driverSerivce.selectAll(page,limit);
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Driver driver){
        System.out.println(driver.toString());
        return driverSerivce.insert(driver);
    }

    @PostMapping("/select")
    public String select(@RequestBody DriverDto dto){
        System.out.println(dto.toString());
        System.out.println(dto.getPage());
        System.out.println(dto.getLimit());
        return driverSerivce.select(dto);
    }
}
