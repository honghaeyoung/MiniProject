package hong.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hong.project.service.UsersService;

@Controller
public class UsersController {
    @Autowired
	UsersService service;
}
