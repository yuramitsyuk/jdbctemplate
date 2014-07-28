package com.yuramitsyuk.jdbctemplate.repository.impl;


import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.repository.template.UserMapper;
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
    public String create(User user) {
        String sql = "insert into user (login, password) values (?, ?)";

        jdbcTemplate.update( sql, user.getLogin(), user.getPassword());
        return "Created Record Login = " + user.getLogin() + " Password = " + user.getPassword();
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public User getUser(Integer id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public String delete(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        return  "Deleted Record with ID = " + id;
    }

    @Override
    public String update(User user) {
        String sql = "update user set login=?, password=? where id=?";
        jdbcTemplate.update(sql, new Object[] {user.getLogin(), user.getPassword(), user.getId()});
        return "Updated Record with ID = " + user.getId();

    }
}
