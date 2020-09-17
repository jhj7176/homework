package com.bit.search.model.entity;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookVo {
	private int book_id;
	private String title, writer, publisher, category, isbn, translator, title_original, revision,img_url;
	private int pages;
	private Date publication_date;
	
	// chapters, book_id, title, writer, publisher, pages, category, isbn,
	// translator, title_original, publication_date, revision;
}
