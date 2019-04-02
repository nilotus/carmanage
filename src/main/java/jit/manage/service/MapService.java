package jit.manage.service;

import jit.manage.util.MSG;
import org.springframework.stereotype.Service;

/**
 * Created by sunlotus on 2019/3/28.
 */
public interface MapService {
    MSG getmap(int begin,int end);
}
