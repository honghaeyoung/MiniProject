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
    //user����
    @ModelAttribute("user")
    public UsersDto getDto() {
    	return new UsersDto();
    }
    
    //ȸ������ ��
    @GetMapping("/insertform")
    public String insertForm() {
    	return "users/insertform";
    }
    
    //ȸ������
    @PostMapping("insertform")
    public String usersInsert(UsersDto dto) {
    	service.usersInsert(dto);
    	return "redirect:/loginform";
    }
    
    //id�ߺ�üũ
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
  	//�α��� ����Ʈ
  	@GetMapping("/loginform")
  	public String loginform() {
  		return "users/loginform";
  	}
  	@PostMapping("/login")
  	public String login(@ModelAttribute("command") @Valid UsersDto dto, BindingResult error, Model m) {
  		UsersDto resultDto = service.login(dto);
  		
  		if(resultDto == null) {
			error.reject("nocode","�α��� ����: ���̵� ��й�ȣ�� Ʋ���ϴ�");
			return "users/loginform";
		}else {//�α��� ����
			m.addAttribute("user", resultDto);
		}
		return "users/main";
  	}
    //�α׾ƿ�
  	@GetMapping("/logout")
  	public String logout(SessionStatus status) {
  		status.setComplete();
  		return "redirect:/";
  	}
    //ȸ���������� ������
  	@GetMapping("/updateform")
  	public String updateform(@ModelAttribute("user") UsersDto dto) {
  		return "users/updateform";
  	}
    //ȸ����������
  	@PostMapping("/update")
  	public String update(@ModelAttribute("user") UsersDto dto) {
  		service.usersUpdate(dto);
  		return "redirect:/";
  	}
    //ȸ��Ż�� ������
  	@GetMapping("/deleteform")
  	public String deleteform() {
  		return "users/deleteform";
  	}
    //ȸ��Ż��
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
    //���� ������
  	@RequestMapping("/main")
  	public String main(@ModelAttribute("user") UsersDto dto) {
  		if(dto.getId() != null) {
  			return "users/main";
  		}else {
  			return "users/loginform";
  		}
   }
}

