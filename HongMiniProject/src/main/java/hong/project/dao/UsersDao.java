package hong.project.dao;

import org.apache.ibatis.annotations.Mapper;

import hong.project.dto.UsersDto;

@Mapper
public interface UsersDao {
	
	int usersInsert(UsersDto dto);//ȸ������
	
	int idChk(String id);//id�ߺ�üũ

	UsersDto login(UsersDto dto);//�α���
	
	int usersUpdate(UsersDto dto);//ȸ�� ���� ����
	
	int usersDelete(String id);//ȸ��Ż��
	

}
