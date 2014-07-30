package com.yuramitsyuk.jdbctemplate.repository.impl;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.repository.template.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries_for_user_en", Locale.ENGLISH);

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String create(User user) {
        jdbcTemplate.update(resourceBundle.getString("insertUser"), user.getLogin(), user.getPassword());
        return "Created Record Login = " + user.getLogin() + " Password = " + user.getPassword();
    }

    @Override
    public List<User> findAll() {
        List<User> users = jdbcTemplate.query(resourceBundle.getString("getAllUsers"), new UserMapper());
        return users;
    }

    @Override
    public User getUser(Integer id) {
        User user = jdbcTemplate.queryForObject(resourceBundle.getString("getOneUserById"),
                new Object[]{id}, new UserMapper() {

        });
        return user;
    }

    @Override
    public User getUser(String login) {
        User user = jdbcTemplate.queryForObject(resourceBundle.getString("getOneUserByLogin"),
                new Object[]{login}, new UserMapper() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return user;
    }

    @Override
    public String delete(Integer id) {
        jdbcTemplate.update(resourceBundle.getString("deleteOneUser"), id);
        return "Deleted Record with ID = " + id;
    }

    @Override
    public String update(User user) {
        jdbcTemplate.update(resourceBundle.getString("updateUser"), new Object[]{user.getLogin(), user.getPassword(), user.getId()});
        return "Updated Record with ID = " + user.getId();

    }
}
