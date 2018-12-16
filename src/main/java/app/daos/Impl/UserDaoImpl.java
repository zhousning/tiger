package app.daos.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.daos.BaseDao;
import app.daos.UserDao;
import app.models.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User selectByEmail(String principal) {
		// TODO Auto-generated method stub
		return null;
	}

}
