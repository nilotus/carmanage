	function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return unescape(r[2]);
        return null; //返回参数值
    }
    var user_id = getUrlParam('user_id');
    console.log(user_id);
    $.ajax({
    	type:"post",
    	url:"/user/userInfo/" + user_id,
    	async:true,
    	dataType: 'json',
    	success:function(data){
    		console.log(data);
    		console.log(data.data.image);
    		var str1 = "<img src="+data.data.image+"/ width='300px',height='150px' id='yltx'>";
    		var str2 = "<p style='font-size: 15px;'>姓名：    "+data.data.userName+"</p>"   		
		         +"<br />"
		         + "<p style='font-size: 15px;'>手机号：    "+data.data.userId+"</p>"
		         +"<br />";
		    var str3 = "<img src="+data.data.image+" class='layui-nav-img'>"+data.data.userName;
          
		    if(data.data.userUid == 0){
		    	str2 = str2 + "<p style='font-size: 15px;'>身份：   用户</p>";
		    }else{
		    	str2 = str2 + "<p style='font-size: 15px;'>身份：   管理员</p>";
		    }
    		console.log(str3);
    		$('#tx').append(str1);
    		$('#info').append(str2);
    		$('#xx').append(str3);
    	}
    });
    
function edit(){
	layer.open({
			type: 1,
			title:"编辑信息",
			skin: 'layui-layer-rim', //加上边框
			area: ['350px', '360px'], //宽高
			content:$('#editinfo').html()//调到新增页面
			});
}

function editinfo(name,phone){	
	var data = {
				"userid":user_id,
		    "name":name,
		    "phone":phone,
			};
			ndata = JSON.stringify(data);
	$.ajax({
		type:"post",
		url:"/user/update",
		async:true,
		dataType: 'json',
		data:ndata,
		contentType: 'application/json',
		success: function(data){
			layer.msg(data.msg);
			user_id = phone;
		},
		error: function(){
			alert("failed!");
		}
		
	});
}
function check(id){
	$.ajax({
    	type:"post",
    	url:"/user/userInfo/" + id,
    	async:true,
    	dataType: 'json',
    	success:function(data){
    		layer.open({
				type: 1,
				title:"查看图片",
				skin: 'layui-layer-rim', //加上边框
				area: ['350px', '360px'], //宽高
				content:"<img src="+data.data.image+"/ width='300px',height='150px'"
			});
    		
    	}
    });
	
}

function edituid(id){
	$.ajax({
		type:"post",
		url:"/user/updateuid/"+id,
		async:true,
		dataType: 'json',
		success:function(data){
			layer.msg(data.msg);
		}
	});
}

function deleteUser(id){
	$.ajax({
		type:"post",
		url:"/user/delete/"+id,
		async:true,
		dataType: 'json',
		success:function(data){
			layer.msg(data.msg);
		}
	});
}
