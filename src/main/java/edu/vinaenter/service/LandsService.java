package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandsDAO;
import edu.vinaenter.models.Lands;
import edu.vinaenter.models.User;

@Service
public class LandsService implements ICRUDService<Lands> {
	@Autowired
	private LandsDAO landsDAO;
	@Override
	public List<Lands> getAll() {
		// TODO Auto-generated method stub
		return landsDAO.getAll();
	}

	@Override
	public List<Lands> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return landsDAO.getAll(offset, rowCount);
	}
	public List<Lands> getAll(int cid,int offset, int rowCount) {
		// TODO Auto-generated method stub
		return landsDAO.getAll(cid,offset, rowCount);
	}
	@Override
	public int update(Lands t) {
		// TODO Auto-generated method stub
		return landsDAO.update(t);
	}

	@Override
	public int save(Lands t) {
		// TODO Auto-generated method stub
		return landsDAO.save(t);
	}

	@Override
	public int del(Lands t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return landsDAO.del(id);
	}

	@Override
	public Lands findOne(Lands t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lands findById(int id) {
		// TODO Auto-generated method stub
		return landsDAO.findById(id);
	}
	public List<Lands> getLandListByView() {
		// TODO Auto-generated method stub
		return landsDAO.getLandListByView();
	}
//	public List<Lands> getLandsSearch(String landSeach) {
//		// TODO Auto-generated method stub
//		return landsDAO.getLandsSearch(landSeach);
//	}

	public int totalRow() {
		// TODO Auto-generated method stub
		return landsDAO.totalRow();
	}

	public int updateCountView(int countView, int lid) {
		return landsDAO.updateCountView(countView, lid);
	}

	public List<Lands> getSearch(String search,int offset, int rowCount) {
		// TODO Auto-generated method stub
		return landsDAO.getSearch(search, offset, rowCount);
	}

	public int totalRowSearch(String search) {
		// TODO Auto-generated method stub
		return landsDAO.totalRowSearch(search);
	}
}