package com.southsound.Kates.controllers;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.southsound.Kates.data.User;
import com.southsound.Kates.services.UserService;
import com.southsound.Kates.web.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;


public class UserControllerTest {

    private UserController buildUserController() {
        UserService userService = mock(UserService.class);
        return new UserController(userService);
    }

    @Test
    public void shouldShowRegister() throws Exception {
        MockMvc mockMvc = standaloneSetup(buildUserController()).build();
        mockMvc.perform(get("/user/register")).andExpect(view().name("userRegister"));
    }

    @Test
    public void shouldProcessRegister() throws Exception {
        UserService userService = mock(UserService.class);
        User unknown = new User("username", "password", "firstName", "lastName", "user@test.com");
        User user = new User("jDoe1", "johnrocks7339", "John", "Doe-Smith", "yaxowa7339@glenwoodave.com");

        UserController userController = new UserController(userService);
        MockMvc mockMvc = standaloneSetup(userController).build();

        mockMvc.perform(post("user/register")
                .param("firstName", "John")
                .param("lastName", "Doe-Smith")
                .param("username", "jDoe1")
                .param("password", "johnrocks7339")
                .param("emailAddress", "yaxowa7339@glenwoodave.com"))
                .andExpect(redirectedUrl("/user/jDoe1"));

		verify(userService, atLeastOnce()).saveUser(unknown);
		verify(userService, atLeastOnce()).saveUser(user);
    }

    @Test
    public void shouldFailRegister() throws Exception {
        MockMvc mockMvc = standaloneSetup(buildUserController()).build();

        mockMvc.perform(post("/user/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("userRegister"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasFieldErrors("user", "firstName", "lastName", "username", "password", "email"));
    }


}
