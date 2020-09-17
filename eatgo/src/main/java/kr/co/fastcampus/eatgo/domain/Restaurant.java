package kr.co.fastcampus.eatgo.domain;

public class Restaurant {

	private long id;
	private String name;
	private String address;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(long id,String name, String address) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return "Bob zip";
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	public String getInformation() {
		// TODO Auto-generated method stub
		return name + " in " + address;
	}

}
