<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Check</title>
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
            <li>
            <a href="/MASystem/checkHomework?hwId=${curHomework.id}">
              <i class="fa fa-check-square-o fa-lg"></i>
              <span class="nav-text">批改作业</span>
            </a>
          </li>
          </c:if>
        </ul>
        <ul class="logout">
          <li>
            <div id="logo"></div>
            <div id="logo-name">My Achievement</div>
          </li>
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
        <div id="welcome">
          <h1>欢迎回来，${user.name}</h1>
        </div>
      </div>
    </div>
    <div class="module-title">
                    评价作业
      <span class="dropdown">
	       <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                                    学号 
	         <b class="caret"></b>
	       </a>
	       <ul class="dropdown-menu">
	         <c:forEach items="${allStudentId}" var="sid">
	           <li><a href="/MASystem/checkHomework?stId=${sid}">${sid} </a></li>
	         </c:forEach> 
	       </ul>
	     </span>
	   <span class="dropdown">
	       <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                                         作业${curHomework.id}
	         <b class="caret"></b>
	       </a>
	       <ul class="dropdown-menu">
	         <c:forEach items="${homeworks}" var="homework">
	           <li><a href="/MASystem/checkHomework?hwId=${homework.id}">作业${homework.id} </a></li>
	         </c:forEach> 
	       </ul>
	     </span>
    </div>
    <div class="dashboard row">
      
      <div class="checkHw-block">
        <div class="checkHw-block-box">
          
          <c:forEach items="${homeworkItems}" var="homeworkItem">
            <div class="row hwItem">
	            <form action="/MASystem/checkHomework?hiid=${homeworkItem.id}" method="post">
	              <div class="col-sm-2">
	                <div class="hwItemIntro">
	                  <div>姓名：${homeworkItem.username}</div>
	                  <div>学号：${homeworkItem.studentId}</div>
	                  <div><a href="/MASystem/download?hiid=${homeworkItem.id}" class="btn btn-primary">查看下载</a></div>
	                </div>
	              </div>
	              <div class="col-sm-8">
	                <div class="feedback-block">
	                  <textarea class="form-control" rows="3" id="feedback-content" name="feedback-content" placeholder="反馈信息" required>${homeworkItem.feedback}</textarea>
	                </div>
	                
	              </div>
	              <div class="col-sm-2">
	                <div class="score-group">
	                  <label for="score">分数: </label>
	                  <input type="text" id="score" class="form-control" name="score" placeholder="评分" required value="${homeworkItem.score}">
	                  <button type="submit" class="btn btn-primary score-submit">提交</button>
	                </div>
	              </div>
	            </form>
	          </div>
          </c:forEach> 
          
        </div>
      </div>

    </div>
  </div>
</body>
</html>