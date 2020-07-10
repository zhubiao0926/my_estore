package com.briup.Dao;

import com.briup.Bean.User;

public interface IUserDaoMapper {
	// 通过名字查看用户
	User findUserByUserid(String userid);
	void saveUser(User user);
	void updateUser(User user);
}
