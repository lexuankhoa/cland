package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Contact;
import edu.vinaenter.models.Contact;

@Repository
public class ContactDAO extends AbstractDAO<Contact> {
	
	@Override
	public List<Contact> getAll(){
		final String SQL = "SELECT * FROM vnecontact ORDER BY ct_id DESC";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Contact.class));
	}
	
	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM vnecontact WHERE ct_id = ?";
		return jdbcTemplate.update(SQL, id);
	}
	
	@Override
	public int save(Contact t) {
		final String SQL = "INSERT INTO vnecontact (ct_fullname, ct_email, ct_subject, ct_content) VALUES (?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getCt_fullname(), t.getCt_email(), t.getCt_subject(), t.getCt_content());
	}

	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow FROM vnecontact";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public List<Contact> getAll(int offset, int rowCount) {
		final String SQL = "SELECT *  FROM vnecontact ORDER BY ct_fullname DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Contact>>() {
			List<Contact> contacts = new ArrayList<Contact>();

			@Override
			public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Contact contact = new Contact(rs.getInt("ct_id"),rs.getString("ct_fullname"), rs.getString("ct_email"), rs.getString("ct_subject"), rs.getString("ct_content"));
					contacts.add(contact);
				}
				return contacts;
			}
		}, offset, rowCount);
	}

	public List<Contact> getSearch(String search, int offset, int rowCount) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM vnecontact WHERE ct_fullname LIKE ? ORDER BY ct_id DESC LIMIT ?,?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), "%" + search + "%", offset, rowCount);
	}
	public int totalRowSearch(String search) {
		String sql = "SELECT COUNT(*) FROM vnecontact WHERE ct_fullname LIKE ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, "%" + search + "%");
	}
}
