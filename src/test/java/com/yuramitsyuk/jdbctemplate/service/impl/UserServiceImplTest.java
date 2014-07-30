package com.yuramitsyuk.jdbctemplate.service.impl;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
@Transactional
public class UserServiceImplTest {

    public static final String TEST_LOGIN = "TestLogin";
    public static final String TEST_PASSWORD = "TestPassword";
    public static final String TEST_MESSAGE = "Created Record Login = " + TEST_LOGIN + " Password = " + TEST_PASSWORD;

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() throws Exception {
        User user = new User();
        user.setLogin(TEST_LOGIN);
        user.setPassword(TEST_PASSWORD);
        Assert.assertEquals(TEST_MESSAGE, userService.create(user));
    }

}
