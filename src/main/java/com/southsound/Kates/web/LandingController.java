package com.southsound.Kates.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.Exception;

@Controller
public class LandingController extends Exception {

	@GetMapping("/")
	public String rootString() {
		return "root";
	} /*TODO If "root" is not present, create an Optional operation two switch between root and landing-page.
		NOTE Optional conditioning must be between "root", "home" and "landing"*/

}