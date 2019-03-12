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
        return carSerivce.insert(car);
    }


    @PostMapping("/select")
    public String select(@RequestBody CarDto dto){
        return carSerivce.select(dto);
    }

    @PostMapping("/update")
    public MSG update(@RequestParam String state, @RequestParam String number){
        return carSerivce.update(state, number);
    }

    //近一年车辆类型统计
    @PostMapping("/year")
    public MSG year(){
        return carSerivce.yearkind();
    }

    //近一年车辆状态统计
    @PostMapping("/year2")
    public MSG year2(){
        return carSerivce.yearkind2();
    }


    //根据字段来查询近一年该字段的统计信息
    @PostMapping("/yearn")
    public MSG yearn(@RequestParam String name){
        return carSerivce.yearkindn(name);
    }

    //近7年车辆类型统计
    @PostMapping("/countkind")
    public MSG countkind(){
        return carSerivce.countkind();
    }
    //近7年车辆状态统计
    @PostMapping("/countstate")
    public MSG countstate(){
        return carSerivce.countstate();
    }

}
