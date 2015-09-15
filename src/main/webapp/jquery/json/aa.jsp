<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>jq_client.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="jquery-1.3.2.js"></script>
    <script type="text/javascript">
		   $(function() {
		   	$("#btn").click(function () {
		   		var name = $("#name").val();
					var passwd = $("#passwd").val();
					var str = [name,passwd];

					$.ajax({
						type: "POST",
						url:"aa.jsp",
						dataType:"json",
						data: {name:name,passwd:passwd,flag:'a'},
						success : function(data) {
							//for (var i=0; i<data.length; i++) {
								alert(data.name+"----"+data.passwd);
							//}
						}
					});
		   	});
		   });
    </script>
  </head>
  
  <body>
  <%
  	System.out.println(request.getParameter("name")+"--->"+request.getParameter("passwd"));
  	if ("a".equals(request.getParameter("flag"))) {
  		out.println("[{name:'aaa',passwd:'AAA'}]");
  	}
  %>
  	<input type="text" id="name"><br>
 		<input type="text" id="passwd"><br>
 		<input type="button" id="btn" value="button1">
 		<div id="target"></div>
 	</body>
</html>
