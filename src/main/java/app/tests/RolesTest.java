package app.tests;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import app.models.Role;
import app.models.User;
import app.services.RoleService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RolesTest {
	
	
	@Autowired
	RoleService roleService;
	
	@Test
	public void delete() {
		Role role = roleService.findById(1);
		roleService.delete(role);
	}

	@Test
	public void getRole() {
		Role role = roleService.findById(2);
		Set<User> users = role.getUsers();
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			System.err.println(user.getEmail());
		}
	}
}