if(document.querySelector("#download").href !== null){
	document.querySelector("#download").addEventListener("click", event => {
	    // 기본적으로 부여되는 클릭 이벤트 방지
	    event.preventDefault();
	    
	    let filename = event.target.getAttribute('href');
	    let sendData = `cmd=download&filename=${filename}`;
	    location.href = `BBSController?${sendData}`;
	});
}