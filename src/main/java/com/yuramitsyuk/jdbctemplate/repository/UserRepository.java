package com.yuramitsyuk.jdbctemplate.repository;


import com.yuramitsyuk.jdbctemplate.entity.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserRepository {

    public void setDataSource(DataSource ds);

    public void create(User user);

    List<User> findAll();

    public User getUser(Integer id);

    public void delete(Integer id);

    public void update(User user);
}
