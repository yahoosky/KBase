<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ajaxObject() {
		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("您的浏览器不支持AJAX！");
					return false;
				}
			}
		}
		return xmlHttp;
	}
</script>
<script type="text/javascript">
	// ajax post请求： 
	function ajaxPost(url, data, fnSucceed, fnFail, fnLoading) {
		var ajax = ajaxObject();
		ajax.open("post", url, true);
		ajax.setRequestHeader("Content-Type", "application/json");
		ajax.onreadystatechange = function() {
			console.log('ajax status change ' + ajax.readyState + " "
					+ ajax.readyState == 4)
			if (ajax.readyState == 4) {
				console.log('ajax status ' + ajax.status)
				if (ajax.status == 200) {
					fnSucceed(ajax.responseText);
				} else {
					fnFail("HTTP请求错误！错误码：" + ajax.status);
				}
			} else {
				fnLoading();
			}
		}
		data = JSON.stringify(data); //可以将json对象转换成json对符串 ;
		ajax.send(data);
	}
</script>
<script type="text/javascript">
	function sub() {
		var data = new Object();//传输对象
		var context = new Object();//交易上下文
		var contextUser = new Object();//上下文中用户信息
		contextUser.userId = '1';//当前用户编号
		contextUser.userName = 'aa';//当前用户名
		contextUser.lvl = '9';//当前柜员级别-登陆时获取
		context.user = contextUser;//用户信息添加至上下文
		data.context = context;//上下文添加至传输对象

		var menuMast = new Object();
		menuMast.parentId = document.getElementById("parentId").value;

		data.menuMast = menuMast;//业务数据
		data.lvl = document.getElementById("lvl").value;
		ajaxPost("comm/getMenu", data, function(data) {
			alert('SUC' + data);
		}, function() {
			alert('FATAL');
		});
	}

	function addMenu() {
		var data = new Object();//传输对象
		var context = new Object();//交易上下文
		var contextUser = new Object();//上下文中用户信息
		contextUser.userId = '1';//当前用户编号
		contextUser.userName = 'aa';//当前用户名
		contextUser.lvl = '9';//当前柜员级别-登陆时获取
		context.user = contextUser;//用户信息添加至上下文
		data.context = context;//上下文添加至传输对象

		var menuMast = new Object();
		menuMast.menuId = document.getElementById("add_menuId").value;
		menuMast.menuDesc = document.getElementById("add_menuDesc").value;
		menuMast.parentId = document.getElementById("add_parentId").value;
		menuMast.menuType = document.getElementById("add_menuType").value;
		menuMast.menuOwner = document.getElementById("add_menuOwner").value;
		menuMast.status = document.getElementById("add_status").value;
		data.menuMast = menuMast;//业务数据

		ajaxPost("comm/addMenu", data, function(data) {
			alert('SUC' + data);
		}, function() {
			alert('FATAL');
		});
	}
</script>
</head>
<body>
	<form method="post">
		ParentId:<input id="parentId" type="text" name="parentId" /> Lvl:<input
			id="lvl" type="text" name="lvl" /> <input type="button" value="查询"
			onclick="sub()" />
	</form>
	<hr></hr>

	<form method="post">
		MenuId:<input id="add_menuId" type="text" name="menuId" /><br />
		MenuDesc:<input id="add_menuDesc" type="text" name="menuDesc" /><br />
		ParentId:<input id="add_parentId" type="text" name="parentId" /><br />
		MenuType:<input id="add_menuType" type="text" name="menuType" /><br />
		MenuOwner:<input id="add_menuOwner" type="text" name="menuOwner" /><br />
		status:<input id="add_status" type="text" name="status" /><br /> <input
			type="button" value="添加" onclick="addMenu()" />
	</form>
</body>
</html>