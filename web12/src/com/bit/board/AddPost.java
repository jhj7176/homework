package com.bit.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.boardvo.BoardDao;

public class AddPost extends HttpServlet {
	
	Logger log = Logger.getGlobal();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
	
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("post_content");
		
		BoardDao dao = new BoardDao();
		try {
			dao.addPost(title, writer, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			log.config(title+", "+ writer);
		}
		
	}
}
