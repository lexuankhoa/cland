package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.User;

@Service
public class UserService implements ICRUDService<User> {
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDAO.getAll();
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return userDAO.update(t);
	}

	@Override
	public int save(User t) {
		// TODO Auto-generated method stub
		return userDAO.save(t);
	}

	@Override
	public int del(User t) {
		// TODO Auto-generated method stub
		return userDAO.del(t.getId());
	}

	@Override
	public User findOne(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public List<User> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return userDAO.getAll(offset, rowCount);
	}

	public List<User> getSearch(String search,int offset, int rowCount) {
		// TODO Auto-generated method stub
		return userDAO.getSearch(search, offset, rowCount);
	}

	public int totalRow() {
		// TODO Auto-generated method stub
		return userDAO.totalRow();
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasUser(String username) {
		// TODO Auto-generated method stub
		return userDAO.hasUser(username);
	}

	public int totalRowSearch(String search) {
		return userDAO.totalRowSearch(search);
	}
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
}
