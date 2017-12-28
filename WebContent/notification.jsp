<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Notification</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/home.css">
  <script type="text/javascript" src="js/home.js"></script>
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
            <a href="/MASystem/ranking">
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
            <span>消息通知</span>
          </div>
          <c:forEach items="${messages}" var="message" varStatus="ms">
	          <div class="msg-item row">
		          <div class="msg-title-group col-md-9">
		            <div class="msg-from"> ${message.owner}</div>
		            <div class="msg-title"> ${message.msg}</div>
		          </div>
		          <div class="msg-time col-md-3">
		            ${message.date} 
		          </div>
		        </div>
		      </c:forEach>
          <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">David</div>
            <div class="msg-title">王青老师带你遨游web的知识海洋~美滋滋~</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">David</div>
            <div class="msg-title">Bob孔提交了作业三~</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">Bob</div>
            <div class="msg-title">我孔令爽今天要来打Web！</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">David</div>
            <div class="msg-title">你打不过的，放弃吧！</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">Bob</div>
            <div class="msg-title">哼！我倒是要看看，有什么能难倒我帅爽~</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">David</div>
            <div class="msg-title">呵...呵呵...呵呵呵呵呵呵......</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        <div class="msg-item row">
          <div class="msg-title-group col-md-9">
            <div class="msg-from">Bob</div>
            <div class="msg-title">妈呀老子不打了！</div>
          </div>
          <div class="msg-time col-md-3">
            2017.12.23 0:07 星期日 
          </div>
        </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>