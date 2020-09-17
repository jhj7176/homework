package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.search.model.entity.StudyVo;


public interface StudyDao {
	
	List<StudyVo> selectAll() throws SQLException;
	StudyVo selectOne(int key) throws SQLException;
	void insertOne(StudyVo bean) throws SQLException;
}
