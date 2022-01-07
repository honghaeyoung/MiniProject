package hong.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hong.project.dao.UsersDao;
import hong.project.dto.UsersDto;

@Service
public class UsersService {
    @Autowired
	UsersDao dao;
    //ȸ������
    public int usersInsert(UsersDto dto) {
    	return dao.usersInsert(dto);
    }
    //id�ߺ�üũ
    public int idChk(String id) {
    	return dao.idChk(id);
    }
    //�α���
    public UsersDto login(UsersDto dto) {
    	return dao.login(dto);
    }
    //ȸ�� ���� ����
    public int usersUpdate(UsersDto dto) {
    	return dao.usersUpdate(dto);
    }
    //ȸ�� Ż��
    public int usersDelete(String formpw, UsersDto dto) {
    	String pw = dto.getPassword();
    	if(pw.equals(formpw)) {
    		return dao.usersDelete(dto.getId());
    	}else {
    		return 0;
    	}
    }
    
}
