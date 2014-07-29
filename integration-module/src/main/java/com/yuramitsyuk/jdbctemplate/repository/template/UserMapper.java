package com.yuramitsyuk.jdbctemplate.repository.template;

import com.yuramitsyuk.jdbctemplate.entity.Role;
import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.RoleRepository;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        Role role = new Role();
        role.setId(rs.getInt("roleId"));
        role.setName(rs.getString("roleName"));
        user.setRole(role);
        return user;
    }
}
