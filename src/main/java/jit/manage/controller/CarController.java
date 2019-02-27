package jit.manage.controller;

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

    @PostMapping("/selectAll2")
    public String selectAll2(@RequestParam int page, @RequestParam int limit){

//        JSONObject object = JSONObject.fromObject(carSerivce.selectAll());
//        System.out.println(object);
//        return object;
        return carSerivce.selectAll2();
    }
    @PostMapping("/selectAll")
    public MSG selectAll(@RequestParam int page, @RequestParam int limit){
        return carSerivce.selectAll();

    }
    @PostMapping("/selectAll3")
    public MSG selectAll3(){
        return carSerivce.selectAll();

    }

    @PostMapping("/insert")
    public MSG insert(@RequestBody Car car){
        System.out.println(car.toString());
        return carSerivce.insert(car);
    }
}
