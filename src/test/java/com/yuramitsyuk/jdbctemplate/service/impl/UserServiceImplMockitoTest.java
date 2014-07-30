package com.yuramitsyuk.jdbctemplate.service.impl;

import com.yuramitsyuk.jdbctemplate.entity.User;
import com.yuramitsyuk.jdbctemplate.repository.UserRepository;
import com.yuramitsyuk.jdbctemplate.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UserServiceImplMockitoTest {

    public static final String TEST_LOGIN = "TestLogin";
    public static final String TEST_PASSWORD = "TestPassword";
    public static final String TEST_MESSAGE = "Created Record Login = " + TEST_LOGIN + " Password = " + TEST_PASSWORD;

    UserService userService;
    User user;

    @Before
    public void setUp() throws Exception {
        UserRepository userRepository = mock(UserRepository.class);
        user = new User();
        user.setLogin(TEST_LOGIN);
        user.setPassword(TEST_PASSWORD);
        when(userRepository.create(user)).thenReturn(TEST_MESSAGE);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testCreate() throws Exception {
        Assert.assertEquals(TEST_MESSAGE, userService.create(user));
    }
}
