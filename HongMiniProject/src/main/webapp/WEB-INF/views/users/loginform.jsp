<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="command">
<form:errors element="div"/>
 <table border="1" cellpadding="0" cellspacing="0">
   <tr>
       <td >아이디</td>
       <td><input name="id" type="text" size="20"></td>
   </tr>
   <tr>
        <td >비밀번호</td>
        <td><input name="password" type="password" size="20"></td>
   </tr>
   <tr>
        <td colspan="2" align="center">
        <input type="submit" value="로그인">
        <a href="insertform">회원 가입</a>
 </table>
</form:form>
</body>
</html>