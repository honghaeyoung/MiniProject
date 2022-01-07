package hong.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hong.project.dao.UsersDao;
import hong.project.dto.UsersDto;

@Service
public class UsersService {
    @Autowired
	UsersDao dao;
    //회원가입
    public int usersInsert(UsersDto dto) {
    	return dao.usersInsert(dto);
    }
    //id중복체크
    public int idChk(String id) {
    	return dao.idChk(id);
    }
    //로그인
    public UsersDto login(UsersDto dto) {
    	return dao.login(dto);
    }
    //회원 정보 수정
    public int usersUpdate(UsersDto dto) {
    	return dao.usersUpdate(dto);
    }
    //회원 탈퇴
    public int usersDelete(String formpw, UsersDto dto) {
    	String pw = dto.getPassword();
    	if(pw.equals(formpw)) {
    		return dao.usersDelete(dto.getId());
    	}else {
    		return 0;
    	}
    }
    
}
