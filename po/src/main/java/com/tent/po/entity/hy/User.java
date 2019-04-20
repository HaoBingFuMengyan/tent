package com.tent.po.entity.hy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tent.po.entityBase.hy.UserBase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hy_user")
public class User extends UserBase{

    public User(){}
    public User(User user) {
        super(user);
    }


    private Member member;

    @ManyToOne
    @JoinColumn(name = "smemberid", insertable = false,updatable = false)
    @JsonIgnore
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}