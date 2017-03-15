package com.SchoolBlog.util;

public class RemoveBlank {

	public static String ofStart(String string){
		StringBuffer sb=new StringBuffer(string);
		while(true){
			char sb0=sb.charAt(0);
			if('\0'!=sb0&&' '!=sb0&&'\n'!=sb0&&'#'!=sb0){
				break;
				
			}else{
				sb.deleteCharAt(0);
			}	
		}
		return sb.toString();
	}
	
	
}
