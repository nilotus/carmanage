package jit.manage.controller;

import jit.manage.Dto.EventDto;
import jit.manage.pojo.Event;
import jit.manage.service.EventSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventSerivce eventSerivce;
    @PostMapping("/selectAll")
    public String selectAll(@RequestParam int page, @RequestParam int limit){
        return eventSerivce.selectAll(page,limit);
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Event event){
        System.out.println(event.toString());
        return eventSerivce.insert(event);
    }

    @PostMapping("/select")
    public String select(@RequestBody EventDto dto){
        System.out.println(dto.toString());
        return eventSerivce.select(dto);
    }
}
