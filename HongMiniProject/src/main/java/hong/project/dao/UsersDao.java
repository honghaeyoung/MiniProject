package hong.project.dao;

import org.apache.ibatis.annotations.Mapper;

import hong.project.dto.UsersDto;

@Mapper
public interface UsersDao {
	
	int usersInsert(UsersDto dto);//회원가입
	
	int idChk(String id);//id중복체크

	UsersDto login(UsersDto dto);//로그인
	
	int usersUpdate(UsersDto dto);//회원 정보 수정
	
	int usersDelete(String id);//회원탈퇴
	

}
