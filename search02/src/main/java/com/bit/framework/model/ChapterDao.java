package com.bit.framework.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.framework.model.entity.ChapterVo;

public interface ChapterDao {

	List<ChapterVo> selectAll() throws SQLException;
	void insertOne(ChapterVo bean) throws SQLException;

}
