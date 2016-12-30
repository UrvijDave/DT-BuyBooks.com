package com.urvij.buybooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.urvij.buybooks.dao.UserDAO;
import com.urvij.buybooks.daoimpl.UserDAOImpl;

// This class we have to convert into a controller(MVC)
// We have to create a simple annotation - during a compilation/runtime/deployment time
//  it will generate code on behalf of us
// Servlet is a controller

@Controller
public class HomeController {

	// I want to navigate to Home page

	@RequestMapping("/")
	public String homePage() {
		System.out.println("Executing the method homePage");
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView ShowLoginPage() {

		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "You clicked Login link");
		mv.addObject("showLoginPage", "true");
		return mv; // navigate to login.jsp
	}

	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "You clicked Registration link");
		mv.addObject("showRegistrationPage", "true");

		return mv;
	}

/*------------------AUTHOR PAGE------------------- */
	@RequestMapping("/author")
	public ModelAndView showAuthorPage() {
		ModelAndView mv = new ModelAndView("author");
		mv.addObject("msg", "You clicked Registration link");
		mv.addObject("showAuthorPage", "true");

		return mv;
	}

	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd) {

		System.out.println("id: " + id);
		System.out.println("pwd: " + pwd);
		System.out.println("In validate Method");
		ModelAndView mv = new ModelAndView("login");


		UserDAO userDAO = new UserDAOImpl(); // will remove later

		if (userDAO.isValidCredentials(id, pwd) == true) {
			mv.addObject("successMsg", "You logged in Successfully");
		} else {
			mv.addObject("errorMsg", "Invalid credentials... Please try again");
		}

		return mv;
	}
}