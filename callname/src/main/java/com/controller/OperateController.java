package com.controller;

import com.pojo.json.ResponseJson;
import com.service.OperateDataService;
import com.service.ShowDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
@Controller
@RequestMapping(value = "/api/operate")
public class OperateController {

    @Resource
    private OperateDataService operateDataService;

    @Resource
    private ShowDataService showDataService;

    @ResponseBody
    @RequestMapping(value = "markScore")
    public ResponseJson markScore(@RequestParam("id") int id, @RequestParam("sno")
            int sno ,@RequestParam("score") int score) {
        boolean flag = operateDataService.addScore(id, sno, score);
        int code = (flag == true ? 200 : 500);

        return new ResponseJson(flag, code);
    }
}
