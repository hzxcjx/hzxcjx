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
<link rel="stylesheet" href="css/home.css"/>
<link rel="stylesheet" href="css/home_guesthelp.css"/>
<link rel="stylesheet" href="css/home_erweima.css"/>
<link rel="stylesheet" href="css/home_state.css"/>
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
			<x:page controller="page" pagesize="5" total="${total}" curpage="${curpage}" where="${where}"></x:page>
		</div>
		<form id="guesthelp" action="visits" method="post">
			<div id="guesttop">
				<h3 style="color: white;">访客申请</h3>
				<img onclick="chacha()" style="width: 20px;height: 20px;" src="imgs/c.png"/>
			</div>
			<label><span class="mm">* <span class="sm">车牌号</span></span><input name="carID" required/></label>
			<label><span class="mm">* <span class="sm">手机号</span></span><input  name="phone"/ required></label>
			<label><span class="mm">* <span class="sm">开始时间</span></span><input type="datetime-local" name="start-time" required/></label>
			<label><span class="mm">* <span class="sm">结束时间</span></span><input type="datetime-local" name="end-time" required /></label>
			<label>来访事由<input name="why" /></label>
			<label>
				进出权限
				<select name="quanxian">
					<option value="国防教育">国防教育</option>
					<option value="有色金属院校">有色金属院校</option>
					<option value="食堂">食堂</option>
					<option value="仓库">仓库</option>
				</select>
			</label>
			<label><span style="line-height: 35px;">备注</span><textarea name="message" rows="4" cols="5" placeholder="请输入文本..."></textarea></label>
			<input id="guestbutton" type="submit" value="确定"/>
		</form>
		<!-- 二维码 -->
		<form id="guestma" action="" method="post">
			<div id="guesttop">
				<h3 style="color: white;">访客二维码</h3>
				<img onclick="cha()" style="width: 20px;height: 20px;" src="imgs/c.png"/>
			</div>
			<div class="qrcode" id="qrcode"></div>
			<input class="download" type="button" value="下载二维码">
		</form>
		<!-- 编辑状态 -->
		<form id="edit_Status" action="state"  method="get">
			<div id="guesttop">
				<h3 style="color: white;">编辑状态</h3>
				<img onclick="chachacha()" style="width: 20px;height: 20px;" src="imgs/c.png"/>
			</div>
			<label>状态
				<select name="zhuangtai">
					<option value="待审批">待审批</option>
					<option value="已通过">已通过</option>
					<option value="已拒绝">已拒绝</option>
				</select>
			</label>
			<label>
				进出权限
				<select name="quanxian">
					<option value="国防教育">国防教育</option>
					<option value="有色金属院校">有色金属院校</option>
					<option value="食堂">食堂</option>
					<option value="仓库">仓库</option>
				</select>
			</label>
			<label><span style="line-height: 35px;">备注</span><textarea name="message" rows="4" cols="5" placeholder="请输入文本..."></textarea></label>
			<input type="hidden" name="visit_id" id="visit_id_input"> <!-- 添加隐藏的 input 元素 -->
			<input id="OK" type="submit" value="确定" onclick="setVisitId()">
			<input id="cancel" type="button" value="取消">
			
		
		</form>
		
		
		<!-- 收集数据 -->
		<div id="hiddenData" style="display: none;">
		    <p id="pcarID">车牌号:${carID}</p>
		    <p id="pphone">手机号:${phone}</p>
		    <p id="pstart_time">开始时间:${start_time}</p>
		    <p id="pend_time">结束时间:${end_time}</p>
		    <p id="pwhy">来事访由:${why}</p>
		    <p id="pquanxian">权限:${quanxian}</p>
		    <p id="pmessage">备注:${message}</p>
		</div>
    </div>
	
</body>
<script src="js/home.js"></script>
<script src="js/qrcode.js"></script>
<script src="js/erweima.js"></script>
<script src="js/tuodong.js"></script>
<script src="js/state.js"></script>
<script>
	function jumpPage(url) {
		window.location.href = url;
	}
</script>
<script>
	/* $(".download").click(function() {
	    var canvas = document.getElementById("qrcode");
	    var dataURL = canvas.toDataURL("image/png"); // 将 canvas 转换为 Data URL
	
	    var downloadLink = document.createElement("a");
	    downloadLink.href = dataURL;
	    downloadLink.download = "qrcode.png"; // 下载文件的名称
	    downloadLink.click(); // 触发下载操作
	}); */
	//获取到登记id 然后进行判断是否删除
	function getVisitId(visitId) {
		var checkedCheckboxes = $(".row-checkbox:checked");
		if (checkedCheckboxes.length == 1) {
		    var confirmation = confirm("确定要删除吗？");
		    if (confirmation) {
		        var form = document.getElementById("form" + visitId);
		        var actionURL = "delete?visit_id=" + visitId; // 构建删除操作的 URL
		        form.action = actionURL; // 修改表单的 action 属性
		        form.submit(); // 提交表单，实现跳转到 DeleteServlet 进行处理
		    }
		} else {
		    alert("需要选择一个来进行删除");
		}
	}
	//判断时间是否选中
  	function validateForm() {
        var startTime = document.getElementsByName("start-time")[0].value;
        var endTime = document.getElementsByName("end-time")[0].value;
        
        if (startTime === "" || endTime === "") {
            alert("请选择开始时间和结束时间");
            return false;
        }
        
        return true;
    }
	

  
</script>  
</html>