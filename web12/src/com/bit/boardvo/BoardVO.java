package com.bit.boardvo;

import java.sql.Date;

public class BoardVO {

	
	private int num, ref, no, lev;
	private String title, writer, content;
	private String wtime;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWtime() {
		return wtime;
	}
	public void setWtime(String string) {
		this.wtime = string;
	}
	
	
}
/*
 *  NUM                                       NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(30)
 WRITER                                             VARCHAR2(30)
 WTIME                                              DATE
 CONTENT                                            VARCHAR2(2000)
 REF                                                NUMBER
 NO                                                 NUMBER
 LEV
 * 
 * */
