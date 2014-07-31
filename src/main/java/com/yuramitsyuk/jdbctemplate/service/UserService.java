package com.yuramitsyuk.jdbctemplate.service;

import com.yuramitsyuk.jdbctemplate.entity.User;

import java.util.List;

public interface UserService {

    String create(User user);

    List<User> findAll();

    User getUser(Integer id);

    User getUser(String login);

    String delete(Integer id);

    String update(Integer id, User user);
}
