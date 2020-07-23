<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 공통 모듈-->
<%@ include file="/WEB-INF/common.jsp" %>
<title>비밀번호 찾기</title>
	<style>
		#findPWForm * {
			box-sizing: border-box;
		}
	   
		#findPWForm input {
			width: 100%;
		}
		#findPWForm button {
			width: 100%;
			padding: 7px;
			border: none;
			outline: none;
			background-color: green;
			color: white;
			font-family: "Montserrat", sans-serif;
			font-weight: 700px;
			letter-spacing: 1em;
			border-radius: 5px;
		}	
		 #findPWForm #findedPW {
		 	color: blue;   		 	
		 	font-weight: bold;
		 }
		
		 #findPWForm .errmsg {
		 	color: red;
		 	font-size: 0.7em;
		 	font-weight: bold;
		 }
	</style>
<script>
	window.addEventListener("load", init);
	function init() {
		const findPWBtn = document.getElementById("findPWBtn");
		const okBtn     = document.getElementById("okBtn");
		
		findPWBtn.addEventListener("click", findPW_f);
	  okBtn.addEventListener("click", okBtn_f);
	}

	 //확인 버튼 클릭 시 
   function okBtn_f(){
			event.preventDefault();
			const findedPWTag = document.getElementById('findedPW');
			//찾은 비밀번호가 발견되었으면
			if(findedPWTag.textContent){			
				
				
				//부모창 접근은 window.opener 속성 이용
				window.opener//
							.document.getElementById('pw').value = findedPWTag.textContent;
				window.close();
			}
   }

   //유효성 체크
   function chkValidation(){
				//아이디 체크
				if(!document.getElementById('id').value){
					document.getElementById('errmsg').textContent = '아이디 입력바랍니다.';
					document.getElementById('id').select();
					return false;
					}
	   
				//전화번호 체크
				if(!document.getElementById('tel').value){
					document.getElementById('errmsg').textContent = '전화번호 입력바랍니다.';
					document.getElementById('tel').select();
					return false;
					}
				
				//생년월일 체크 
				if(!document.getElementById('birth').value){
					document.getElementById('errmsg').textContent = '생년월일 입력바랍니다.';
					document.getElementById('birth').select();
					return false;
				}				
   }


	//비밀번호 찾기 버튼 클릭 시 
	function findPW_f(event) {
		event.preventDefault(); //<button>의 기본 이벤트 차단

		if(!chkValidation()) return;
		
		const idTag = document.getElementById("id");
		const telTag = document.getElementById("tel");
		const birthTag = document.getElementById("birth");
		
		const findedPWTag = document.getElementById("findedPW");
		const errmsgTag = document.getElementById("errmsg");

		//AJAX 사용
		//1)XMLHTTPRequest 객체 생성
		const xhttp = new XMLHttpRequest();

		//2)서버응답 처리
		xhttp.addEventListener("readystatechange", ajaxCall);
		function ajaxCall(event) {
			if (this.readyState == 4 && this.status == 200) {
				console.log(event.responseText);

				//json 포맷 문자열 => 자바스크립트 obj
				const jsonObj = JSON.parse(this.responseText);
				
				switch(jsonObj.rtcode){
				case "success" :
					findedPWTag.textContent = jsonObj.value;
					errmsgTag.textContent = '';
					break;
				case "fail" :
					errmsgTag.textContent = jsonObj.value;
					break;
				} 
			}
		}

		//3)요청 파라미터 만들기(json 포맷)
		const reqParam = {};
		reqParam.id = idTag.value;
		reqParam.tel = telTag.value;
		reqParam.birth = birthTag.value;

		const result = JSON.stringify(reqParam);

		//4)서비스 요청
		xhttp.open("POST",
				"http://localhost:9080/myweb/member/findPwByRestfull.do");
		xhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xhttp.send("result=" + result);
	}

</script>
</head>
<body>
	<form id="findPWForm">
		<div>
		 	<p>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" />
			</p>
		</div>
		<div>
			<p>
	      <label for="tel">전화번호</label>
				<input type="text" name="tel" id="tel" />
			</p>
		</div>
		<div>
			<p>
	   	 	<label for="birth">생년월일</label>
	     	<input type="date" name="birth" id="birth" />
     	</p>
		</div>
		<div>
			<span id="findedPW"></span>
		</div>
		<div>
			<span class="errmsg" id="errmsg">
		</div>
		<div>
			<p><button id="findPWBtn">비밀번호 찾기</button></p>
			<p><button id="okBtn">확인</button></p>
		</div>
	</form>
</body>
</html>