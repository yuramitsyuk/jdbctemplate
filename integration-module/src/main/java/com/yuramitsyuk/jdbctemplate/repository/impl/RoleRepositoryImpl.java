package com.yuramitsyuk.jdbctemplate.repository.impl;

import com.yuramitsyuk.jdbctemplate.entity.Role;
import com.yuramitsyuk.jdbctemplate.repository.RoleRepository;
import com.yuramitsyuk.jdbctemplate.repository.template.RoleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries_for_role_en", Locale.ENGLISH);

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String create(Role role) {
        jdbcTemplate.update(resourceBundle.getString("insertRole"), role.getName());
        return "Created Record Name = " + role.getName();
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = jdbcTemplate.query(resourceBundle.getString("getAllRoles"), new RoleMapper());
        return roles;
    }

    @Override
    public Role getRole(Integer id) {
        Role role = jdbcTemplate.queryForObject(resourceBundle.getString("getOneRoleById"),
                new Object[]{id}, new RoleMapper());
        return role;
    }

    @Override
    public Role getRole(String name) {
        Role role = jdbcTemplate.queryForObject(resourceBundle.getString("getOneRoleByName"),
                new Object[]{name}, new RoleMapper());
        return role;
    }

    @Override
    public String delete(Integer id) {
        jdbcTemplate.update(resourceBundle.getString("deleteOneRole"), id);
        return "Deleted Record with ID = " + id;
    }

    @Override
    public String update(Role role) {
        jdbcTemplate.update(resourceBundle.getString("updateRole"), new Object[]{role.getName(), role.getId()});
        return "Updated Record with ID = " + role.getId();

    }
}
