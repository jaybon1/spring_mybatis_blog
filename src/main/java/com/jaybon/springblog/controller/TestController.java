package com.jaybon.springblog.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaybon.springblog.model.Post;
import com.jaybon.springblog.model.User;
import com.jaybon.springblog.repository.PostRepository;
import com.jaybon.springblog.repository.UserRepository;
import com.jaybon.springblog.util.Script;

@Controller
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping({"","/"})
	public String home(Model model) {
		
		List<Post> postList = postRepository.findAllDesc();
		
		model.addAttribute("postList", postList);
		
		return "home";
	}
	
	// 회원가입 페이지 이동
	@GetMapping("join")
	public String join(){
		return "user/join";
	}
	
	// 회원가입
	@PostMapping("joinProc")
	public @ResponseBody String joinProc(User user) {
		
		User principal = userRepository.findByUsername(user.getUsername());
		
		if(principal != null) {
			return Script.back("아이디가 중복입니다.");
		}
		
		userRepository.save(user);
		
		principal = userRepository.findByUsername(user.getUsername());
		
		if(principal != null) {
			return Script.href("회원가입에 성공하였습니다.", "/login");
		} else {
			return Script.back("회원가입에 실패하였습니다.");
		}
	}
	
	//로그인 페이지 이동
	@GetMapping("login")
	public String login(){
		return "user/login";
	}
	
	//로그인
	@PostMapping("loginProc")
	public @ResponseBody String loginProc(User user, HttpSession session) {
		
		User principal = userRepository.findByUsernameAndPassword(user);
		
		if(principal == null) {
			return Script.back("아이디나 비밀번호가 틀렸습니다.");
		} else {
			session.setAttribute("principal", principal);
			return Script.href("로그인에 성공하였습니다.", "/");
		}
		
	}
	
	// 로그아웃
	@GetMapping("logout")
	public @ResponseBody String logout(HttpSession session){
		
		session.setAttribute("principal", null);
		
		return Script.href("로그아웃 되었습니다.", "/");
	}
	
}
