package cqupt.nmid.weixin.servlet;

import cqupt.nmid.weixin.model.GlobalConstant;
import cqupt.nmid.weixin.util.CheckUtil;
import cqupt.nmid.weixin.util.MessageUtil;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by 罗浩 on 2017/3/15.
 */
public class WeiChatCheckServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response){

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echost = request.getParameter("echost");

        PrintWriter out = null;
        try{
            out = response.getWriter();
        }catch(Exception e){
            e.toString();

        }
        if(CheckUtil.checkSignature(signature,timestamp,nonce)){
            out.print(echost);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException ,IOException{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Map<String ,String> map = MessageUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String msgType= map.get("MsgType");
            String content = map.get("Content");

            String message = null;
            if(GlobalConstant.MESSAGE_TEXT.equals(msgType)){
                if ("1".equals(content)){
                    message = MessageUtil.initText(toUserName,fromUserName,"研究中心主页！");
                }else if("2".equals(content)){
                    message = MessageUtil.initText(toUserName,fromUserName,"成员签到表！");
                }else if("?".equals(content)||"？".equals(content)){
                    message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.MenuText());
                }

            }else if (GlobalConstant.MESSAGE_EVENT.equals(msgType)){
                String eventType = map.get("Event");
                if (GlobalConstant.MESSAGE_SUBSCRIBLE.equals(eventType)){
                    message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.MenuText());
                }
            }
            out.print(message);

        }catch(DocumentException e ){
            e.printStackTrace();
        }finally {
            out.close();
        }

    }
}
