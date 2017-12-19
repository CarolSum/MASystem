<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/MASystem/login" method="post">
		<div>
			<label>学号</label>
			<input type="text" name="sid">
		</div>
		<div>
			<label>密码</label>
			<input type="password" name="password">
		</div>
		<input type="submit">
	</form>
</body>
</html>