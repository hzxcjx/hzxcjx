<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title></title>
</head>
<link rel="stylesheet" href="css.css"/>
<link rel="stylesheet" href="homecss.css"/>
<style>
	
</style>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
	
</script>
<body>
    <div class="sidebar">
        <p >访客人员管理</p>
		<p onclick="showguesthelp()">访客申请</p>
    </div>

    <div id="mainContent">
        <div id="head">
			<button id="openButton" onclick="openSidebar()" ></button>
			<h2>访客管理</h2>
			<div id="selectedTextContainer"></div> <!-- 用于显示选择的字 -->
			<div id="tright">
				<h4>当前层级:停车场  管理员:${name}</h4>
			</div>
		</div>
		
		<div id="body">
			<form action="serch" method="post" onsubmit="return validateForm()">
				<div id="formt">
					<label>车牌号&nbsp;&nbsp;<input name="carpai" placeholder="请输入搜索内容"/></label>
					<label>&nbsp;&nbsp;来事访由&nbsp;&nbsp;<input name="reason_text" placeholder="请输入搜索内容"/></label>
					<label>&nbsp;&nbsp;状态 &nbsp;&nbsp;
						<select name="states">
							<option value="全部">全部</option>
							<option value="待审批">待审批</option>
							<option value="已通过">已通过</option>
							<option value="已拒绝">已拒绝</option>
						</select>
					</label>
				</div>
				<div id="formc">
					<label>
						预约时间&nbsp;&nbsp;
						&nbsp;&nbsp;<input type="datetime-local" name="start-time">
						&nbsp;&nbsp;到&nbsp;&nbsp;
						&nbsp;&nbsp;<input type="datetime-local" name="end-time">
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="sou" style="width: 60px;height: 30px;" type="submit" value="搜索"/>
				</div>
				
				
				<div id="formb">
					<a class="erweima" onclick="showma()" >访客二维码</a>
				</div>
				
			</form>
		</div>
		
		<div id="search">
			<table style="width:95%;border:1px black solid">
		    	<tr>
			    	<th><input type="checkbox"></th>
				    <th>车牌号</th>
				    <th>手机号</th>
				    <th>来访事由</th>
				    <th>申请时间</th>
				    <th>开始时间</th>
				    <th>结束时间</th>
				    <th>状态</th>
				    <th>备注</th>
				    <th>操作</th>
		    	</tr>
		    <c:forEach items="${list}" var="p">
		    	<form id="form${p.visit_id}" method="post">
			        <tr>
			          <td><input class="row-checkbox" type="checkbox"></td>
			          <td>${p.cars_number}</td>
			          <td>${p.visit_phone}</td>
			          <td>${p.reason_text}</td>
			          <td>${p.reg_time}</td>
			          <td>${p.start_time}</td>
			          <td>${p.end_time}</td>
			          <td><span data-state="${p.state}" class="state">${p.state}</span></td>
			          <td>${p.notes}</td>
			          <td>
			            <input class="delete-button" type="button" value="删除" name="delete" onclick="getVisitId(${p.visit_id})">
			            <input class="audit-button" type="button" value="审核" name="shenhe" onclick="ShowShenhe(${p.visit_id})">
			          </td> 
			        </tr>
		    	</form>
		    </c:forEach>
		  </table>
		</div>
    </div>
	
</body>



</html>