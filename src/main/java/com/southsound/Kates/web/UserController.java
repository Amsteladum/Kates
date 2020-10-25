package com.southsound.Kates.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import com.southsound.Kates.services.UserService;

import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserController {
	UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}
}
