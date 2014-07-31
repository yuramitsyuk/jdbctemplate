package com.yuramitsyuk.jdbctemplate.service.impl;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.entity.UserRole;
import com.yuramitsyuk.jdbctemplate.repository.RoleRepository;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.repository.UserRoleRepository;
import com.yuramitsyuk.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public String create(User user) {
        userRepository.create(user);
        User savedUser = userRepository.getUser(user.getLogin());
        if (user.getRole() != null) {
            UserRole userRole = new UserRole();
            userRole.setUserId(savedUser.getId());
            userRole.setRoleId(roleRepository.getRole(user.getRole().getName()).getId());
            userRoleRepository.create(userRole);
        }
        return "User Added";
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
    public User getUser(String login) {
        return userRepository.getUser(login);
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
