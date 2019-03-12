package jit.manage.servicelmpl;

import jit.manage.Dto.CarDto;
import jit.manage.Dto.TongjiDto;
import jit.manage.mapper.CarMapper;
import jit.manage.pojo.Car;
import jit.manage.service.CarSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //近一年车辆类型统计
    @Override
    public MSG yearkind(){
        List<TongjiDto> dto = carMapper.yeark2();
        return new MSG(1,"sucess",dto);
    }
    //近一年车辆状态统计
    @Override
    public MSG yearkind2(){
        List<TongjiDto> dto = carMapper.years2();
        return new MSG(1,"sucess",dto);
    }
    //近一年某字段统计统计
    @Override
    public MSG yearkindn(String name){
        List<TongjiDto> dto = carMapper.yearKind(name);
        return new MSG(1,"sucess",dto);
    }

    //近7年车辆类型统计
    @Override
    public MSG countkind(){
        Map<String,Object> ck = new HashMap<>();
        //List<TongjiDto> dtos = carMapper.yearn(1);
        List<TongjiDto> ndtos = carMapper.yeark2();
        List<List<TongjiDto>> dtoss = new ArrayList<>();
        dtoss.add(ndtos);
        for (int i=1;i<7;i++){
            dtoss.add(carMapper.yeark(i));
        }
        Integer[] kind1 = new Integer[7];
        Integer[] kind2 = new Integer[7];
        Integer[] kind3 = new Integer[7];
        Integer[] kind4 = new Integer[7];
        for (int i=0;i<dtoss.size();i++){
            List<TongjiDto> dtos = dtoss.get(i);
            for(TongjiDto dto:dtos){
                if (dto.getKind().equals("微型车")){
                    kind1[i] = dto.getCount();
                }
                if (dto.getKind().equals("小型车")){
                    kind2[i] = dto.getCount();
                }
                if (dto.getKind().equals("中型车")){
                    kind3[i] = dto.getCount();
                }
                if (dto.getKind().equals("大型车")){
                    kind4[i] = dto.getCount();
                }
            }
        }
        ck.put("kind1",kind1);
        ck.put("kind2",kind2);
        ck.put("kind3",kind3);
        ck.put("kind4",kind4);
        return new MSG(1,"sucess",ck);
    }


    //近7年车辆状态统计
    @Override
    public MSG countstate(){
        Map<String,Object> ck = new HashMap<>();
        //List<TongjiDto> dtos = carMapper.yearn(1);
        List<TongjiDto> ndtos = carMapper.years2();
        List<List<TongjiDto>> dtoss = new ArrayList<>();
        dtoss.add(ndtos);
        for (int i=1;i<7;i++){
            dtoss.add(carMapper.years(i));
        }
        Integer[] kind1 = new Integer[7];
        Integer[] kind2 = new Integer[7];
        Integer[] kind3 = new Integer[7];
        Integer[] kind4 = new Integer[7];
        for (int i=0;i<dtoss.size();i++){
            List<TongjiDto> dtos = dtoss.get(i);
            for(TongjiDto dto:dtos){
                if (dto.getKind().equals("运行中")){
                    kind1[i] = dto.getCount();
                }
                if (dto.getKind().equals("报废")){
                    kind2[i] = dto.getCount();
                }
                if (dto.getKind().equals("维修")){
                    kind3[i] = dto.getCount();
                }
                if (dto.getKind().equals("丢失")){
                    kind4[i] = dto.getCount();
                }
            }
        }
        ck.put("kind1",kind1);
        ck.put("kind2",kind2);
        ck.put("kind3",kind3);
        ck.put("kind4",kind4);
        return new MSG(1,"sucess",ck);
    }
}
