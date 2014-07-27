package com.yuramitsyuk.jdbctemplate.controller;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        if(logger.isDebugEnabled()){
            logger.debug("printWelcome() method is executed!");
        }
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userId") Integer id) {
        if(logger.isDebugEnabled()){
            logger.debug("getUser() method is executed!");
        }
        return userRepository.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        if(logger.isDebugEnabled()){
            logger.debug("getUsers() method is executed!");
        }
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public String updateUser(@PathVariable("userId") Integer userId,
                            @RequestBody String userData) {
        if(logger.isDebugEnabled()){
            logger.debug("updateUser() method is executed!");
        }
        User user = new User();
        user.setId(userId);
        String [] s = userData.split("&");
        user.setLogin(s[0].substring(s[0].indexOf('=')+1));
        user.setPassword(s[1].substring(s[1].indexOf('=')+1));
        return userRepository.update(user);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("userId") Integer id) {
        if(logger.isDebugEnabled()){
            logger.debug("deleteUser() method is executed!");
        }
        return userRepository.delete(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestParam("userLogin") String userLogin,
                      @RequestParam("userPassword") String userPassword) {
        if(logger.isDebugEnabled()){
            logger.debug("createUser() method is executed!");
        }
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        return userRepository.create(user);
    }
}