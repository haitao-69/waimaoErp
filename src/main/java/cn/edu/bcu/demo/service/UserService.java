package cn.edu.bcu.demo.service;

import cn.edu.bcu.demo.domain.User;

public interface UserService {
	public int register(User User);
	
	public int login(User User);
}
