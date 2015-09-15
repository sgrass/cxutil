<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	
	String str = null;

	if ("a".equals(request.getParameter("flag"))) {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		str = "[{key:'"+name+"',value:'"+passwd+"'},{key:'111',value:'bbb'}]";
		
	} else if ("b".equals(request.getParameter("flag"))) {
		str = "['第二个按钮','\"第二次\"']";
		
	}	else if ("c".equals(request.getParameter("flag"))) {
		String[] param = request.getParameterValues("param[]");
		str = "['"+param[0]+"','"+param[1]+"','"+param[2]+"']";
		
	} else if ("d".equals(request.getParameter("flag"))) {
		str = "[{name:'zhangsan',info:{age:'12',sex:'man'}}]";
		
	} else if ("e".equals(request.getParameter("flag"))) {
		str = "[{school:'xiaoxue',teacher:[{id:'111',sex:'man'},{id:'222',sex:'woman'}]}]";
	}
	
	out.println(str);
%>
