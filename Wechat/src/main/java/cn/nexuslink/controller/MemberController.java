package cn.nexuslink.controller;

import cn.nexuslink.dao.IMemberDao;
import cn.nexuslink.pojo.Member;
import cn.nexuslink.pojo.constant.StatusCode;
import cn.nexuslink.pojo.group.AddMember;
import cn.nexuslink.pojo.group.LoginMember;
import cn.nexuslink.pojo.json.ResponseJson;
import cn.nexuslink.service.impl.CacheService;
import cn.nexuslink.service.impl.JavaMaiService;
import cn.nexuslink.service.impl.MemberService;
import cn.nexuslink.utils.CookieUtil;
import cn.nexuslink.utils.HashPasswordUtil;
import cn.nexuslink.utils.UUidCreatUtil;
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
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static cn.nexuslink.pojo.constant.StatusCode.*;


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

    @Resource
    private JavaMaiService javaMaiService;

    @Resource
    private IMemberDao memberDao;

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

    @RequestMapping(value = "/findPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson findPassword(@RequestParam("realname")@NotNull String realname, @RequestParam("Vcode") @NotNull String Vcode, HttpServletRequest request) {
        String correctVcode = (String) request.getSession().getAttribute("Vcode");
        if(!Vcode.equals(correctVcode))
            return new ResponseJson(INVALID_REQUEST.getCode(),INVALID_REQUEST.getMessage(),"验证码输入错误！");
        Member mb = memberDao.getMemberByName(realname);
        String mail = mb.getEmail();
        if (mb== null || mail==null||mail.equals(' ')) {
            return new ResponseJson(INVALID_REQUEST.getCode(),INVALID_REQUEST.getMessage(),"不存在该用户或者该用户没预留邮箱！");
        }
        String findKey= UUidCreatUtil.creatUUid();
        cacheService.addToCache("findCodeToken",findKey,mb.getId());
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()
                +"/"+"member/retrieve" +"?findKey=" + findKey;
        String content = "您好，这是重庆邮电大学互联网研究中心微信公众号密码修改邮件，请点击下面链接完成密码修改<br/>" +
                "重置密码连接<a href="+url+">点击进入重置页面</a>";
        javaMaiService.sendHtmlMail(mail,"找回密码",content);
        return new ResponseJson(OK.getCode(), OK.getMessage(), "找回密码的邮件已发送，请进入邮件修改密码！");
    }

    public ResponseJson tetrive(@RequestParam("newPassword") @NotNull String newPassword,
                                @RequestParam("ensurePassword") @NotNull String ensurePassword,
                                @RequestParam("Vcode") @NotNull String Vcode, @RequestParam("findKey") String findKey,
                                HttpServletRequest request) {
        if (!newPassword.equals(ensurePassword)||)
    }

}

