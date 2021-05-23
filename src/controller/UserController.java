package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import Pojo.User;
import service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String userList() throws Exception{
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerlist() throws Exception{
		return "register";
	}
	
	@RequestMapping("/logincheck")
	public String login(User user,Model model,HttpSession httpSession) throws Exception{
		User user1=userService.login(user);
		if(user1!=null){
			httpSession.setAttribute("user", user1);
			if(user1.getType().equals("zuke")){
				return "redirect:houselist.action";
			}
			else{
				return "redirect:ahouselist.action";
			}
		}else{
			String error="error";
			model.addAttribute("error", error);
		return "login";
		}
	}
	
	@RequestMapping("/registercheck")
	public String register(User user,Model model) throws Exception{
		User user1=userService.register(user);
		if(user1==null){
			boolean registerStatu=userService.insertUser(user);
			if(registerStatu){
				return "login";
			}
			String error="error";
			model.addAttribute("error", error);
				return "register";
		}else{
			String error="error";
			model.addAttribute("error", error);
		return "register";
		}
	}
	
	@RequestMapping("/toindex")
	public String toindex(Model model) throws Exception{
		//System.out.println("我是跳转到zuke/main");
		return "zuke/main";
		}
	
	@RequestMapping("/atoindex")
	public String atoindex(Model model) throws Exception{
		//System.out.println("我是跳转到admin/main1");
		return "admin/main1";
		}
	
	}

