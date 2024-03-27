<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用药记录</title>
</head>
<body>
    <h1>用药记录</h1>
    
    <form action="${pageContext.request.contextPath}/medication" method="post">
        <label for="medicationName">药物名称：</label>
        <input type="text" name="medicationName" required><br>
        
        <label for="dosage">剂量：</label>
        <input type="number" name="dosage" required><br>
        
        <label for="time">用药时间：</label>
        <input type="text" name="time" required><br>




        
        <button type="submit">添加用药记录</button>
    </form>
    
    <h2>用药记录列表</h2>
    <table>
        <tr>
            <th>药物名称</th>
            <th>剂量</th>
            <th>用药时间</th>
        </tr>
        <c:forEach items="${medications}" var="medication">
            <tr>
                <td>${medication.medicationName}</td>
                <td>${medication.dosage}</td>
                <td>${medication.time}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
