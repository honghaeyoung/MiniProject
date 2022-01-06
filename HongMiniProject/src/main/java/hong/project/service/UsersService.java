package hong.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hong.project.dao.UsersDao;

@Service
public class UsersService {
    @Autowired
	UsersDao dao;
}
