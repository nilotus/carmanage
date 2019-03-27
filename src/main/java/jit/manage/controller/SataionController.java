package jit.manage.controller;

import jit.manage.Dto.PageDto;
import jit.manage.pojo.Station;
import jit.manage.service.StationSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/station")
public class SataionController {
    @Autowired
    private StationSerivce stationSerivce;
    @PostMapping("/selectAll")
    public MSG selectAll(){
        return stationSerivce.selectAll();
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Station station){
        return stationSerivce.insert(station);
    }

    @PostMapping("/route/{id}")
    public MSG route(@PathVariable("id")String id){
        return stationSerivce.route(id);
    }

    @PostMapping("/ids")
    public MSG routeids(){
        return stationSerivce.routeids();
    }
}
