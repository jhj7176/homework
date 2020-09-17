package com.search.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class Crawling
 */
@WebServlet("/crawling.bit")
public class Crawling extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Jsoup를 이용해서 http:크롤링
		int bid = Integer.parseInt(request.getParameter("bid"));
		String url = "https://book.naver.com/bookdb/book_detail.nhn?bid="+bid; // 크롤링할 url지정
		Document doc = null; // Document에는 페이지의 전체 소스가 저장된다
		System.out.println("크로울링 컨트롤러!! url = " + url);
		try {
			doc = Jsoup.connect(url).get();
			System.out.println(doc);
		//	doc.select("br").append("\\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(doc);
		out.close();
		// select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
	/*	Elements element = doc.select("#tableOfContentsContent");

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		for (Element e : element.select("p")) {
			str = e.text();
		}
		System.out.println(str);

		// ? 왜 안잘릴까영?
		String[] splitStr = str.split("\\n");
		for (int i = 0; i < splitStr.length; i++) {
			list.add(splitStr[i]);
			System.out.println();

		}*/

	}
}
