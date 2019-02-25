package jit.manage.controller;

import jit.manage.service.DriverSerivce;
import org.springframework.beans.factory.annotation.Autowired;
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
}
