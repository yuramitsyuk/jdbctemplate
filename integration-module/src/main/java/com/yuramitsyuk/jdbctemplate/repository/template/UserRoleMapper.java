package com.yuramitsyuk.jdbctemplate.repository.template;

import com.yuramitsyuk.jdbctemplate.entity.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserRole userRole = new UserRole();
        userRole.setId(rs.getInt("id"));
        userRole.setUserId(rs.getInt("user_id"));
        userRole.setRoleId(rs.getInt("role_id"));
        return userRole;
    }
}
