package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.search.model.entity.BookVo;
import com.bit.search.model.entity.ChapterVo;


public interface BookDao {
	
	List<BookVo> selectAll() throws SQLException;
	BookVo selectOne(int key) throws SQLException;
	void insertOne(BookVo bean) throws SQLException;

}
