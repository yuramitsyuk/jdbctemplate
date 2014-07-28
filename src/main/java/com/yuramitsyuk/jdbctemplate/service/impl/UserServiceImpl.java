package com.yuramitsyuk.jdbctemplate.service.impl;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String create(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }

    @Override
    public String delete(Integer id) {
        return userRepository.delete(id);
    }

    @Override
    public String update(Integer id, User userData) {
        User user = new User();
        user.setId(id);
        user.setLogin(userData.getLogin());
        user.setPassword(userData.getPassword());
        return userRepository.update(user);
    }
}
