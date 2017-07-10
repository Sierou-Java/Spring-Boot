package org.sierou.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.sierou.pojo.caution.TrafficCaution;
import org.sierou.service.caution.TrafficCautionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanghongyue on 2017/6/27.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TrafficCautionService trafficCautionService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/admin")
    public String test(){
        List<TrafficCaution> all = trafficCautionService.findAll();
        System.out.println("all = " + all);
        PageInfo<TrafficCaution> pageListByWhere = trafficCautionService.findPageListByWhere(0, 2, new TrafficCaution());
        List<TrafficCaution> list = pageListByWhere.getList();
        System.out.println("list.size = " + list.size());
        System.out.println(list);
        stringRedisTemplate.opsForValue().set("hh", "hello redis!");
        String hh = stringRedisTemplate.opsForValue().get("hh");
        System.out.println(hh);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("all", all);
        return jsonObject.toString();
    }
}
