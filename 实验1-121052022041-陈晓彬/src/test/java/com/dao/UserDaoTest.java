package com.dao;

import com.homework.config.SpringConfig;
import com.homework.dao.UserDao;
import com.homework.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 23:28
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserDaoTest {
    @Autowired
    private UserDao userDao ;

    @Test
    public void testInsert() {
        int ret = userDao.insert(new User()
                             .setName("zhangsan")
                              .setPassword("123456")) ;
        Assert.assertEquals(ret, 1);
    }

   @Test
    public void testLogin() {
        User user = userDao.login("zhangsan", "123") ;
        Assert.assertNull(user);
    }
    @Test
    public void testCountAllUsers() {
        int ret = userDao.countAllUsers() ;
        Assert.assertTrue(ret > 0 );
    }

}
