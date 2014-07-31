package com.yuramitsyuk.jdbctemplate.repository.impl;

import com.yuramitsyuk.jdbctemplate.entity.UserRole;
import com.yuramitsyuk.jdbctemplate.repository.UserRoleRepository;
import com.yuramitsyuk.jdbctemplate.repository.template.UserRoleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries_for_userRole_en", Locale.ENGLISH);

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String create(UserRole userRole) {
        jdbcTemplate.update(resourceBundle.getString("insertUserRole"), userRole.getUserId(), userRole.getRoleId());
        return "Created Record Login = " + userRole.getUserId() + " Password = " + userRole.getRoleId();
    }

    @Override
    public List<UserRole> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserRole getUserRole(Integer id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserRole getUserRoleByUserId(Integer id) {
        UserRole userRole = jdbcTemplate.queryForObject(resourceBundle.getString("getOneUserRoleByUserId"),
                new Object[]{id}, new UserRoleMapper());
        return userRole;
    }

    @Override
    public UserRole getUserRoleByRoleId(Integer id) {
        UserRole userRole = jdbcTemplate.queryForObject(resourceBundle.getString("getOneUserRoleByRoleId"),
                new Object[]{id}, new UserRoleMapper());
        return userRole;
    }

    @Override
    public String delete(Integer id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String update(UserRole role) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
