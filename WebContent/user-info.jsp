<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Publish</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/home.css">
  <script src="https://cdn.bootcss.com/highcharts/6.0.3/highcharts.js"></script>
</head>
<body>
  
  <div>
    <nav class="main-menu">
      <div class="Logo"></div>
        <ul>
          <li>
            <a href="/MASystem/home">
              <i class="fa fa-area-chart fa-lg"></i>
              <span class="nav-text">作业概览</span>
            </a>
          </li>
          <li>
            <a href="/MASystem/ranking?hwId=${curHomework.id}">
              <i class="fa fa-pencil fa-lg"></i>
              <span class="nav-text">作业排名</span>
            </a>
          </li>
          <li>
            <a href="/MASystem/notification">
              <i class="fa fa-bell fa-lg"></i>
              <span class="nav-text">消息通知</span>
            </a>
          </li>
          <c:if test="${user.type == 1}">
            <li>
              <a href="/MASystem/publish">
                <i class="fa fa-edit fa-lg"></i>
                <span class="nav-text">发布作业</span>
              </a>
            </li>
          </c:if>
        </ul>
        <ul class="logout">
          <li>
            <a href="/MASystem/user-info">
              <i class="fa fa-user-circle fa-lg"></i>
              <span class="nav-text">你好, ${user.name}</span>
            </a>
          </li>  
          <li>
            <a href="/MASystem/signout">
              <i class="fa fa-sign-out fa-lg"></i>
              <span class="nav-text">LOGOUT</span>
            </a>
          </li>  
        </ul>
    </nav>
  </div>
  <div class="content-body">
    <div class="content-header">
      <div class="header-info">
        <div class="block"></div>
        <div id="breadcrumb-bar">
          <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">作业概况</li>
          </ol>
        </div>
        <div id="welcome">
          <h1>欢迎回来，${user.name}</h1>
        </div>
      </div>
    </div>
    <div class="dashboard">
      <div class="main-block">
        <div class="main-block-box">
          <div class="block-header">
            <span>个人资料</span>
          </div>
          <div class="edit-area">
            <form class="form-horizontal" action="/MASystem/user-info" method="post">
              <div class="form-group">
              <label class="col-sm-2 control-label">学号</label>
              <div class="col-sm-8">
                <p class="form-control-static">16340118</p>
              </div>
            </div>
            <div class="form-group">
              <label for="name" class="col-sm-2 control-label">姓名</label>
              <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="name" placeholder="姓名" required value="${user.name}">
              </div>
            </div>
            <div class="form-group">
              <label for="password" class="col-sm-2 control-label">密码</label>
              <div class="col-sm-8">
                <input type="password" class="form-control" id="password" name="password" placeholder="密码" required value="${user.password}">
              </div>
            </div>
            <div class="form-group">
              <label for="confirm-password" class="col-sm-2 control-label">确认密码</label>
              <div class="col-sm-8">
                <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="确认密码" required value="${user.password}">
              </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                  <button type="submit" class="btn btn-primary">修改</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>