package org.sierou.controller.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wanghongyue on 2017/6/23.
 */
@RestController
@RequestMapping(value = "/home")
public class TestController {

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){
        request.setAttribute("home", "home");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("home", "home");
        return jsonObject.toJSONString();
    }
}
