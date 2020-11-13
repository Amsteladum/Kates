package org.amstel.Kates.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.amstel.Kates.services.UserService;

import org.springframework.stereotype.Controller;

@Controller
@NoArgsConstructor
@Builder
public class UserController {
	UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}
}
