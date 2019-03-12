package jit.manage.service;

import jit.manage.Dto.EventDto;
import jit.manage.pojo.Event;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/25.
 */
public interface EventSerivce {
    MSG insert(Event event);
    String selectAll(int page,int limit);
    String select(EventDto dto);
    MSG kind();
}
