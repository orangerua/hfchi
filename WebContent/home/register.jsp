<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<input type="text" id="username1"><br>
<input type="password" id="password1"><br>
<input type="text" id="code1"><button id="getCode1">获取</button><br>
<button id="submit1">注册</button> 
<br>
<input type="text" id="username2"><br>
<input type="password" id="password2"><br>
<input type="text" id="code2"><button id="getCode2">获取</button><br>
<button id="submit2">注册</button>

<script type="text/javascript">
$(function(){
	$("#username2").blur(function(){
		var username=$("#username2").val();
		var param={"user.userName":username};
		$.ajax({
			url:"user/loginAndRegisterAction!checkUserName",
			type:"GET",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				alert(json.msg);
			}
			
		});
	});

	$("#getCode1").click(function(){
		var username=$("#username1").val();
		var param={"email":username};
		$.ajax({
			url:"user/loginAndRegisterAction!emailCode",
			type:"GET",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				alert(json.msg);
			}
		});
	});
	
	$("#getCode2").click(function(){
		var username=$("#username2").val();
		var param={"phone":username};
		$.ajax({
			url:"user/loginAndRegisterAction!phoneCode",
			type:"GET",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				alert(json.msg);
			}
		});
	});
	
	$("#submit1").click(function(){
		var username=$("#username1").val();
		var password=$("#password1").val();
		var param={"user.userName":username,"user.password":password};
		$.ajax({
			url:"user/loginAndRegisterAction!emailRegister",
			type:"POST",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				alert(json.msg);
				
			}
		});
	});
	$("#submit2").click(function(){
		var username=$("#username2").val();
		var password=$("#password2").val();
		var code=$("#code2").val();
		var param={"user.userName":username,"user.password":password,"code":code};
		$.ajax({
			url:"user/loginAndRegisterAction!phoneRegister",
			type:"POST",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				alert(json.msg);
				if(json.msg=="注册成功")
					{
					window.location.href="home/login.jsp";
				}
			}
		});
	})

})
</script>
</body>
</html>