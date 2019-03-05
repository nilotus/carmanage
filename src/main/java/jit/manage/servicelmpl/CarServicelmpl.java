package jit.manage.servicelmpl;

import jit.manage.Dto.CarDto;
import jit.manage.mapper.CarMapper;
import jit.manage.pojo.Car;
import jit.manage.service.CarSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

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

    @Override
    public String selectAll(int page,int limit) {
        int count = carMapper.count();
        page = (page-1)*limit;
        MSG msg = new MSG(0,"",count,carMapper.selectAll(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();

    }


    @Override
    public String select(CarDto dto){
        int count = carMapper.count2(dto);
        int page = dto.getPage();
        int limit = dto.getLimit();
        page = (page-1)*limit;
        dto.setPage(page);
        dto.setLimit(limit);
        MSG msg = new MSG(0,"",count,carMapper.find(dto));
        System.out.println(dto.toString());
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public MSG update(String state,String number){
        if (carMapper.updateState(state, number)){
            return new MSG(1, "更新成功");
        }else
            return new MSG(-1, "更新失败");
    }
}
