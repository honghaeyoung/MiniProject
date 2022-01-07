<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#updateform").submit(function(){
		if(!$("#password").val()){
			alert("비밀번호를 입력해야 합니다.");
			return false;
		}
	});
})//ready
</script>
</head>
<body>
<h3>${user.id}님의 정보를 수정합니다.</h3>
<form action="update" method="post" id="updateform">
	<table>
		<tr><td>아이디</td><td>${user.id}
				</td></tr>
		<tr><td>비밀번호</td><td><input name="password" type="password" id="password"></td></tr>
		<tr><td>이름</td><td><input name="name" id="name" value="${user.name}"></td></tr>
		<tr><td>전화번호</td><td><input name="phone" id="phone" placeholder="000-0000-0000">
		<tr><td>이메일</td><td><input type="email" name="email" id="email" placeholder="xxxx@xxx형식으로입력해주세요"></td></tr>
		<tr><td>생년월일</td><td><input name="birth" value='<fmt:formatDate value="${user.birth}" pattern="yyyyMMdd"/>'></td></tr>
		<tr><td colspan="2"><input type="submit" value="변경"></td></tr>
		</table>
		</form>
</body>
</html>