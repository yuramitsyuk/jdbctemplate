package com.yuramitsyuk.jdbctemplate.controller;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUser(@PathVariable("userId") Integer id) {
        return userRepository.getUser(id);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateUser(@PathVariable("userId") Integer userId,
                      @RequestParam("userLogin") String userLogin,
                      @RequestParam("userPassword") String userPassword) {
        User user = new User();
        user.setId(userId);
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        System.out.println(user);
        return userRepository.update(user);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteUser(@PathVariable("userId") Integer id) {
        return userRepository.delete(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    String createUser(@RequestParam("userLogin") String userLogin,
                      @RequestParam("userPassword") String userPassword) {
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        return userRepository.create(user);
    }
}