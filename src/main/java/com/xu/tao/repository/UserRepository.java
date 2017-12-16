package com.xu.tao.repository;

import com.xu.tao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xutao on 2017/12/16.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
