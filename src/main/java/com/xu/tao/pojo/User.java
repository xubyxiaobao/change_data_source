package com.xu.tao.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xutao on 2017/12/16.
 */
@Data
@Entity(name = "mmall_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;
}
