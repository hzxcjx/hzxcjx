<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>访客</title>
  <style>
    /* 在这里添加你的 CSS 样式 */
    body {
      font-family: Arial, sans-serif;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid #dddddd;
      padding: 8px;
      text-align: center;
    }
    th {
      background-color: #f2f2f2;
    }
    button {
      padding: 5px 10px;
      margin-right: 5px;
    }
  </style>
</head>  
<body>
  <h1>访客管理系统</h1>
  <input type="text" id="search" placeholder="按车牌搜索访客" oninput="searchVisitors(this.value)">
  <button onclick="openAddVisitorForm()">添加访客</button>

  <table id="visitor-table">
    <thead>
      <tr>
        <th>车牌号</th>
        <th>姓名</th>
        <th>手机号</th>
        <th>申请时间</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>备注</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <!-- 这里将通过 JavaScript 动态插入访客信息 -->
    </tbody>
  </table>

  <script>
    // 从后端获取访客信息的示例
    let visitors = [
      { 
        licensePlate: "粤A12345", 
        name: "张三",
        phoneNumber: "123456789",
        applicationTime: "2024-02-25 10:00:00",
        startTime: "2024-02-25 12:00:00",
        endTime: "2024-02-25 18:00:00",
        note: "无",
        status: "待审核"
      },
      { 
        licensePlate: "粤B67890", 
        name: "李四",
        phoneNumber: "987654321",
        applicationTime: "2024-02-25 11:00:00",
        startTime: "2024-02-25 13:00:00",
        endTime: "2024-02-25 19:00:00",
        note: "无",
        status: "已通过"
      }
    ];

    function renderTable(visitors) {
      const tableBody = document.querySelector("#visitor-table tbody");
      tableBody.innerHTML = "";
      
      visitors.forEach(function(visitor) {
        const row = document.createElement("tr");
        
        const keys = ['licensePlate', 'name', 'phoneNumber',
          'applicationTime', 'startTime', 'endTime',
          'note', 'status'];
        
        keys.forEach(function(key) {
          const cell = document.createElement("td");
          cell.textContent = visitor[key];
          row.appendChild(cell);
        });

        const actionsCell = document.createElement("td");

        if (visitor.status === '待审核') {
          const reviewButton = document.createElement("button");
          reviewButton.textContent = "审核";
          reviewButton.onclick = function() {
            reviewVisitor(visitor.licensePlate);
          };
          actionsCell.appendChild(reviewButton);
        }
        
        row.appendChild(actionsCell);
        
        tableBody.appendChild(row);
      });
    }

    function searchVisitors(keyword) {
      const filteredVisitors = visitors.filter(function(visitor) {
        return visitor.licensePlate.includes(keyword);
      });
      renderTable(filteredVisitors);
    }

    function reviewVisitor(licensePlate) {
      console.log('审核访客', licensePlate);

      const visitor = visitors.find(function(visitor) {
        return visitor.licensePlate === licensePlate;
      });
      if (visitor) {
        visitor.status = "已通过";
        renderTable(visitors);
      }
    }

    function openAddVisitorForm() {
      const form = document.createElement('form');
  
      form.innerHTML = `
        <label for="licensePlate">车牌号:</label>
        <input type="text" id="licensePlate"><br>
        <label for="name">姓名:</label>
        <input type="text" id="name"><br>
        <label for="phoneNumber">手机号:</label>
        <input type="text" id="phoneNumber"><br>
        <label for="startTime">开始时间:</label>
        <input type="datetime-local" id="startTime"><br>
        <label for="endTime">结束时间:</label>
        <input type="datetime-local" id="endTime"><br>
        <label for="note">备注:</label>
        <input type="text" id="note"><br>
        <input type="submit" value="提交">
      `;
  
      form.onsubmit = function(event) {
        event.preventDefault();
        const newVisitor = {
          licensePlate: form.querySelector('#licensePlate').value,
          name: form.querySelector('#name').value,
          phoneNumber: form.querySelector('#phoneNumber').value,
          startTime: form.querySelector('#startTime').value,
          endTime: form.querySelector('#endTime').value,
          note: form.querySelector('#note').value,
          status: "待审核"
        };
        
        visitors.push(newVisitor);
        renderTable(visitors);
        form.parentNode.removeChild(form);
      };
  
      document.body.appendChild(form);
    }

    // 初始化页面
    renderTable(visitors);
  </script>
</body>
</html>