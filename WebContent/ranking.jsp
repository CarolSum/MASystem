<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Ranking</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/home.css">
  <script type="text/javascript" src="js/detail.js"></script>
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
    <div class="dashboard row">
      <div class="detail-block col-md-6">
        <div class="block-wrapper">
          <div class="detail-ranking">
            <div class="block-header">
              <span>作业排名</span>
              <span class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  作业1 
                  <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                  <li><a href="#">作业1</a></li>
                  <li><a href="#">作业2</a></li>
                  <li><a href="#">作业3</a></li>
                  <li><a href="#">作业4</a></li>
                  <li><a href="#">作业5</a></li>
                  <li><a href="#">作业6</a></li>
                </ul>
              </span>
            </div>
            <!-- <div class="rank-data">
              <p class="substitution">这次作业还未批改完成，不能查看排名</p>
            </div> -->
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>排名</th>
                  <th>姓名</th>
                  <th>得分</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>孔令爽</td>
                  <td>100</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="detail-block col-md-6">
        <div class="block-wrapper">
          <div class="score-distribution">
            <div class="block-header">
              <span>成绩分布</span>
            </div>
            <!-- <div class="score-data">
              <p class="substitution">这次作业还未批改完成，不能查看分数分布图</p>
            </div> -->
            <div id="schart"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>