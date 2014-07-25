package com.yuramitsyuk.jdbctemplate.repository;


import com.yuramitsyuk.jdbctemplate.entity.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserRepository {

    public void setDataSource(DataSource ds);

    public String create(User user);

    List<User> findAll();

    public User getUser(Integer id);

    public String delete(Integer id);

    public String update(User user);
}
