package jit.manage.controller;


import jit.manage.service.MapService;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunlotus on 2019/3/28.
 */
@RestController
@RequestMapping("/map")
public class MapController {
    @Autowired
    private MapService mapService;

    @PostMapping("/getmap")
    public MSG getmap(@RequestParam("begin")int begin, @RequestParam("end")int end){
        System.out.println("----------------------------"+begin);
        System.out.println("----------------------------"+end);
       return  mapService.getmap(begin, end);
    }
}
