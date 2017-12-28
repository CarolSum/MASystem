<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Home</title>
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
      <div class="chart-block">
        <div class="result-chart">
          <div class="chart-head">我的成绩</div>
          <div class="chart">
            <div id="score-chart"></div>
          </div>
        </div>
      </div>
      <div class="chart-block">
        <div class="ranking-chart">
          <div class="chart-head">我的排名</div>
          <div class="chart">
            <div id="rank-chart"></div>
          </div>
        </div>
      </div>
      <div id="homework-list-title">
        作业列表
      </div>
      <c:forEach items="${homeworks}" var="homework" varStatus="st">
          <div class="hw-item">
            <a href="/MASystem/homework-detail?id=${homework.id}">
	            <div class="hw-head">
	              作业 ${homework.id}
	            </div>
	            <div class="hw-detail">
	               ${homework.title}
	            </div>
	            <div class="hw-status">
	              <span class="start-time">开始时间： ${homework.startDate}</span>
	              <span class="end-time">截止时间：${homework.endDate}</span>
	            </div>
             </a>
		       </div>
      </c:forEach>

    </div>
  </div>
</body>
</html>