package app.daos.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.daos.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	public T findById(Integer id) {
		return hibernateTemplate.get(clazz, id);
	}

	public List<T> findAll() {
		return (List<T>) hibernateTemplate.find("from User");
	}
}
