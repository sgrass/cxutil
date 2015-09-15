<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Enumeration"%>
<html>
  <head>
    <title>My JSP 'bb.jsp' starting page</title>
  </head>
  
  <body>
  <%/*获取页面所有html标签name以及value*/%>
 	<%
 		request.setCharacterEncoding("UTF-8");
 		System.out.println(request.getParameterNames());
 		for (Enumeration<?> e = request.getParameterNames(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			String value = "";
			String[] strValues = request.getParameterValues(name);
			for (int i = 0; i < strValues.length; i++) {
				value += strValues[i] + ", ";
				System.out.println("=="+strValues[i]+"==");
			}
			value = value.substring(0, value.length() - 2);
			
			System.out.println("\t" + name + " = " + value);
		}
 	%>
  </body>
</html>
