package cn.nexuslink.controller;

import cn.nexuslink.dao.ArticalDao;
import cn.nexuslink.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 罗浩 on 2017/3/19.
 */

@Controller
@RequestMapping(value = "/test")
public class ArticalDaoTestController {

    @Autowired
    @Qualifier(value = "articalDao")
    private ArticalDao articalDao;

    @Autowired
    @Qualifier(value = "categoryDao")
    private CategoryDao categoryDao;

    @RequestMapping(value = "/getArtical")
    public String getArticalTitle(HttpServletRequest request,HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        String result = "123";
        try{
            out=response.getWriter();
            result = articalDao.getTitle(5);
            out.print(result);

            System.out.print(categoryDao.getEasyCategoryList().toString());

            System.out.print(categoryDao.getEasyCategoryList().toString());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            out.close();
        }
        return null;


    }

    @RequestMapping(value = "/sayhello")
    public String sayhello(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");

        PrintWriter out = null;

        String result = articalDao.getTitle(5);

        System.out.print(result.toString());

        try {
            out = response.getWriter();
            out.print("hello  "+ result);
        } catch (IOException e) {
                e.printStackTrace();
        }finally{
            out.close();
        }
        return null;
    }
}
