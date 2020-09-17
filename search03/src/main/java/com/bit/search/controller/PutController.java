package com.bit.search.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.search.model.BookDao;
import com.bit.search.model.ChapterDao;
import com.bit.search.model.StudyDao;
import com.bit.search.model.entity.BookVo;
import com.bit.search.model.entity.ChapterVo;
import com.bit.search.model.entity.StudyVo;

@Controller
public class PutController {
	static private int uesr_test_cnt = 1;
	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private StudyDao studyDao;

	@RequestMapping("/put.bit")
	public ModelAndView insertChapters(@ModelAttribute BookVo book, @ModelAttribute StudyVo study, String chapters)
			throws Exception {

		// Book talble에 책 정보입력

		bookDao.insertOne(book);


		// Toc목차 테이블에 입력

		if (chapterDao.selectOneAll(book.getBook_id()) != null) {
			//toc에 같은책의 목차가 있으면 insert하지않음
		} else {

			String[] tmp = chapters.split("\n");
			for (String chapter : tmp) {
				if (chapter.trim().equals("")) { // 빈줄제거
					continue;
				} else {
					chapterDao.insertOne(new ChapterVo(book.getBook_id(), chapter.trim()));
				} // if
			} // for

			// test용 user_id
		}//out if
		
		study.setUser_user_id(uesr_test_cnt);
		study.setBook_book_id(book.getBook_id());
		studyDao.insertOne(study);
		uesr_test_cnt++;

		return null;
	}// insertChapters

}
