package com.bit.search.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudyVo {
   	private int study_id;
   	
	private int user_user_id;
	private int book_book_id;
	public StudyVo(int user_user_id, int book_book_id) {
		super();
		this.user_user_id = user_user_id;
		this.book_book_id = book_book_id;
	}
	
	
}
