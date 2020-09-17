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

public class BoardContent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/xml;charset=utf-8");
		req.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();

		String param = req.getParameter("num");
		int idx = Integer.parseInt(param);

		BoardDao dao = new BoardDao();
		BoardVO bean = dao.getContent(idx);
		System.out.println(bean.getContent());
		out.print("<board>");
		out.print("<post>");
		out.print("<num>" + bean.getNum() + "</num>");
		out.print("<title>" + bean.getTitle() + "</title>");
		out.print("<writer>" + bean.getWriter() + "</writer>");
		out.print("<wtime>" + bean.getWtime() + "</wtime>");
		out.print("<content>" + bean.getContent() + "</content>");
		out.print("</post>");
		out.print("</board>");
		out.close();

	}
}
