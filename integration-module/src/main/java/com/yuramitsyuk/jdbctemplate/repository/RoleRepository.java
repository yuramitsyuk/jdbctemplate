package com.yuramitsyuk.jdbctemplate.repository;

import com.yuramitsyuk.jdbctemplate.entity.Role;

import javax.sql.DataSource;
import java.util.List;

public interface RoleRepository {

    void setDataSource(DataSource ds);

    String create(Role role);

    List<Role> findAll();

    Role getRole(Integer id);

    String delete(Integer id);

    String update(Role role);
}
