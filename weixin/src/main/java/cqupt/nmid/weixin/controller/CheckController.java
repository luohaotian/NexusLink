package cqupt.nmid.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 罗浩 on 2017/3/15.
 * description  对微信订阅号的认证
 */
@Controller
@RequestMapping (value="check")
public class CheckController {
    /**
     *
     * @param request
     * @param response
     */

    @RequestMapping(value="/auth",method = RequestMethod.GET)
    public void checkWeichat(HttpServletRequest request, HttpServletResponse response){

    }

}
