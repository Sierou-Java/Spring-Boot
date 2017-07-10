package org.sierou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.sierou.core.Result;
import org.sierou.core.ResultCode;
import org.sierou.core.ServiceException;
import org.sierou.pojo.caution.TrafficCaution;
import org.sierou.service.caution.TrafficCautionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Reference;

/**
 * Created by wanghongyue on 2017/6/28.
 */
@RestController
@RequestMapping("/caution")
public class TrafficCautionController {

    @Reference(version = "3.0.0")
    private TrafficCautionService trafficCautionService;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value="测试", notes="测试用例")
    public Result test(){
        Result result = new Result();
        List<TrafficCaution> all = trafficCautionService.findAll();
        System.out.println("all :" + all);
        PageInfo<TrafficCaution> pageListByWhere = trafficCautionService.findPageListByWhere(0, -2, new TrafficCaution());
        List<TrafficCaution> list = pageListByWhere.getList();
        System.out.println("list.size = " + list.size());
        System.out.println(list);
        result.setData(list);
//        int a = 0;
//        int s = 1;
//        s = s/a;
        result.setCode(ResultCode.SUCCESS);
        return result;
    }

    @RequestMapping(value = "redis")
    public Result redis(){
        Result result = new Result();
//        stringRedisTemplate.boundValueOps("redis").set("redisvalue");
//        String stri = stringRedisTemplate.boundValueOps("redis").get();
//        System.out.println(stringRedisTemplate.boundValueOps("redis").get());
//        result.setData(stri);
        return result;
    }
}
