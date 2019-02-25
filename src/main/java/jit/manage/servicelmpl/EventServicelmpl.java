package jit.manage.servicelmpl;

import jit.manage.mapper.EventMapper;
import jit.manage.pojo.Event;
import jit.manage.service.EventSerivce;
import jit.manage.util.MSG;
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
        if (eventMapper.insert(event)){
            return new MSG(1, "增加成功");
        }else
            return new MSG(-1, "增加失败");
    }
}
