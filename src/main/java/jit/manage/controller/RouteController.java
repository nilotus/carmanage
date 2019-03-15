package jit.manage.controller;

import jit.manage.Dto.RouteDto;
import jit.manage.pojo.Route;
import jit.manage.service.RouteSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteSerivce routeSerivce;

    @PostMapping("/selectAll")
    public String selectAll(@RequestParam int page, @RequestParam int limit){
        return routeSerivce.selectAll(page,limit);
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Route route){
        System.out.println(route.toString());
        return routeSerivce.insert(route);
    }

    @PostMapping("/select")
    public String select(@RequestBody RouteDto dto){
        System.out.println(dto.toString());
        return routeSerivce.select(dto);
    }

    @PostMapping("/select1")
    public String select1(@RequestParam int page, @RequestParam int limit){
        return routeSerivce.select1(page,limit);
    }

    @PostMapping("/state/{id}")
    public MSG state(@PathVariable("id")String id){
        return routeSerivce.state(id);
    }
}
