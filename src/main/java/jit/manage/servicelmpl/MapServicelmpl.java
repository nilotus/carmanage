package jit.manage.servicelmpl;

import jit.manage.mapper.MapMapper;
import jit.manage.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by sunlotus on 2019/3/28.
 */
@Service
public class MapServicelmpl implements MapService{
    @Autowired
    private MapMapper mapMapper;

    @Override
    public void getmap(){
        String[] city = {"南京","无锡","徐州","常州","苏州","南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
        long[][] distances = new long[13][13];
        for (int i=0;i<13;i++){
            for (int j=0;j<13;j++){
                distances[i][j] = mapMapper.getdistance(city[i],city[j]);
            }
        }
        for (int i=0;i<13;i++)
            System.out.println(Arrays.toString(distances[i]));
    }
}
