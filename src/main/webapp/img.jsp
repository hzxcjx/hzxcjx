<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.util.Random"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		//生成一串4位的随机数字
		private String rndString(){
			Random rnd = new Random();
			String x = "";
			for(int i = 0; i < 4; i ++){
				x += rnd.nextInt(10);//生成0-9之间数字
			}
			return x;
		}
	%>
	

	<%
		//设置响应类型为图片
		response.setContentType("image/png");
		//创建一张空白图片
		BufferedImage bi = new BufferedImage(210, 210, 
				BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = bi.getGraphics();
		//设置颜色 
		g.setColor(Color.yellow);
		//设置字体
		g.setFont(new Font("黑体", Font.BOLD, 30));
		//画圆
		g.drawOval(5, 5, 200, 200);//画实心：fillXXX()
		//画文字
		g.drawString(rndString(), 10, 100);
		//通过输出流输出到浏览器
		ImageIO.write(bi, "png", response.getOutputStream());
		//释放资源 
		g.dispose();
		out.clear();
		out = pageContext.pushBody();//防止jsp出错
	%>
</body>
</html>