package jit.manage.servicelmpl;

import jit.manage.Dto.EventDto;
import jit.manage.mapper.EventMapper;
import jit.manage.pojo.Event;
import jit.manage.service.EventSerivce;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by sunlotus on 2019/2/25.
 */
@Service
public class EventServicelmpl implements EventSerivce{
    @Autowired
    private EventMapper eventMapper;

    @Override
    public MSG insert(Event event){
        String place = event.getEventPlace();
        place = place.substring(0,place.indexOf("市")+1);
        event.setPlace(place);
        System.out.println(event);
        if (eventMapper.add(event)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
    @Override
    public String selectAll(int page,int limit){
        int count = eventMapper.count();
        page = (page-1)*limit;
        MSG msg = new MSG(0,"",count,eventMapper.selectAll(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }
    @Override
    public String select(EventDto dto){
        int count = eventMapper.count2(dto);
        int page = dto.getPage();
        int limit = dto.getLimit();
        page = (page-1)*limit;
        dto.setPage(page);
        dto.setLimit(limit);
        MSG msg = new MSG(0,"",count,eventMapper.find(dto));
        System.out.println(dto.toString());
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public MSG kind(){
        return new MSG(1,"sucess",eventMapper.kind());
    }

    @Override
    public MSG place(){
        return new MSG(1,"sucess",eventMapper.place());
    }
}
