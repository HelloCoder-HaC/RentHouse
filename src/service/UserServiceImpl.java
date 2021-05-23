package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Pojo.*;
import dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> userList() throws Exception {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		List<User> list=userMapper.selectByExample(example);
		//System.out.println("123"+list);
		return list;
	}

	@Override
	public User login(User user) throws Exception {
		User user1=userMapper.selectByUser(user);
		return user1;
	}

	@Override
	public User register(User user) throws Exception {
		User user1=userMapper.selectByUserName(user);
		return user1;
	}
	
	@Override
	public boolean insertUser(User user) throws Exception {
		int a = userMapper.insert(user);
		if(a==0){
			return false;
		}
		return true;
	}
}
