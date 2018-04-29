package camt.se234.project;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import camt.se234.project.service.AuthenticationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;


public class AuthenticationServiceImplTest {
 UserDao userDao;
 AuthenticationServiceImpl authenticationService;
 @Before
    public void setUp(){
     userDao = mock(UserDao.class);
     authenticationService = new AuthenticationServiceImpl();
     authenticationService.setUserDao(userDao);
 }

    @Test
    public void testAuthenticate(){
        long id = 592115015;
        when(userDao.getUser("Username","pass")).thenReturn(new User(id,"Username","pass","Student"));
        assertThat(authenticationService.authenticate("Username","pass"),is(new User(id,"Username","pass","Student")));
    }
}
