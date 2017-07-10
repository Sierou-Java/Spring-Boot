package org.sierou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.sierou.base.BaseServiceImpl;
import org.sierou.pojo.caution.TrafficCaution;
import org.sierou.service.caution.TrafficCautionService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wanghongyue on 2017/6/27.
 */
@Service(version = "3.0.0")
public class TrafficCautionServiceImpl extends BaseServiceImpl<TrafficCaution> implements TrafficCautionService {

}
