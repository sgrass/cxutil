<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
		<script type="text/javascript" src="jquery-1.3.2.js"></script>
		<script type="text/javascript">
			$(function () {
				$("#aa").click(function (){
					//var arr = new Array();
					//arr[0] = "ddd";
					//arr[1] = "eee";
					var arr = ["hhh","ggg"];
					
					$.ajax({
						type: "POST",
						cache: false,
	    			url: "aa.jsp",
	    			dataType:"json",
	    			data: {arr:arr},
	    			success: function(arr) {
	    				alert(arr);
	    				$("#txt").val(arr);
	    			}
					});
				});
			});
		</script>
  </head>
  
  <body>
  <table width="50%" border="1">
  <%
  	List list = new ArrayList();
  	list.add("aaa");
  	list.add("bbb");
  	list.add("ccc");
  	/*
  	String arr[] = request.getParameterValues("arr");
 		if (arr != null) {
  		for (int a=0; a<arr.length; a++) {
  			list.add(arr[a]);
  			System.out.println(arr[a]);
  		} 
 		}*/
 		System.out.println(list.size());
  	for (int i=0; i<list.size(); i++) {
  		System.out.println(list.get(i));
  %>
  	<tr><td><%=list.get(i)%></td></tr>
  <%} %>
  </table>
  <input type="text" value="" id="txt">
  <input type="button" value="aaaaa" id="aa">
  
  </body>
</html>
