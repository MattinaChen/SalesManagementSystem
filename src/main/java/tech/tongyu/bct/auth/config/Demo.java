package tech.tongyu.bct.auth.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
	public static void main(String[] args) {
		String name ="20190617";
		String substring = name.substring(0,4);
		String substring2 = name.substring(4,6);
		String substring3 = name.substring(6);
		System.out.println(substring+"-"+substring2+"-"+substring3);
	}

}
