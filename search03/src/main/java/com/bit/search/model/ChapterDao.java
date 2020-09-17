package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.search.model.entity.ChapterVo;

public interface ChapterDao {

	List<ChapterVo> selectAll() throws SQLException;
	List<ChapterVo> selectOneAll(int key) throws SQLException;
	void insertOne(ChapterVo bean) throws SQLException;

}
