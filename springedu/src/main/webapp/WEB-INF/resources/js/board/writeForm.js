/**
 * 
 */
 
const writeBtn = document.getElementById("writeBtn");
const cancelBtn = document.getElementById("cancelBtn");
const listBtn = document.getElementById("listBtn");
const writeForm = document.getElementById("writeForm");

writeBtn.addEventListener("click", writeBtn_F);
cancelBtn.addEventListener("click", cancelBtn_F);
listBtn.addEventListener("click", listBtn_F);

//등록
function writeBtn_F(e) {
  console.log("등록");
  //1)유효성 체크

  //2)서버 전송
  writeForm.submit();
}

//취소
function cancelBtn_F(e) {
  console.log("취소");
  //입력한 내용 clear
  writeForm.reset();
}

//목록
function listBtn_F(e) {
  console.log("목록");
  //목록 리스트로 이동
  location.href = "list";
}