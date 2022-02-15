<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기: 비밀번호 재설정</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/memberSearchPwdResult.css">
</head>

<body>

                      <!--/////비밀번호 변경시 유효성 검사를 해준다////// -->
	<script>
	function Validation(){
			 
			 	
		        var pRegExp = /^[a-zA-Z0-9!@#$%^&*()]{8,16}$/;//password 글자수 유효성 검사 정규식 
		   
     	        var objPwd = document.getElementById("userPwd"); //비밀번호
		        var objPwdCheck = document.getElementById("userPwdRe"); //비밀번호확인


		 
		        if(objPwd.value==''){ // 비밀번호 입력여부 검사
		            alert("Password를 입력해주세요.");
		            return false;
		        }
		        
		        if(!pRegExp.test(objPwd.value)){ //패스워드 유효성검사
		            alert("Password는 8~16자의 영문 대소문자와 숫자 특수문자로만 입력하여 주세요.");
		            return false;
		        }
		        
		        if(objPwdCheck.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
		            alert("비밀번호가 일치하지 않습니다. 다시 확인하여 입력해주세요.");
		            return false;
		        }

		        
		 }
		  
		 </script>

	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/member/goMemberSearchPwdResult.do">비밀번호 변경</a>
			</div>
			<div class="box-result">
				<p>비밀번호 재설정</p>
				<form action="/member/memberUpdatePassword.do" onsubmit="return Validation();" method="post">
				    <input type="text" class="input-style" id="userId" name="userId" value="${userId }" readonly/><br>					
					<input type="password" class="input-style" id="userPwd" name="userPwd" placeholder="새로운 비밀번호 입력"> <br>
					<input type="password" class="input-style" id="userPwdRe" name="userPwdRe" placeholder="비밀번호 확인"> <br>
					<input type="submit" class="btn-login" value="비밀번호 재설정">
				</form>
				
			</div>
			
		</div>
	</div>

</body>
</html>