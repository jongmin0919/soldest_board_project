function goTo_InsertPage(){
		location.href = "BBSController?cmd=insertBBSPage";
}

function view_all(){
		location.href = '/chapter17_bbs/BBSController?cmd=allList';
}

function insert(f){
	let regTitle = /^[0-9가-힣a-zA-Z]{1,50}$/; 
	let regWriter = /^[가-힣a-zA-Z]{1,12}$/;
	let regPassword = /^[0-9가-힣a-zA-Z]{1,20}$/;
 	let regContent= /^[0-9가-힣a-zA-Z]{1,300}$/;
	
	if (!regWriter.exec(f.writer.value)) {
	    alert("제대로 된 이름을 입력해 주세요.");
	    f.writer.value = "";
	    f.writer.focus();
	    return;
	}
	if (!regTitle.exec(f.title.value)) {
	    alert("제목의 범위를 지켜서 작성해주세요.");
	    f.title.value = "";
	    f.title.focus();
	    return;
	}
	if (!regPassword.exec(f.pw.value)) {
	    alert("패스워드의 범위를 지켜서 작성해주세요.");
	    f.pw.value = "";
	    f.pw.focus();
	    return;
	}
	if (!regContent.exec(f.content.value)) {
	    alert("내용의 범위를 지켜서 작성해주세요.");
	    f.content.value = "";
	    f.content.focus();
	    return;
	}
	f.action = "/chapter17_bbs/BBSController";
	f.submit();
}

function updateBBS(password) {
	console.log(password)
	let input_pw = document.getElementById("user_pw").value;
	if(input_pw !== password){
		alert("제대로 된 비밀번호를 입력해주세요.");
		return;
	}
	
    location.href = '/chapter17_bbs/BBSController?cmd=updatePage';
    
}

function update(f){
	if(f.pw.value == ""){
		alert("비밀번호를 입력하세요.");
		return;
	}
	
	if(f.title.value == ''){
		alert("제목을 입력하세요.");
		return;
	};
	
	if(f.content.value == ''){
		alert("내용을 입력하세요.");
		return;
	};
	
	f.action = 'BBSController';
	f.submit();
}

function removeBBS(idx , password) {
	let input_pw = document.getElementById("user_pw").value;
	if(input_pw !== password){
		alert("제대로 된 비밀번호를 입력해주세요.");
		return;
	}
	
    let result = confirm("정말 삭제하시겠습니까?");
    if (result) {
		alert("게시글이 삭제되었습니다.");
        location.href = '/chapter17_bbs/BBSController?cmd=delete&b_idx=' + idx;
    }
}




