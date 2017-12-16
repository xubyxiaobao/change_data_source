package com.xu.tao.service.Impl;

import com.xu.tao.pojo.User;
import com.xu.tao.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by xutao on 2017/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private IUserService service;
    @Test
    public void savePrimary() throws Exception {
        User user = new User();
        user.setUsername("主库");
        user.setPassword("primary");
        service.savePrimary(user);
    }

    @Test
    public void saveSlave() throws Exception {


        User primary = new User();
        primary.setUsername("主库");
        primary.setPassword("primary");

        User slave = new User();
        slave.setUsername("从库");
        slave.setPassword("slave");
        service.savePrimary(primary);
        service.saveSlave(slave);
    }

}