package com.bit.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.boardvo.BoardDao;

public class BoardPosts extends HttpServlet{
//총게시글 수 리턴
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/xml;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		String key = req.getParameter("key");
		String word = req.getParameter("word");
		if(key==null||key.trim()=="") key = "title";
		if(word==null||word.trim()=="") word = "";
		BoardDao dao = new BoardDao();
		int cardinality = dao.getCardinality(key, word);
		System.out.println(cardinality);
		PrintWriter out = resp.getWriter();
		out.print("<board>");
		out.print("<post>");
		out.print("<cardinality>"+cardinality+"</cardinality>");
		out.print("</post>");
		out.print("</board>");
		
	
	}
}
