package jit.manage.servicelmpl;

import jit.manage.Dto.CarDto;
import jit.manage.mapper.CarMapper;
import jit.manage.pojo.Car;
import jit.manage.service.CarSerivce;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class CarServicelmpl implements CarSerivce{
    @Autowired
    private CarMapper carMapper;

    @Override
    public MSG insert (Car car){
        if (carMapper.add(car)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
//    @Override
//    public MSG select(CarDto dto){
//        String sql ="select * from car ";
//        sql+= "where date between "+"'"+ dto.getSt()+"'"+" and "+"'"+ dto.getEt()+"'";
//        if (dto.getCarNumber().length()>0){
//            sql += " AND CarNumber = '"+dto.getCarNumber()+"'";
//        }
//        if (dto.getCarKind().length()>0){
//            sql += " AND CarKind = '"+dto.getCarKind()+"'";
//        }
//        if (dto.getCarColor().length()>0){
//            sql += " AND CarColor = '"+dto.getCarColor()+"'";
//        }
//        Query nativeQuery =
//    }

    @Override
    public MSG selectAll(){
        int count = carMapper.count();
        return new MSG(1,"查询所有车辆信息",count,carMapper.selectAll());
    }
}
