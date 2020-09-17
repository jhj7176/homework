package com.bit.framework.model.entity;

public class ChapterVo {

	private int book_id;
	private String chapter, check;

	public ChapterVo() {
		// TODO Auto-generated constructor stub
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + ", chapter=" + chapter + ", check=" + check + "]";
	}

	public ChapterVo(int book_id, String chapter, String check) {
		super();
		this.book_id = book_id;
		this.chapter = chapter;
		this.check = check;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
		result = prime * result + ((chapter == null) ? 0 : chapter.hashCode());
		result = prime * result + ((check == null) ? 0 : check.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterVo other = (ChapterVo) obj;
		if (book_id != other.book_id)
			return false;
		if (chapter == null) {
			if (other.chapter != null)
				return false;
		} else if (!chapter.equals(other.chapter))
			return false;
		if (check == null) {
			if (other.check != null)
				return false;
		} else if (!check.equals(other.check))
			return false;
		return true;
	}

}

//book_id
/*
 * chapter check
 * 
 */
