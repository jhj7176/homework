package com.bit.search.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrawlingController {

	
	//책상세보기 페이지가 로딩될 때 비동기로 책정보 크롤링해서 가져감
	@RequestMapping("/find/crawling.bit")
	public ModelAndView crawlingBook(int bid, HttpServletResponse response) throws IOException {
//		int bid = Integer.parseInt(request.getParameter("bid"));
		String url = "https://book.naver.com/bookdb/book_detail.nhn?bid=" + bid; 
		Document doc = null; 
		System.out.println("크롤링!! url = " + url);
		try {
			doc = Jsoup.connect(url).get();
			//System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(doc);
		out.close();
		return null;
	}
	//검색목록에서 책 눌렀을 때 책 상세보기 페이지로 이동
	@RequestMapping("/find/book.bit")
	public ModelAndView findBook(int bid) {
		return new ModelAndView("findBook","bid",bid);
	}
}
