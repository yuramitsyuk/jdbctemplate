package com.yuramitsyuk.jdbctemplate.repository;

import com.yuramitsyuk.jdbctemplate.entity.UserRole;

import javax.sql.DataSource;
import java.util.List;

public interface UserRoleRepository {

    void setDataSource(DataSource ds);

    String create(UserRole userRole);

    List<UserRole> findAll();

    UserRole getUserRole(Integer id);

    UserRole getUserRoleByUserId(Integer id);

    UserRole getUserRoleByRoleId(Integer id);

    String delete(Integer id);

    String update(UserRole role);
}
