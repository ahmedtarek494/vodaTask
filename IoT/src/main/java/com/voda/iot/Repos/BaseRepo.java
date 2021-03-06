package com.voda.iot.Repos;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepo<T, ID> extends JpaRepository<T, ID> {

    void clear();

    void detach(T entity);

}