package cn.nexuslink.controller;

import cn.nexuslink.pojo.constant.StatusCode;
import cn.nexuslink.pojo.json.ResponseJson;
import cn.nexuslink.utils.validateCode.ValidateCode;
import cn.nexuslink.utils.validateCode.VcodeImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

/**
 * Created by 罗浩 on 2017/5/6.
 */
@Controller
@RequestMapping(value = "/api/Vcode")
public class VcodeController {

    @RequestMapping(value = "/VcodeImage")
    @ResponseBody
    public ResponseJson creatVcodeImage(HttpServletRequest request){
        String Vcode = ValidateCode.creatValidateCode(4,4,null);//生成含有大小写数字三种类型的子字符串、字符个数为4
        //字符串图片宽度160，高度40，干扰线条数50，高低位置随机
        BufferedImage bufferedImage = VcodeImage.creatImageVcode(Vcode, 160, 40, 50,true, null, null, null);
        request.getSession().setAttribute("Vcode", Vcode);
        return new ResponseJson(StatusCode.CREATED.getCode(),StatusCode.CREATED.getMessage(),bufferedImage);
    }
}
