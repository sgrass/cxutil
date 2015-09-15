<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <style type="text/css">
  	.datalist tr.altrow{
  		background-color:blue;
  	}
  	.myClass{
  		background-color:#c0ebff;
  		text-decoration:underline;
  	}
  	button{
  		border:1px solid #950074;
  	}
  </style>  
	<script type="text/javascript" src="jquery-1.3.2.js"></script>
	<script type="text/javascript">
		$(function() {
			$("table.datalist tr:nth-clild(odd)").addClass("altrow");
		});
		$(function () { 
			var str = "  1111  ";
			
			//alert($.trim(str).length);//去掉字符串前后空格
			
			var add = $("<a href='#' onclick='alert(111);'>add is href</a>");
			add.insertAfter("#aa");
			//$("h2:has(div)").addClass("myClass"); //h2标签中有div的设置css
			
			//$("h2:lt(2)").addClass("myClass"); //第三个h2标签前的h2标签全部设置css
		});
		
		function disabledButton() {
			$("button:gt(0)").attr("disabled","disabled"); //第一个button之后的button设置为disabled
		}
		
		$(function() {
			$("p").click(function (){
				$(this).toggleClass("myClass");  //单击设置p标记的背景色
			});
		});
		
		$(function() {
			var str = $("#font").text();  //只获取id=font的文本信息
			//var str = $("p:first").text();
			$("p:last").html(str);  //设置最后一个p标签的html为str 相当于innerHTML
		});
	</script>
  </head>
  
  <body>
  	<center>
  	<h2><a id="aa" href="#">超链1</a><div>hh</div></h2><br>
  	<h2><a href="#"><p>bb</p></a></h2>
  	
  	
  	<button onclick="disabledButton()">第一个button</button>
  	<button>第二个button</button>
  	<button>第三个button</button>
  	
  	<p>高亮?</p>
  	
  	<p id="font"><b>粗体</b><em>斜体</em></p>
  	<p></p>
  	
  	<form action="" method="post" name="frm">
  		<input type="text" id="aa" name="w">
  		<input type="submit" value="submit">
  	</form>
  	
  	<table class="datalist" border="1">
  		<tr>
				<th>aaa</th>
				<th>bbb</th>
			</tr>
  		<tr>
				<td>aaa</td>
				<td>bbb</td>
			</tr>
			<tr>
				<td>aaa</td>
				<td>bbb</td>
			</tr>
  	</table>
  	</center>
  </body>
</html>
