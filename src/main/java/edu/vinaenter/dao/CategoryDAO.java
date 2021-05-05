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
import edu.vinaenter.models.User;

@Repository
public class CategoryDAO extends AbstractDAO<Category> {
	@Override
	public List<Category> getAll() {
		String sql = "SELECT * FROM categories ORDER BY cid DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
	}
	public List<Category> getAll2() {
		String sql = "SELECT categories.cid,cname,COUNT(lands.cid) FROM categories "
				+ "LEFT JOIN lands ON categories.cid = lands.cid "
				+ "GROUP BY lands.cid ORDER BY COUNT(lands.cid) DESC ";
		//ORDER BY COUNT(lands.cid) DESC
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Category>>() {
			List<Category> list = new ArrayList<Category>();

			@Override
			public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Category(rs.getInt("categories.cid"), rs.getString("cname"),
							rs.getInt("COUNT(lands.cid)")));
				}
				return list;
			}
		});
	}
	@Override
	public int save(Category category) {
		final String sql = "INSERT INTO categories(cname) VALUES (?)";
		return jdbcTemplate.update(sql, category.getCname());
	}

	@Override
	public Category findById(int id) {
		String sql = "SELECT * FROM categories WHERE cid =?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), id);
	}

	public List<Category> getAll(int offset, int rowCount) {
		final String SQL = "SELECT *  FROM categories ORDER BY cid DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Category>>() {
			List<Category> cats = new ArrayList<Category>();

			@Override
			public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Category cat = new Category(rs.getInt("cid"), rs.getString("cname"));
					cats.add(cat);
				}
				return cats;
			}
		}, offset, rowCount);
	}

	@Override
	public int del(int id) {
		String sql = "DELETE FROM categories WHERE cid =?";
		// TODO Auto-generated method stub
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int update(Category t) {
		final String sql = "UPDATE categories SET cname=? WHERE cid=?";
		// TODO Auto-generated method stub
		return jdbcTemplate.update(sql, t.getCname(), t.getCid());
	}
	/*
	 * @Autowired // DI private JdbcTemplate jdbcTemplate;
	 * 
	 * public List<Category> getList() { String sql =
	 * "SELECT * FROM categories ORDER BY cid DESC"; return jdbcTemplate.query(sql,
	 * new BeanPropertyRowMapper<>(Category.class)); }
	 * 
	 * public Category getById(int id) { String sql =
	 * "SELECT * FROM categories WHERE id =?"; return
	 * jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class),
	 * id);
	 * 
	 * }
	 * 
	 * public int save(Category category) { String sql =
	 * "INSERT INTO categories (name,description) VALUES (?,?)"; return
	 * jdbcTemplate.update(sql, category.getcName());
	 * 
	 * }
	 */

	public List<Category> getSearch(String search,int offset, int rowCount) {
//		String sql = "SELECT * FROM categories " + "WHERE 1";
//		if (!"".equals(search)) {
//			sql += " AND cname LIKE ?";
//		}
//		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Category>>() {
//			List<Category> cats = new ArrayList<Category>();
//
//			@Override
//			public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				while (rs.next()) {
//					Category cat = new Category(rs.getInt("cid"), rs.getString("cname"));
//					cats.add(cat);
//				}
//				return cats;
//			}
//		}, "%" + search + "%");
		String sql = "SELECT * FROM categories WHERE cname LIKE ? ORDER BY cid DESC LIMIT ?,?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class), "%" + search + "%", offset, rowCount);
	}

	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow FROM categories";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}
	public int totalRowSearch(String search) {
		String sql = "SELECT COUNT(*) FROM categories WHERE cname LIKE ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, "%" + search + "%");
	}
	public List<Category> getCatHot() {
		String sql = "SELECT categories.cid,cname,COUNT(lands.cid) FROM categories "
				+ "LEFT JOIN lands ON categories.cid = lands.cid "
				+ "GROUP BY lands.cid ORDER BY COUNT(lands.cid) DESC LIMIT 3";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Category>>() {
			List<Category> list = new ArrayList<Category>();

			@Override
			public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Category(rs.getInt("categories.cid"), rs.getString("cname"),
							rs.getInt("COUNT(lands.cid)")));
				}
				return list;
			}
		});
	}
	public String getName(int cid) {
		final String SQL = "SELECT cname  FROM categories WHERE cid=?";
		return jdbcTemplate.queryForObject(SQL, String.class,cid);
	}
	
}
