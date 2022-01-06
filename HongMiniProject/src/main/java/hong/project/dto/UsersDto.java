package hong.project.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UsersDto {
	
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private Date birth;
	private String address;

}
