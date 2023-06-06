package cn.edu.bcu.demo.service.impl;

import cn.edu.bcu.demo.dao.UserMapper;
import cn.edu.bcu.demo.domain.User;
import cn.edu.bcu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public int register(User User) {
		// TODO Auto-generated method stub
		return this.userMapper.insert(User);
	}

	@Override
	public int login(User User) {
		// TODO Auto-generated method stub
		return this.userMapper.selectOne(User);
	}

}
