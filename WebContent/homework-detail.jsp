<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>详情</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/home.css">
  <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/css/fileinput.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/fileinput.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/locales/zh.js"></script>
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
            <span>作业 ${curHomework.id}</span>
            <c:if test="${curHomeworkItem.status == 0}">
              <span class="user-hw-status">状态：未提交</span>
            </c:if>
            <c:if test="${curHomeworkItem.status == 1}">
              <span class="user-hw-status">状态：已提交 <button class="btn btn-primary" id="download-hw"><a href="/MASystem/download?hiid=${curHomeworkItem.id} ">查看下载</a></button></span>
            </c:if>
            <c:if test="${user.type == 1}">
              <span class="user-hw-status">
	              &nbsp<button class="btn btn-primary" id="modify-hw"><a href="/MASystem/homework-modify?hwId=${curHomework.id} ">修改</a></button>
	            </span>
            </c:if>
          </div>
          <div class="hw-content">
            <div class="row">
              <div class="col-md-2">Title: </div>
              <div class="col-md-10">${curHomework.title}</div>
            </div>
            <div class="row">
              <div class="col-md-2">Start Date: </div>
              <div class="col-md-10">${curHomework.startDate}</div>
            </div>
            <div class="row">
              <div class="col-md-2">End Date: </div>
              <div class="col-md-10">${curHomework.endDate}</div>
            </div>
            <div class="row">
              <div class="col-md-2">Content: </div>
              <div class="col-md-10"> ${curHomework.content}</div>
            </div>

            <!-- <form id="upload-hw" action="/MASystem/upload" method="post"  enctype="multipart/form-data">
              <div class="upload-head">提交作业</div>
              <div class="upload-group">
                <div class="file-loading">
                  <input id="file" name="file" multiple type="file" class="file" data-allowed-file-extensions='["rar", "txt"]' data-show-preview="false" data-el-error-container='#err' data-upload-url='/MASystem/upload' data-show-caption="true">
                </div>
                <div id="err"></div>
              </div>
            </form> -->
            <form method="post" action="/MASystem/upload" enctype="multipart/form-data">
                选择一个文件:
                <input type="file" name="uploadFile" />
                <br/><br/>
                <input type="submit" value="上传" />
            </form>
          </div>

          
        </div>  
      </div>
    </div>
  </div>
</body>
</html>