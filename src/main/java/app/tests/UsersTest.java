package app.tests;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.daos.UserMapper;
import app.models.User;
import app.services.UsersService;
import net.sf.jsqlparser.statement.insert.Insert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UsersTest {
	
	//@Autowired
	//DepartmentMapper departmentMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void update() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(18);
		user.setEmail("testnihao");
		userMapper.updateByPrimaryKey(user);
		System.out.println(user.toString());
	}
	
	@Test
	public void Insert() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User("zn1", 222, "333@qq.com", "passworee");
		userMapper.insert(user);
		System.out.println(user.getId());
	}
	
	@Test
	public void selectByEmail() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectByEmail("222@qq.com");
		System.out.println(user.getEmail());
	}
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){	
		//1、插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
		
		//2、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0;i<1000;i++){
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null,uid, "M", uid+"@qq.com", 1));
//		}
		System.out.println("批量完成");
	}

}