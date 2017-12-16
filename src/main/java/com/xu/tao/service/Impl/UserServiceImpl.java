package com.xu.tao.service.Impl;

import com.xu.tao.dynamic.TargetDataSource;
import com.xu.tao.dynamic.Type;
import com.xu.tao.pojo.User;
import com.xu.tao.repository.UserRepository;
import com.xu.tao.service.IUserService;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xutao on 2017/12/16.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;


    @Override
    public void savePrimary(User user){
        repository.save(user);
    }

    @Override
    @TargetDataSource(type = Type.SLAVE)
    public void saveSlave(User user){
        repository.save(user);
    }

}
