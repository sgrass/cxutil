<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>My JSP 'aa.jsp' starting page</title>
  </head>
  
  <body>
  	<form name="f" method="post" action="bb.jsp">
	  	<input type="hidden" name="key1" value="隐藏的值">
			<input type="text" name="key2" value="显示的值">
			<input type="radio" name="key3" value="选中的值" checked>
			<input type="radio" name="key3" value="未选中的值">
			<input type="checkbox" name="key4" value="选中的值" checked>
			<input type="checkbox" name="key4" value="选中的值" checked>
			<textarea name="key6">多行文本</textarea>
			<br>
			<input type="submit">
		</form>
  </body>
</html>
