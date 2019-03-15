/*实现div显示隐藏等效果--点谁谁显示
 */
function menuFunc(x){
	var i;
	var index;
	for(i=1;i<=18;i++){
		index = document.getElementById('content'+i);
		index.style.display = 'none';
	}
	document.getElementById('content'+x).style.display = 'block';
	
}

function logout(){
	$.cookie('the_cookie', null); 
	window.location.href = 'login.html';
}


