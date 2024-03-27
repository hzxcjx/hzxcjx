<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            // 显示用户列表
            $.ajax({
                url: "get_user_list.php",
                type: "GET",
                success: function(data) {
                    $("#userTable").html(data);
                }
            });

            // 删除用户
            $(document).on("click", ".deleteBtn", function() {
                var userId = $(this).attr("data-userid");
                var row = $(this).closest("tr");

                $.ajax({
                    url: "delete_user.php",
                    type: "POST",
                    data: { userId: userId },
                    success: function(data) {
                        if (data == "success") {
                            row.remove();
                        } else {
                            alert("删除用户失败");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
    <table id="userTable">
        
    </table>
</body>
</html>