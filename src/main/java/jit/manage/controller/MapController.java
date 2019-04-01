package jit.manage.controller;


import jit.manage.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void getmap(){
        mapService.getmap();
    }
}
