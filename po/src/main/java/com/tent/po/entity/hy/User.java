package com.tent.po.entity.hy;

import com.tent.po.entityBase.hy.UserBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hy_user")
public class User extends UserBase{

    public User(User user) {
        super(user);
    }
}