package com.tent.service.impl.hy;

import com.google.common.collect.Lists;
import com.tent.common.exception.E;
import com.tent.common.utils.B;
import com.tent.common.utils.S;
import com.tent.dao.hy.MemberDao;
import com.tent.po.entity.hy.Member;
import com.tent.service.inte.hy.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class MemberService implements IMemberService {
    @Autowired
    private MemberDao memberDao;


    @Override
    public Member findBySmemberid(String smemberid) {
        if (B.Y(smemberid))
            E.S("会员不存在");

        return this.memberDao.findOne(new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = Lists.newArrayList();

                cb.equal(root.get("id"),smemberid);

                return S.andList(cb,list);
            }
        });
    }
}
