package com.yuramitsyuk.jdbctemplate.repository;


import com.yuramitsyuk.jdbctemplate.entity.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserRepository {

    void setDataSource(DataSource ds);

    String create(User user);

    List<User> findAll();

    User getUser(Integer id);

    String delete(Integer id);

    String update(User user);
}
