package jit.manage.controller;

import jit.manage.pojo.Event;
import jit.manage.service.EventSerivce;
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
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventSerivce eventSerivce;
    @PostMapping("/selectAll")
    public MSG selectAll(){
        return eventSerivce.selectAll();
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Event event){
        return eventSerivce.insert(event);
    }
}
