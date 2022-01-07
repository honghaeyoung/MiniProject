package hong.project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UsersDto {
	
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birth;
	

}
