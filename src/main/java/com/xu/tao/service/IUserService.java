package com.xu.tao.service;

import com.xu.tao.pojo.User;

/**
 * Created by xutao on 2017/12/16.
 */
public interface IUserService {
    void savePrimary(User user);

    void saveSlave(User user);
}
