package camt.se234.project;

import camt.se234.project.dao.UserDao;
import camt.se234.project.service.AuthenticationServiceImpl;
import org.junit.Before;
import static org.mockito.Mockito.mock;

public class AuthenticationServiceImplTest {
 UserDao userDao;
 AuthenticationServiceImpl authenticationService;
 @Before
    public void setUp(){
     userDao = mock(UserDao.class);
     authenticationService = new AuthenticationServiceImpl();
     authenticationService.setUserDao(userDao);
 }
}
