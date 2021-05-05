package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CategoryDAO;
import edu.vinaenter.models.Category;

@Service
//genaric
public interface ICRUDService<T> {

	List<T> getAll();

	List<T> getAll(int offset, int rowCount);

	int update(T t);

	int save(T t);

	int del(T t);

	int del(int id);

	T findOne(T t);

	T findById(int id);
}
