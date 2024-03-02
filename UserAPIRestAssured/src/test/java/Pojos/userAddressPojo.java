package Pojos;

public class userAddressPojo {

	String plotNumber;
	String street;
	String state;
	String country;
	String zipCode;

	public userAddressPojo() {

	}

	public userAddressPojo(String plot,String str,String st,String con,String zip) {
		setPlotNumber(plot);
		setStreet(str);
		setState(st);
		setCountry(con);
		setZipCode(zip);
	}

	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	

}
