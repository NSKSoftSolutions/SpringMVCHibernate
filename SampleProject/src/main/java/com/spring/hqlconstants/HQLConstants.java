package com.spring.hqlconstants;

public class HQLConstants {

	public static String check_user=" from User u where u.mobile=? or u.email=?";
	public static String validate_user_login="from User u where u.mobile=? and u.password=?";
	
}
