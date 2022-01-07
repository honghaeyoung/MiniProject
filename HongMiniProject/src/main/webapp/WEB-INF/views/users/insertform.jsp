<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
<style>
table {
    margin-left:auto; 
    margin-right:auto;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(function(){
    	$("#id_check").click(function(){
			let id = $("#id").val();
			$.post("/idchk", {"id" : id},function(data){
				$("#id_msg").empty();
				if(eval(data)){
					alert("사용 가능한 아이디");
					$("#id_msg").append("<input type='hidden' id='ck_id' value='1'>")
				}else{
					alert("중복된 아이디입니다.");
				}
			})
		});//아이디 중복 확인
		$("#insertform").submit(function(){
			if($("#id_check").val() != 1){
				$("#id_msg").html("아이디 중복 체크 하셔야 합니다")
				return false;
			}//id중복 확인 안하고 가입 누를시 실행
    })//레디

   

      
   
</script>
</head>
<body>
<form method="post" id="insertform">
	<table>
		<tr><td>아이디</td><td><input name="id" id="id"><input type="button" id="id_check" value="중복 확인" >
		<div id="id_msg"></div></td></tr>
		<tr><td>비밀번호</td><td><input name="password" type="password" id="password">
		<div id="pw_msg"></div></td></tr>
		<tr><td>이름</td><td><input name="name" id="name">
		<div id="name_msg"></div></td></tr>
		<tr><td>전화번호</td><td><input name="phone" id="phone" placeholder="000-0000-0000">
		<tr><td>이메일</td><td><input type="email" name="email" id="email" placeholder="이메일형식으로 입력해주세요"></td></tr>
		<tr><td>생년월일</td><td><input name="birth" id="birth" placeholder="ex : 19990909">
		<div id="birth_msg"></div></td></tr> 
		<tr><td><input type="submit" value="가입"></td></tr>
    </table>
</form>

</body>
</html>