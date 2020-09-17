package com.bit.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.framework.model.ChapterDao;

public class MyBooksController implements Controller {

	ChapterDao chapterDao;

	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mybooks");
		mav.addObject("bookChapters",chapterDao.selectAll());
		
		return mav;
	}

}
