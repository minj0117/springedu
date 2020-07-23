/**
 * 
 */
 
	let init = () => {
		let tableTag = document.querySelector('table');		
		tableTag.addEventListener("click", function(e){
		  console.log(e.target);
			if(e.target.tagName != 'BUTTON') return;
			if(e.target.className == 'modiBtn'){
				console.log('수정 클릭됨!');		
				let id = e.target.getAttribute('data-modiBtnId');	
				//let id = e.target.parentElement.parentElement.firstElementChild.textContent;
				//let id = document.querySelector("[data-id='"+e.target.getAttribute('data-modiBtnId')+"']").getAttribute('data-id');
				//console.log("id="+id);
				window.location.href="http://localhost:9080/myweb/member/modifyForm.do?id=" + id; 	
			}else if(e.target.className == 'delBtn'){
				console.log('삭제 클릭됨!');			
				let id = e.target.getAttribute('data-delBtnId');	
				//let id = document.querySelector("[data-id='"+e.target.getAttribute('data-delBtnId')+"']").getAttribute('data-id');
				//let id = e.target.parentElement.parentElement.firstElementChild.textContent;
				window.location.href="http://localhost:9080/myweb/member/out.do?id=" + id; 
		 }			
		});
	}
	window.addEventListener("load", init);