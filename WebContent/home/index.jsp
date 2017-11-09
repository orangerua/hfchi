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
<title>主页</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<img id="headpic" alt="" src="upload/aaaa.jpg" style="height: 60px;width: 60px">
<form action="user/uploadAction!updatehead" enctype="multipart/form-data" method="post">
<input type="hidden" name="user.userId" value='<s:property value="#session.loginUser.userId"/>' readonly="readonly">
<input type="file" name="pic">
<input type="submit" value="上传头像">
</form>



<div id="userid"><s:property value="#session.loginUser.userId"/></div>
<table id="showrecord" style="float: left;"></table>
<table id="showdetail" style="float: left;"></table>

<script type="text/javascript">
$(function(){
	var userid=$("#userid").html();
	var param={"user.userId":userid};
	$.ajax({
		url:"record/recordAction!getLoginRecord",
		type:"GET",
		dataType:"json",
		data:param,
		success:function(data){
			var json=eval("("+data+")");
			var str="";     
            $.each(json,function(index,item){

            	str+='<tr><td>'+item.user.userName+'</td><td>'+item.ip+'</td><td>'+item.address+'</td><td>'+(item.loginDate.year+1900)+"年"+(item.loginDate.month+1)+"月"+item.loginDate.date+"日"+item.loginDate.hours+"点"+item.loginDate.minutes+"分"+item.loginDate.seconds+"秒"+'</td><td>'+'<button id="'+item.ip+'">详情</button>'+'</td></tr>'
            
            });  
            $("#showrecord").html(str);
		}
		
	});
	$(document).delegate('button', 'click', function() { 
	 var userid=$("#userid").html();
	 var ip=$(this).attr("id");
	 var param={"record.ip":ip,"record.user.userId":userid};
		$.ajax({
			url:"record/recordAction!getRecordDetail",
			type:"GET",
			dataType:"json",
			data:param,
			success:function(data){
				var json=eval("("+data+")");
				var str="";            
	            $.each(json.list,function(index,item){
	            	str+='<tr><td>'+item.user.userName+'</td><td>'+item.ip+'</td><td>'+item.address+'</td><td>'+(item.loginDate.year+1900)+"年"+(item.loginDate.month+1)+"月"+item.loginDate.date+"日"+item.loginDate.hours+"点"+item.loginDate.minutes+"分"+item.loginDate.seconds+"秒"+'</td></tr>'
	            });  
	            $("#showdetail").html(str);
			}
		});
	
	});
})
</script>


</body>
</html>