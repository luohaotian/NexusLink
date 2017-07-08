package com.controller;

import com.pojo.RecordDO;
import com.pojo.RecordVO;
import com.pojo.StudentDO;
import com.pojo.json.ResponseJson;
import com.service.OperateDataService;
import com.service.ShowDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
@Controller
@RequestMapping(value = "/api/show")
public class ShowController {

    @Resource
    private OperateDataService operateDataService;

    @Resource
    private ShowDataService showDataService;

    @ResponseBody
    @RequestMapping(value = "scorePage")
    public ResponseJson showScore(){
        int limit = 10;
        //List<RecordDO> result = showDataService.listRealTimeRecord(limit);
        List<RecordVO> result = showDataService.listRealTimeRecordVO(limit);
        int code = (null == result ? 500 : 200);
        return new ResponseJson(result, code);
    }

    @ResponseBody
    @RequestMapping(value = "studentsInfo")
    public ResponseJson studentsInfo(@RequestParam("classNumber") int classNumber, @RequestParam("limit" ) int limit, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(0 == limit) {
            List<StudentDO> result = showDataService.listStudentOfClass(classNumber);
            int code = ((result==null || result.size()<1) ? 500 : 200);
            return new ResponseJson(result, code);
        }else {
            List<RecordDO> result = showDataService.listRandomStudent(classNumber,limit);
            int code = ((result==null || result.size()<1) ? 500 : 200);
            return new ResponseJson(result, code);
        }
    }

}
