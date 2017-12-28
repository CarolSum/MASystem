<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Login</title>
  <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/jquery.transit.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6 col-center-block">
        <div class="content">
          <div class="signin-page">
            <div class="signin-head">
              <h3>Sign In</h3>
              <p>Please fill out this form to sign in!</p>
            </div>
            <hr>
            <div class="signin-form">
              <form action="/MASystem/login" method="post">
                <div class="form-group">
                  <label for="studentid">学号</label>  
                  <input type="text" id="studentid" name="studentid" class="form-control" placeholder="学号" required autofocus>  
                </div>  
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>  
                </div>
                <div class="checkbox">  
                  <label>  
                    <input type="checkbox" name="remember-me"> 记住我 
                  </label>  
                </div>  
                <div class="form-group">
                  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>  
                </div>
                <div id="button">
                 	 注册
                </div>
              </form>  
            </div>
          </div>
          <div class="signup-page">
              <div class="signin-head">
              <h3>Sign Up</h3>
              <p>Welcome to M.A. System! Please Sign up!</p>
            </div>
            <hr>
            <div class="signup-form">
              <form action="/MASystem/signup" method="post">
                <div class="form-group">
                  <label for="new-studentid">学号</label>  
                  <input type="text" id="new-studentid"  name="new-studentid" class="form-control" placeholder="学号" required autofocus>  
                </div>  
                <div class="form-group">
                  <label for="name">姓名</label>  
                  <input type="text" id="name" name="name" class="form-control" placeholder="姓名" required autofocus>  
                </div>  
                <div class="form-group">
                  <label for="new-password">密码</label>
                  <input type="password" id="new-password" name="new-password" class="form-control" placeholder="密码" required>  
                </div>
                <div class="form-group">
                  <label for="user-type">类型</label>
                  <select id="user-type" name="user-type">
                    <option>学生</option>
                    <option>老师</option>
                  </select>
                </div>
                <div class="form-group">
                  <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>  
                </div>
                <div id="back-to-login">
                	  返回登录
                </div>
              </form>  
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3"></div>
    </div>
  </div>
</body>
</html>