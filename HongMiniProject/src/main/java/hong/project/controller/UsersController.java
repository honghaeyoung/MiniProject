package hong.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



import hong.project.dto.UsersDto;
import hong.project.service.UsersService;
@SessionAttributes("user")
@Controller
public class UsersController {
    @Autowired
	UsersService service;
    //user세션
    @ModelAttribute("user")
    public UsersDto getDto() {
    	return new UsersDto();
    }
    
    //회원가입 폼
    @GetMapping("/insertform")
    public String insertForm() {
    	return "users/insertform";
    }
    
    //회원가입
    @PostMapping("insertform")
    public String usersInsert(UsersDto dto) {
    	service.usersInsert(dto);
    	return "redirect:/loginform";
    }
    
    //id중복체크
  	@ResponseBody
  	@PostMapping("/idchk")
  	public String idChk(String id) {
  		int result = service.idChk(id);
  		
  		try {
  			if(result == 0) {
  				return "true";
  			}else{
  				return "false";
  			}
  			
  		} catch (Exception e) {
  			throw new RuntimeException();
  		}
  		
  	}
  	//로그인 사이트
  	@GetMapping("/loginform")
  	public String loginform() {
  		return "users/loginform";
  	}
  	@PostMapping("/login")
  	public String login(@ModelAttribute("command") @Valid UsersDto dto, BindingResult error, Model m) {
  		UsersDto resultDto = service.login(dto);
  		
  		if(resultDto == null) {
			error.reject("nocode","로그인 실패: 아이디나 비밀번호가 틀립니다");
			return "users/loginform";
		}else {//로그인 성공
			m.addAttribute("user", resultDto);
		}
		return "users/main";
  	}
    //로그아웃
  	@GetMapping("/logout")
  	public String logout(SessionStatus status) {
  		status.setComplete();
  		return "redirect:/";
  	}
    //회원정보수정 페이지
  	@GetMapping("/updateform")
  	public String updateform(@ModelAttribute("user") UsersDto dto) {
  		return "users/updateform";
  	}
    //회원정보수정
  	@PostMapping("/update")
  	public String update(@ModelAttribute("user") UsersDto dto) {
  		service.usersUpdate(dto);
  		return "redirect:/";
  	}
    //회원탈퇴 페이지
  	@GetMapping("/deleteform")
  	public String deleteform() {
  		return "users/deleteform";
  	}
    //회원탈퇴
  	@PostMapping("/delete")
  	public String delete(String formpw, @ModelAttribute("user") UsersDto dto, SessionStatus status) {
  		int i = service.usersDelete(formpw, dto);
  		if(i == 0) {
  			return "users/deleteform";
  		}else {
  			status.setComplete();
  			return "redirect:/";	
  		}
  		
  	}
    //메인 페이지
  	@RequestMapping("/main")
  	public String main(@ModelAttribute("user") UsersDto dto) {
  		if(dto.getId() != null) {
  			return "users/main";
  		}else {
  			return "users/loginform";
  		}
   }
}

