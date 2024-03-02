package endPoints;

import Config.PropertiesFile;

public class Routes {
	
	public static String base_url = PropertiesFile.readPropertiesFile("base_url");
	public static String Invalid_base_url = PropertiesFile.readPropertiesFile("Invalid_base_url");
//	public static String base_url = "https://userapi-8877aadaae71.herokuapp.com/uap";
//	public static String Invalid_base_url = "https://userapi-8877aadaae71.herokuapp.com";
	
	//POST Create Users
	public static String PostUser_Url = base_url+"/createusers";	
	public static String PostUser_InvalidUrl = Invalid_base_url+"/createusers";
	public static String PostUser_InvalidEP = base_url+"/create";
	
	//GET All Users
	public static String GetUsers_Url = base_url+"/users";
	public static String GetUsers_InvalidUrl = Invalid_base_url+"/users";
	public static String GetUsers_InvalidEP = base_url+"/user";

	//GET User by ID
	public static String GetUserID_Url = base_url+"/user/11327";
	public static String GetUserID_InvalidUrl = Invalid_base_url+"/user/11327";
	public static String GetUserID_InvalidEP = base_url+"/users/11327";
    public static String GetUserID_InvalidID = base_url+"/user";

	//GET User by FirstName
	public static String GetUserFirstName_Url = base_url+"/users/username/JyothsnaVe";
	public static String GetUserFirstName_InvalidUrl = Invalid_base_url+"/users/username/JyothsnaVe";
	public static String GetUserFirstName_InvalidEP = base_url+"/user/username/JyothsnaVe";
	public static String GetUserFirstName_InvalidFN = base_url+"/users/username";
	
	//PUT Update user by ID
	public static String PutUser_Url = base_url+"/updateuser/11327";
	public static String PutUserId_InvalidUrl = Invalid_base_url+"/updateuser/11327";
	public static String PutUserId_InvalidEP = base_url+"/update/11327";
	public static String PutUserId_InvalidID = base_url+"/updateuser";
	
	//DELETE User by ID
	public static String DeleteUserID_Url = base_url+"/deleteuser/14028";
	public static String DeleteUserID_InvalidUrl = Invalid_base_url+"/deleteuser/14028";
	public static String DeleteUserID_InvalidEP = base_url+"/delete/14028";
	public static String DeleteUserID_InvalidID = base_url+"/deleteuser";
	
	//DELETE User by FirstName
	public static String DeleteUserFirstName_Url = base_url+"/deleteuser/username/JyoVe";
	public static String DeleteUserFirstName_InvalidUrl = Invalid_base_url+"/deleteuser/username/JyoVe";
	public static String DeleteUserFirstName_InvalidEP = base_url+"/deleteuser/user/JyoVe";
	public static String DeleteUserFirstName_InvalidFN = base_url+"/deleteuser/username";

}
