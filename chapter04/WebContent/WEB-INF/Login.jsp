<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎登陆</title>
</head>
<body>
<!--这个Login.jsp 和 Welcome.jsp本来是给DispatcherTest 配置的登录界面-->
<!--但是因为粗心建到了 WebContent 下边的 WEB-INF 里边-->
<!--直接造成 404 界面  -->
<!--就是找不到 页面 找不到Login.jsp和 Welcome.jsp -->
<!--正确用该 点击 WebContent 右键 直接建到WebContent 目录下-->


<!--这两个 Login.jsp和Welcome.jsp不删除！！！ 时刻警示！！！ -->
<!--反省 ！！！敲代码一定要注意细节  一定要细心！！！仔细！！！ -->

<form action="/chapter04/DispatcherTest" method="post">
用户名：<input  type="text" name="usn"/><br>
密码：<input type="password" name="psw">
<input type="submit" value="登录"/>

</form>
</body>
</html>