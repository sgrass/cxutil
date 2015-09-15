<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%> 
<html>
  <head>
    

  </head>
  
  <body>
    <%
    	out.print("JQ异步成功了");
    	String name = request.getParameter("name");
    	String passwd = request.getParameter("passwd");
    	
    	if ("get".equalsIgnoreCase(request.getMethod())) {
    		out.print("<br>GET方式: name="+name+"\t passwd="+passwd);
    	} else {
    		out.print("<br>POST方式: name="+name+"\t passwd="+passwd);
    	}
    %>
  </body>
</html>
