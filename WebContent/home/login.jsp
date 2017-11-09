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
<title>登录</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="user/loginAndRegisterAction!login">
<input type="text" name="record.ip" id="ip" readonly="readonly"><br>
<input type="text" name="record.address" id="address" readonly="readonly"><br>
<input type="text" name="user.userName"><br>
<input type="password" name="user.password"><br>
<input type="submit" id="submit" value="登录">
</form>
<script type="text/javascript">
$(function(){
	$.ajax({
		url: "http://ip.chinaz.com/getip.aspx",
		type:"GET",
		dataType:"JSONP",
		success: function(data){
			var ip=data.ip;
			var address=data.address;
			$("#ip").val(ip);
			$("#address").val(address);
			
	    }	
	});
})
</script>
</body>
</html>