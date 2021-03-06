/**
 * 
 */

const writeBtn = document.getElementById("writeBtn");
const cancelBtn = document.getElementById("cancelBtn");
const listBtn = document.getElementById("listBtn");
const writeFrm = document.getElementById("writeFrm");

writeBtn.addEventListener("click", writeBtn_F);
cancelBtn.addEventListener("click", cancelBtn_F);
listBtn.addEventListener("click", listBtn_F);

//등록
function writeBtn_F(e) {
	e.preventDefault();
  console.log("등록");
  
  //1)유효성 체크 
	if(!checkValidation()) {
	 return false;
	} 
	//2)서버 전송
  writeFrm.submit();
}

//취소
function cancelBtn_F(e) {
  console.log("취소");
  //입력한 내용 clear
  writeFrm.reset();
}

//목록
function listBtn_F(e) {
	e.preventDefault();
  console.log("목록");
  //목록 리스트로 이동
  const returnPage = e.target.getAttribute("data-returnPage");
  const url = `/portfolio/board/list/${returnPage}`;
  location.href = url;
}

//유효성 체크
function checkValidation(){

	//제목
	const btitleTag = document.getElementById('btitle');
	if(btitleTag.value.trim().length == 0){
		document.getElementById('btitle.error').textContent = "제목을 작성바랍니다.";
		btitleTag.select();
		return false;
	}
	document.getElementById('btitle.error').textContent = "";
	
	/*
	//작성자
	const bidTag = document.getElementById('bid');
	if(bidTag.value.trim().length == 0){
		document.getElementById('bid.error').textContent = "아이디를 작성바랍니다.";
		bidTag.select();
		return false;
	}
	document.getElementById('bid.error').textContent = "";
	
	//정규표현식
	let idExpReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-A]{2,3}$/i;
	if(!idExpReg.test(bidTag.value)){
		document.getElementById('bid.error').textContent = "이메일 형식에 맞지 않습니다. ex)aaa@bbb.com";
		bidTag.select();
		return false;
	}
	*/
	
	
	//내용
	const bcontentTag = document.getElementById('bcontent');
	if(bcontentTag.value.trim().length < 4) {
		document.getElementById('bcontent.error').textContent = "내용은 4자 이상 작성바랍니다.";
		bcontentTag.select();
		return false;
	}
	document.getElementById('bcontent.error').textContent = "";
	
	
	//파일사이즈
	const filesTag = document.getElementById('files');
	
	//첨부파일 합 구하기
	let sum = 0;
	Array.from(filesTag.files).forEach(file=>{sum += file.size});
/*	
	Array.from(files).forEach(
		function(file)=>{
			sum += file.size
		}
	);
*/		
		
	//첨부파일 합계가 10M 초과 여부 체크
	if(sum > 10485760) {
		document.getElementById('files.error').textContent = "10M이하로 첨부 가능합니다.";
		return false;
	}
	return true;
}















