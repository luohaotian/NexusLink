package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.form.LoginForm;
import cn.nexuslink.WeNavi.model.form.UpdateForm;
import cn.nexuslink.WeNavi.util.TimeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ÂÞºÆ on 2017/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:Wenavi-dao.xml")
public class IUserDaoTest {

    @Autowired
    private IUserDao userDao;

//    @Before
//    public void before(){
//        LoginForm user = new LoginForm();
//        user.setUsername("luohao");
//        user.setPassword("luo140610");
//        user.setTime(TimeUtil.getTimestamp());
//        userDao.saveUser(user);
//    }

    @Test
    public void saveUser() throws Exception {
        LoginForm user2 = new LoginForm();
        user2.setUsername("Rye");
        user2.setPassword("RyeGe");
        user2.setTime(TimeUtil.getTimestamp());
        int res=userDao.saveUser(user2);
        Assert.assertTrue(res==1);

    }

    @Test
    public void existUser() throws Exception {
        int res = userDao.existUser("luohao");
        System.out.println(res);
        int res2 = userDao.existUser("Rye");
        System.out.println(res2);

        Assert.assertTrue(res==1);

    }

    @Test
    public void findUserById() throws Exception {

    }

    @Test
    public void findUserByUsername() throws Exception {

    }

    @Test
    public void updateInfo() throws Exception {
        UpdateForm user = new UpdateForm();
        user.setUsername("Rye");
        user.setNickname("´óÀÐ");
        //user.setGender(1);
        //user.setAddress("ËÄ´¨");
        user.setMtime(TimeUtil.getTimestamp());
        userDao.updateInfo(user);
    }

    @Test
    public void updatePassword() throws Exception {

    }

}