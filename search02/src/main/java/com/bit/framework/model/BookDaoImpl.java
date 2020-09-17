package com.bit.framework.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.framework.model.entity.ChapterVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BookDaoImpl implements BookDao {

	SqlMapClient sqlMapClient;

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public List<ChapterVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(int key) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("insertBook", key);
	}

}
