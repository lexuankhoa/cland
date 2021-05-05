package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.ContactDAO;
import edu.vinaenter.models.Contact;

@Service
public class ContactService implements ICRUDService<Contact> {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public List<Contact> getAll() {
		return contactDAO.getAll();
	}

	@Override
	public int update(Contact t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Contact t) {
		return contactDAO.save(t);
	}

	@Override
	public int del(int id) {
		return contactDAO.del(id);
	}

	@Override
	public Contact findOne(Contact t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return contactDAO.getAll(offset, rowCount);
	}

	@Override
	public int del(Contact t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int totalRow() {
		// TODO Auto-generated method stub
		return contactDAO.totalRow();
	}

	public List<Contact> getSearch(String search, int offset, int rowCount) {
		// TODO Auto-generated method stub
		return contactDAO.getSearch(search, offset, rowCount);
	}

	public int totalRowSearch(String search) {
		return contactDAO.totalRowSearch(search);
	}
}
