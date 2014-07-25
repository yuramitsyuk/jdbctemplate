package com.yuramitsyuk.jdbctemplate.repository.impl;


import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.repository.template.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUser(Integer id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
