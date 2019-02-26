package jit.manage.controller;

import jit.manage.pojo.Route;
import jit.manage.service.RouteSerivce;
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
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteSerivce routeSerivce;

    @PostMapping("/selectAll")
    public MSG selectAll(){
        return routeSerivce.selectAll();
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Route route){
        return routeSerivce.insert(route);
    }
}
