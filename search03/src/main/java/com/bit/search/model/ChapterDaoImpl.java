package com.bit.search.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.search.model.entity.ChapterVo;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.Setter;

public class ChapterDaoImpl implements ChapterDao {

	@Setter
	@Autowired
	SqlMapClient sqlMapClient;

	@Override
	public List<ChapterVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("selectAll");
	}

	@Override
	public void insertOne(ChapterVo bean) throws SQLException {
		// TODO Auto-generated method stub
	//	System.out.println(bean);
		sqlMapClient.insert("insertOne", bean);

	}

	@Override
	public List<ChapterVo> selectOneAll(int key) throws SQLException {
		// TODO Auto-generated method stub
	//	System.out.println("책 아이디 "+key);
		return sqlMapClient.queryForList("selectBookChapters", key);
	}

}
