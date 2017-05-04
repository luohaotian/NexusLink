package cn.nexuslink.controller;

import cn.nexuslink.pojo.Member;
import cn.nexuslink.pojo.constant.StatusCode;
import cn.nexuslink.pojo.group.AddMember;
import cn.nexuslink.pojo.group.LoginMember;
import cn.nexuslink.pojo.json.ResponseJson;
import cn.nexuslink.service.impl.CacheService;
import cn.nexuslink.service.impl.MemberService;
import cn.nexuslink.utils.CookieUtil;
import cn.nexuslink.utils.HashPasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static cn.nexuslink.pojo.constant.StatusCode.TOKEN_NOT_EXIST;


/**
 * Created by 罗浩 on 2017/4/27.
 */
@Controller
@RequestMapping(value = "/api/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @Resource
    private CacheService cacheService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public @ResponseBody ResponseJson register(@Validated({AddMember.class}) Member member,@RequestParam("resetPassword")String resetPassword, HttpServletResponse response) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

        if(!member.getPassword().equals(resetPassword))
            return new ResponseJson(StatusCode.UNPROCESABLE_ENTITY.getCode(), StatusCode.UNPROCESABLE_ENTITY.getMessage(), "两次密码不一致！");
        member.setPassword(HashPasswordUtil.createPasswordHash(resetPassword));
        Member mb = memberService.addMember(member);
        if (null != mb) {
            //将注册成功的成员对象token存入cookie中
            String token = mb.getUuid();
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
            response.flushBuffer();

            //本地缓存token
            cacheService.addToCache("tokenCache", token, mb);
            return new ResponseJson(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(), mb);
        }
        return new ResponseJson(StatusCode.INTERNAL_SERVER_ERROR.getCode(), StatusCode.INTERNAL_SERVER_ERROR.getMessage(), "注册成员失败！");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson login(@Validated({LoginMember.class}) Member member,HttpServletResponse response) throws IOException {
        Member mb = memberService.ensureMember(member.getRealname(),member.getPassword());
        if (null != mb) {
            //将注册成功的成员对象token存入cookie中
            String token = mb.getUuid();
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
            response.flushBuffer();

            //本地缓存token
            cacheService.addToCache("tokenCache", token, mb);
            return new ResponseJson(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), mb);
        }
        return new ResponseJson(StatusCode.UNPROCESABLE_ENTITY.getCode(), StatusCode.UNPROCESABLE_ENTITY.getMessage(), "用户验证失败！");
    }


    @RequestMapping(value = "/alterInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson alterInfo(Member member, HttpServletRequest request){
        Cookie cookie = CookieUtil.getCookieByKey(request, "token");
        if (cookie==null) {
            return new ResponseJson(TOKEN_NOT_EXIST.getCode(), TOKEN_NOT_EXIST.getMessage(), "token不存在，请重新登陆！");
        }
        System.out.print(cookie.getName()  +  cookie.getValue());
        member.setUuid(cookie.getValue());
        System.out.println(member.getRealname()+":"+member.getLoginname()+":" +member.getUuid());
        if (memberService.updateMember(member))
            return new ResponseJson(StatusCode.CREATED.getCode(),StatusCode.CREATED.getMessage(),member);
        return new ResponseJson(StatusCode.INTERNAL_SERVER_ERROR.getCode(),StatusCode.INTERNAL_SERVER_ERROR.getMessage(),"服务器内部更新失败！");
    }

}

