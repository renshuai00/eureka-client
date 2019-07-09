package com.eureka.client.eurekaclient.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;
public class SecurityUtils {
	/**
	 * 防止SQL注入
	 * @param name
	 * @return
	 */
	public static String getPara(HttpServletRequest request,String name){
		String s1 = request.getParameter(name);
		s1 = StringEscapeUtils.escapeSql(s1);
	    s1 = HtmlUtils.htmlEscape(s1);
	    s1 = JavaScriptUtils.javaScriptEscape(s1);
		return s1;
	}
	public static String getPara(String s1){
		s1 = StringEscapeUtils.escapeSql(s1);
		s1 = HtmlUtils.htmlEscape(s1);
		s1 = JavaScriptUtils.javaScriptEscape(s1);
		return s1;
	}
}
