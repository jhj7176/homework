package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.search.model.entity.BookVo;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.Setter;

public class BookDaoImpl implements BookDao {

	@Setter
	@Autowired
	SqlMapClient sqlMapClient;

	@Override
	public List<BookVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("selectBooks");
	}

	@Override
	public void insertOne(BookVo book) throws SQLException {
		// TODO Auto-generated method stub
		try{
		    sqlMapClient.startTransaction();
		    sqlMapClient.insert("insertBook", book);
		    sqlMapClient.commitTransaction();
		}finally{
		    sqlMapClient.endTransaction();
		}

	}

	@Override
	public BookVo selectOne(int key) throws SQLException {
		// TODO Auto-generated method stub
		return (BookVo) sqlMapClient.queryForObject("selectBook", key);
	}

}
