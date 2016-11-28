package sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userServiceI;
	
	public UserServiceI getUserServiceI() {
		return userServiceI;
	}
	@Autowired
	public void setUserServiceI(UserServiceI userServiceI) {
		this.userServiceI = userServiceI;
	}


	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable String id,HttpServletRequest req){
	
		User u = userServiceI.getUser(id);
		req.setAttribute("user", u);
		
	  return "showUser";
	 }
}
