package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Lands;

@Repository
public class LandsDAO extends AbstractDAO<Lands> {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Lands> getAll(int offset, int rowCount) {
		final String SQL = "SELECT l.*, c.cname  FROM lands AS l INNER JOIN categories AS c WHERE l.cid = c.cid ORDER BY l.lid DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
			List<Lands> lands = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("cid"), rs.getString("cname")));
					lands.add(land);
				}
				return lands;
			}
		}, offset, rowCount);
	}

	public int save(Lands t) {
		final String SQL = "INSERT INTO lands(lname, description,picture,cid, address,area) VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getPicture(), t.getCategory().getCid(),
				t.getAddress(), t.getArea());
	}

	// phân trang
	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow FROM lands l INNER JOIN categories c ON l.cid = c.cid";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM lands WHERE lid = ?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Lands findById(int id) {
		String sql = "SELECT * FROM lands WHERE lid =?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Lands.class), id);
	}
	@Override
	public int update(Lands t) {
		final String sql = "UPDATE lands SET lname=?,cid=?,description=?,picture=?,address=?,area=?  WHERE lid=?";
		// TODO Auto-generated method stub
		return jdbcTemplate.update(sql, t.getLname(), t.getCategory().getCid(), t.getDescription(), t.getPicture(),
				t.getAddress(), t.getArea(), t.getLid());
	}
	public List<Lands> getAll(int cid, int offset, int rowCount) {
		final String SQL = "SELECT l.*, c.cname  FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid=?  ORDER BY lid DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
			List<Lands> lands = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("cid"), rs.getString("cname")));
					lands.add(land);
				}
				return lands;
			}
		}, cid, offset, rowCount);
	}
	public int updateCountView(int countView, int lid) {
		String sql = "UPDATE lands SET count_views = ? WHERE lid = ?";
		return jdbcTemplate.update(sql, countView, lid);
	}

	public List<Lands> getLandListByView() {
		String sql = "SELECT * FROM lands INNER JOIN categories ON lands.cid = categories.cid ORDER BY count_views DESC LIMIT 3";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> list = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("cid"), rs.getString("cname"))));
				}
				return list;
			}
		});
	}

	public List<Lands> getSearch(String search, int offset, int rowCount) {
		String sql = "SELECT * FROM lands INNER JOIN categories ON lands.cid = categories.cid WHERE lname LIKE ? ORDER BY lid DESC LIMIT ?,?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> list = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("cid"), rs.getString("cname"))));
				}
				return list;
			}
		}, "%" + search + "%", offset, rowCount);
	}
	public int totalRowSearch(String search) {
		String sql = "SELECT COUNT(*) FROM lands INNER JOIN categories ON lands.cid = categories.cid WHERE lname LIKE ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, "%" + search + "%");
	}

}
