package com.bit.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.boardvo.BoardDao;
import com.bit.boardvo.BoardVO;

public class BoardControler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, NumberFormatException,IOException {

		resp.setContentType("application/xml;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();

		String key = req.getParameter("key");
		String word = req.getParameter("word");
		int pageNum;
		if (req.getParameter("pageNum") != null) {
			System.out.println(req.getParameter("pageNum"));
			pageNum = Integer.parseInt(req.getParameter("pageNum").trim());
		}else {
			pageNum=1;
		}
		BoardDao dao = new BoardDao();

		List<BoardVO> list = dao.getList(pageNum, key, word);
		
		//최신글순서대로 정렬된 리스트. 
		//key와 word는 검색어.
		/*
		 * <board> <post> <num></num> . . .... ... <lev></lev> </post> </board>
		 * 
		 */
		out.print("<board>");

		for (int i = 0; i < list.size(); i++) {
			BoardVO bean = list.get(i);
			out.print("<post>");
	
			out.print("<num>"+bean.getNum()+"</num>");
			out.print("<title>"+bean.getTitle()+"</title>");
			out.print("<writer>"+bean.getWriter()+"</writer>");
			out.print("<wtime>"+bean.getWtime()+"</wtime>");
			out.print("<content>"+bean.getContent()+"</content>");
			out.print("<ref>"+bean.getRef()+"</ref>");
			out.print("<no>"+bean.getNo()+"</no>");
			out.print("<lev>"+bean.getLev()+"</lev>");
			
			out.print("</post>");
		}
		out.print("</board>");
		out.close();
	}

}
