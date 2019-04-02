package jit.manage.servicelmpl;

import jit.manage.mapper.MapMapper;
import jit.manage.service.MapService;
import jit.manage.util.Floyd;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunlotus on 2019/3/28.
 */
@Service
public class MapServicelmpl implements MapService{
    @Autowired
    private MapMapper mapMapper;

    @Override
    public MSG getmap(int begin, int end){
        String[] city = {"南京","无锡","徐州","常州","苏州","南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
        int[][] distances = new int[13][13];
        for (int i=0;i<13;i++){
            for (int j=0;j<13;j++){
                distances[i][j] = mapMapper.getdistance(city[i],city[j]);
            }
        }
//        for (int i=0;i<13;i++)
//            System.out.println(Arrays.toString(distances[i]));
        HashMap<String,Object> map = Floyd.test(distances,begin,end);
        List<Integer> list = (List<Integer>)map.get("path");
        String[] pcity = new String[list.size()];
        for (int i=0;i<list.size();i++){
            int t =list.get(i);
            String tt = city[t];
            pcity[i] = tt;
        }
        int length = (int)map.get("length");
        return new MSG(1,"已找到",length,pcity);

    }
}
