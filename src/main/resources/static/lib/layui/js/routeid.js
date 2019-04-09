var routeid;
function getRoute(id){
		routeid = id;
		$.ajax({
		type:"post",
		url:"/station/route/"+id,
		async:true,
		dataType: 'json',
		success:function(data){
			var addst = "<button type='button' class='layui-btn' style='margin-left: 8%;' onclick='funcadd()'>添加停靠站</button><button type='button' class='layui-btn layui-btn-normal' style='margin-left: 10%;' onclick='deletediv(this)'>取消操作</button>";
			var strsd = "<div style='width: 25%;float: left;margin-left: 5%;'><div class='layui-card' style = 'vertical-align:middle;text-align: center;'><div>";
			var strsd2 = "<fieldset class='layui-elem-field layui-field-title' style='margin-top: 30px;'>";
			var strsd3 = "</fieldset><ul class='layui-timeline'>";	  
			var strsd4 = "</ul></div></div></div> ";
			var strsd5 = "</div></div></div>";
			var str2 = "";
			var start = "<li class='layui-timeline-item'>"
				    +"<i class='layui-icon layui-timeline-axis'></i>"
				    +"<div class='layui-timeline-content layui-text'>";
			var start2 = "<li class='layui-timeline-item'>"
				    +"<i class='layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis'></i>"
				    +"<div class='layui-timeline-content layui-text'>";
			var end = "</div></li>";
			if(data.data.length>0){
				var str1 = "<legend>"+data.data[0].carNumber+" "+data.data[0].name+"</legend>";
				var startplace= start+"<div class='layui-timeline-title'>"+ data.data[0].startTime + "&nbsp; 从" +data.data[0].startPlace+"出发</div>"+end;
				for(var i=0;i<data.data.length-1;i++){
					str2+=start+"<div class='layui-timeline-title'>"+ data.data[i].time + "&nbsp; 经过" +data.data[i].place+"</div>"+end;			    
				}
				var str3 = start2 +"<div class='layui-timeline-title'>"+ data.data[data.data.length-1].time + "&nbsp; 经过" +data.data[data.data.length-1].place+"</div>"+end;
				var strend = strsd+strsd2+str1+strsd3+startplace+str2+str3+addst+strsd4;
				$('#content6').append(strend);
			}else{
				var tss = "<br />";
				var ts = "<p style='text-align: center;'>无路线信息</p>";
				$('#content6').append(strsd+tss+tss+ts+tss+addst+strsd5);
			}	
			
			
			
		},
      	error: function () {
        	alert("网络异常");
      	}
	});
	}
	
function deleteRoute(id){
	$.ajax({
		type:"post",
		url:"/route/state/"+id,
		async:true,
		dataType: 'json',
		success:function(data){
			layer.msg(data.msg);
		}
	});
}



function deletediv(o){
	var $parent = $(o).parent().parent();
	$parent.remove();
}

function addstation(id,place,time,cost){
		var data = {
				"routeld":id,
		    "place":place,
		    "time":time,
		    "cost":cost
			};
			ndata = JSON.stringify(data);
			console.log(ndata);
		$.ajax({
			type:"post",
			url:"/station/insert",
			async:true,
			dataType: 'json',
      contentType: 'application/json',
      data: ndata,
      success: function (data) {
        console.log(data);
	      if (data.code == 1) {
	        layer.msg(data.msg);
	      } else {
	        layer.msg(data.msg);
	      }
      },
      error: function () {
        alert("已存在");
      }
		});
	}
function funcadd(){
  	layer.open({
			type: 1,
			title:"添加站点",
			skin: 'layui-layer-rim', //加上边框
			area: ['380px', '360px'], //宽高
			content:$('#editst').html()//调到新增页面
			});
  }
function getRoute2(id){
    routeid = id;
    $.ajax({
        type:"post",
        url:"/station/route/"+id,
        async:true,
        dataType: 'json',
        success:function(data){
        	var strend= "";
        	if(data.data.length>0){
        		console.log(data);
	            var strsd = "<div style='float: left;margin-left: 5%;'><div class='layui-card' style = 'vertical-align:middle;text-align: center;'><div>";
	            var strsd2 = "<fieldset class='layui-elem-field layui-field-title' style='margin-top: 30px;'>";
	            var strsd3 = "</fieldset><ul class='layui-timeline'>";
	            var strsd4 = "</ul></div></div></div> ";
	            var str2 = "";
	            var start = "<li class='layui-timeline-item'>"
	                +"<i class='layui-icon layui-timeline-axis'></i>"
	                +"<div class='layui-timeline-content layui-text'>";
	            var end = "</div></li>";
	            var str1 = "<legend>"+data.data[0].carNumber+" "+data.data[0].name+"</legend>";
	            var startplace= start+"<div class='layui-timeline-title'>"+ data.data[0].startTime + "&nbsp; 从" +data.data[0].startPlace+"出发</div>"+end;
	            for(var i=0;i<data.data.length-1;i++){
	                str2+=start+"<div class='layui-timeline-title'>"+ data.data[i].time + "&nbsp; 经过" +data.data[i].place+"</div>"+end;
	            }
	            var str3 = start +"<div class='layui-timeline-title'>"+ data.data[data.data.length-1].time + "&nbsp; 结束于" +data.data[data.data.length-1].place+"</div>"+end;
	            strend = strsd+strsd2+str1+strsd3+startplace+str2+str3+strsd4;
	            if(data.count == 2){
	            	str3 = start +"<div class='layui-timeline-title'>"+ data.data[data.data.length-1].time + "&nbsp; 经过" +data.data[data.data.length-1].place+"</div>"+end;
	            	var str4 = start +"<div class='layui-timeline-title'>"+ data.data[0].endTime + "&nbsp; 到达" +data.data[0].destination+"</div>"+end;
	            	strend = strsd+strsd2+str1+strsd3+startplace+str2+str3+str4+strsd4;
	            }
        	}else{
        		strend = "<br /><br /><br /><br /><p style='text-align: center;'>无路线信息</p>";
        	}
        	
            layer.open({
				type: 1,
				title:"运输路线",
				skin: 'layui-layer-rim', //加上边框
				area: ['360px', '440px'], //宽高
				content:strend//调到新增页面
			});
        },
      	error: function () {
        	alert("网络异常");
      	}
    });
}