package com.bit.framework.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.framework.model.entity.ChapterVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ChapterDaoImpl implements ChapterDao {
	
	SqlMapClient sqlMapClient;
	//applicationContext.xml에서 sqlMapClient를 주입받음
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}



	@Override
	public List<ChapterVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("selectAll");
	}



	@Override
	public void insertOne(ChapterVo bean) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("insertOne", bean);
		
	}

}
