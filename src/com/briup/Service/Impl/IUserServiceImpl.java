package com.briup.Service.Impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.User;
import com.briup.Dao.IUserDaoMapper;
import com.briup.Service.IUserService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IUserServiceImpl implements IUserService {
	public IUserDaoMapper getIUserDaoMapper() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		return session.getMapper(IUserDaoMapper.class);
	}

	@Override
	public void updateUserinfo(User user) throws ServiceException {
		// TODO Auto-generated method stub
		IUserDaoMapper dao = getIUserDaoMapper();
		dao.updateUser(user);
	}

	@Override
	public void registerUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		// 查询用户，如果存在抛异常给RegisterSer，直接跳转到register.jsp
		IUserDaoMapper dao = getIUserDaoMapper();
		User u = dao.findUserByUserid(user.getUserid());
		if (u != null) {
			throw new ServiceException("用户已经存在");
		} else {
			dao.saveUser(user);
		}
	}

	@Override
	public User login(String userid, String password) throws ServiceException {
		// TODO Auto-generated method stub
		IUserDaoMapper dao = getIUserDaoMapper();
		User u = dao.findUserByUserid(userid);
		if (u != null) {
			if (password.equals(u.getPassword())) {
				return u;
			} else {
				throw new ServiceException("密码错误");
			}
		} else {
			throw new ServiceException("用户不存在");
		}
	}

}
