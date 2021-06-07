package com.voda.iot.Repos;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.voda.iot.entities.QDevices;
import com.voda.iot.entities.QSIM;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


import javax.persistence.EntityManager;

public abstract class BaseRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID> {

    protected final QDevices device = QDevices.devices;

    protected final QSIM sim = QSIM.sIM;

    private final EntityManager em;

    protected final JPAQueryFactory queryFactory;


    public BaseRepoImpl(Class<T> domainClass, EntityManager em) {

        super(domainClass, em);

        this.em = em;

        this.queryFactory = new JPAQueryFactory(em);

    }


    public void clear() {

        em.clear();

    }

    public void detach(T entity) {

        em.detach(entity);

    }

}