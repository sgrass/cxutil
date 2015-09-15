<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%> 
<html>
  <head>
    

  </head>
  
  <body>
    <%
    	String name = request.getParameter("name");
    	String passwd = request.getParameter("passwd");
    	out.print(name+"\t"+passwd);
    %>
  </body>
</html>
