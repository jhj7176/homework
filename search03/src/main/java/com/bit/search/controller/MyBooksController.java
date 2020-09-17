package com.bit.search.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.search.model.BookDao;
import com.bit.search.model.ChapterDao;
import com.bit.search.model.entity.BookVo;

import lombok.Setter;

@Controller
public class MyBooksController {

	@Autowired
	ChapterDao chapterDao;
	@Autowired
	BookDao bookDao;

	@RequestMapping("/mylib.bit")
	public ModelAndView showBooks() throws Exception {
		return new ModelAndView("mybooks", "books", bookDao.selectAll());
	}
	
	@RequestMapping("/mybooks.bit")
	public ModelAndView showChapters(@RequestParam int book_id, HttpServletRequest request) throws Exception {
	//	req.setAttribute("book", bookDao.selectOne(book_id));
		request.setAttribute("book", bookDao.selectOne(book_id));
	//	System.out.println(bookDao.selectOne(book_id));
		return new ModelAndView("mybookchapters", "bookChapters", chapterDao.selectOneAll(book_id));
	}

}
