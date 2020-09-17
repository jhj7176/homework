package com.bit.framework.model.entity;

public class BookVo {
	private int book_id;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public BookVo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
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
		BookVo other = (BookVo) obj;
		if (book_id != other.book_id)
			return false;
		return true;
	}

	public BookVo(int book_id) {
		super();
		this.book_id = book_id;
	}

	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + "]";
	}

}
