<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinFrm</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>회원가입 - email 중복 체크 ajax</h1>
	<hr>
	<a href="/">홈으로</a>
	<br>
	<br>
	<form action="/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
			이메일 : <input type="text" name="email" required><span id="chkEmail"></span><br>
			비밀번호 : <input type="password" name="userPw" required><br>
			이름 : <input type="text" name="userName" required><br>
			나이 : <input type="text" name="age" required><input type="submit" value="가입">
		</fieldset>
	</form>
	
	<script>
		$("[name=email]").on("keyup", function(){
			var email = $(this).val(); // email 입력값 확인
			
			$.ajax({
				url : "/checkEmail.do",
				data : {email : email},
				type : "get",
				success : function(data) {
					if (data == 1) { // 이메일 사용 가능
						$("#chkEmail").html("해당 이메일은 사용 가능합니다.");
						$("#chkEmail").css("color", "blue");
					} else {
						$("#chkEmail").html("중복된 이메일 입니다."); // email 중복
						$("#chkEmail").css("color", "red");
					}
				}
			});
		});
	</script>
</body>
</html>