package com.bit.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.boardvo.BoardDao;

public class EditPost extends HttpServlet {
//edit_title
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");
		
		try {
			String param1=req.getParameter("num");
			int num = Integer.parseInt(param1);
			String title = req.getParameter("title");
			//String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardDao dao = new BoardDao();
			dao.editPost(num, title, content);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
