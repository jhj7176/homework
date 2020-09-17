package com.bit.framework.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.framework.model.BookDao;
import com.bit.framework.model.ChapterDao;
import com.bit.framework.model.entity.ChapterVo;

public class PutController implements Controller {

	ChapterDao chapterDao;
	BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String Contents = request.getParameter("chapters");
		
		bookDao.insertOne(book_id);
		
		String[] tmp = Contents.split("\n");	
		for (String chapter : tmp) {
			ChapterVo bean = new ChapterVo(book_id, chapter, null);
			chapterDao.insertOne(bean);
		}
		return null;
	}

}
