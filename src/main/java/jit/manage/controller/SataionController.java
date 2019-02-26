package jit.manage.controller;

import jit.manage.pojo.Station;
import jit.manage.service.StationSerivce;
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
}
