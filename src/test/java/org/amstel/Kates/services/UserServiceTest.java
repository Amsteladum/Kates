package org.amstel.Kates.services;

import org.amstel.Kates.data.UserRepository;
import org.amstel.Kates.data.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private UserService userService;
	private User user;
	
	private String username;

	@Before
    public void setupService() {
        userService = new UserService(userRepository);

        when(userRepository.findByUsername("jDoe1")).thenReturn(username);
    }

    @Test
    public void getUserTest() {
        String desired = userService.getUsername("jDoe1");
        assertEquals(user, desired);
    }
}
