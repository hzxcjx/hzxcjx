<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1> 
	<form action="../../zhu" method="post">
		用户名:<input name="name" id="name"><br>
		密码:<input type="password" name="pwd" id="pwd"><br>
		昵称:<input name="nickname" id="nickname"><br>
		联系电话:<input name="tel" id="tel"><br>
		<input type="submit" value="注册" onclick="return cli()">
	</form>
	<h6>已有账号？点击<a href="Loding.jsp">登陆</a></h6>
</body>
<script>
  function cli() {
    var name = document.querySelector("#name").value;
    var pwd = document.querySelector("#pwd").value;
    var nickname = document.querySelector("#nickname").value;
    var tel = document.querySelector("#tel").value;
  
    if (name == "" || pwd == "" || nickname == "" || tel == "") {
      alert("请填写完整信息");
      return false; 
    }
    else{
    	if(name.length<6 || pwd.length<6 || nickname.length<6){
    		alert("昵称、账户和密码不能小于6位");
    		return false; 
    	}
    	if(tel.length!=11){
    		alert("联系电话必须为11位");
    		return false; 
    	}
    }
    return true;
  	

   
  }
</script>
</html>