package jit.manage.controller;

import jit.manage.service.RouteSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteSerivce routeSerivce;
}
