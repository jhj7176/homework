package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.search.model.entity.StudyVo;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.Setter;

public class StudyDaoImpl implements StudyDao{

	
	@Setter
	SqlMapClient sqlMapClient;
	
	
	
	@Override
	public List<StudyVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("selectStudyAll");
	}

	@Override
	public StudyVo selectOne(int key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(StudyVo bean) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("insertStudy",bean);
	}

	
}
