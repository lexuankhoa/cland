package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CategoryDAO;
import edu.vinaenter.models.Category;

@Service
public class CatService implements ICRUDService<Category> {
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub

		return categoryDAO.getAll();
	}

	@Override
	public int update(Category t) {
		// TODO Auto-generated method stub
		return categoryDAO.update(t);
	}

	@Override
	public int save(Category t) {
		// TODO Auto-generated method stub
		return categoryDAO.save(t);
	}

	@Override
	public int del(Category t) {
		return categoryDAO.del(t.getCid());
	}

	@Override
	public Category findOne(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.findById(id);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return categoryDAO.getAll(offset, rowCount);
	}

	public List<Category> getSearch(String search,int offset, int rowCount) {
		// TODO Auto-generated method stub
		return categoryDAO.getSearch(search,offset, rowCount);
	}

	public int totalRow() {
		// TODO Auto-generated method stub
		return categoryDAO.totalRow();
	}
	public List<Category> getCatHot() {
		return categoryDAO.getCatHot();
	}

	public List<Category> getAll2() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll2();
	}
	public int totalRowSearch(String search) {
		return categoryDAO.totalRowSearch(search);
	}

	public String getName(int cid) {
		// TODO Auto-generated method stub
		return categoryDAO.getName(cid);
	}

}
