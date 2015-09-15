<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
		<script type="text/javascript" src="jquery-1.3.2.js"></script>
  </head>
  
  <body>
  <%
  	List list = new ArrayList();
  	list.add("aaa");
  	list.add("bbb");
  	list.add("ccc");
  	
  	String arr[] = request.getParameterValues("arr");
 		if (arr != null) {
  		for (int a=0; a<arr.length; a++) {
  			list.add(arr[a]);
  			System.out.println(arr[a]);
  		} 
 		}
 		System.out.println(list.size());
 		request.setAttribute("list",list);
  	for (int i=0; i<list.size(); i++) {
  %>
  <%} %>
  <div id="dis">
  <table width="50%" border="1">
  <c:forEach items="${list}" var="str">
  	<tr><td>${str}</td></tr>
  </c:forEach>
  </table>
  </div>
  
  </body>
</html>
