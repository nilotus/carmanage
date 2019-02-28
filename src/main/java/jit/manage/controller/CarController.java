package jit.manage.controller;

import jit.manage.Dto.CarDto;
import jit.manage.pojo.Car;
import jit.manage.service.CarSerivce;
import jit.manage.util.MSG;
//import net.sf.json.JSONObject;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarSerivce carSerivce;

    @PostMapping("/selectAll")
    public String selectAll(@RequestParam int page, @RequestParam int limit){
        return carSerivce.selectAll(page,limit);
    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Car car){
        System.out.println(car.toString());
        return carSerivce.insert(car);
    }


    @PostMapping("/select")
    public String select(@RequestBody CarDto dto){
        System.out.println(dto.toString());
        return carSerivce.select(dto);
    }

}
