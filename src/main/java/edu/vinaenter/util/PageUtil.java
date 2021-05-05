package edu.vinaenter.util;

import edu.vinaenter.constant.GlobalConstant;

public class PageUtil {
	
	public static int getOffset(Integer page) {
		if(page == null) {
			page = 1;
		}
		return (page - 1)* GlobalConstant.TOTAL_ROW;
	}
	
	
	public static int getTotalPage(int totalRow) {
		
		return (int)Math.ceil((float)totalRow/GlobalConstant.TOTAL_ROW);
	}
}
