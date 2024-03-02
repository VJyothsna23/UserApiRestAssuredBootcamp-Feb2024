package Pojos;

import java.util.List;

public class userPojo {
	
	String user_first_name;
    String user_last_name;
    String user_contact_number;
    String user_email_id;
    userAddressPojo userAddress;

	public userPojo() {
    	
    }
    
    public userPojo(String fname,String lname,String number,String email,userAddressPojo address) {
    	setUser_first_name(fname);
    	setUser_last_name(lname);
    	setUser_contact_number(number);
    	setUser_email_id(email);
    	setUserAddress(address);	
    }
    
    public String getUser_first_name() {
        return user_first_name;
    }
    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }
    public String getUser_last_name() {
        return user_last_name;
    }
    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }
    public String getUser_contact_number() {
        return user_contact_number;
    }
    public void setUser_contact_number(String user_contact_number) {
        this.user_contact_number = user_contact_number;
    }
    public String getuser_email_id() {
        return user_email_id;
    }
    public void setUser_email_id(String user_email_id) {
        this.user_email_id = user_email_id;
    }
    
    public userAddressPojo getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(userAddressPojo userAddress) {
		this.userAddress = userAddress;
	}

}
