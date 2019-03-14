
	function getRoute(id){
		$.ajax({
		type:"post",
		url:"/station/route/"+id,
		async:true,
		dataType: 'json',
		success:function(data){
			var str2 = "";
			var start = "<li class='layui-timeline-item'>"
			    +"<i class='layui-icon layui-timeline-axis'></i>"
			    +"<div class='layui-timeline-content layui-text'>";
			var start2 = "<li class='layui-timeline-item'>"
			    +"<i class='layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis'></i>"
			    +"<div class='layui-timeline-content layui-text'>";
			var end = "</div></li>";
			var str1 = "<legend>"+data.data[0].carNumber+" "+data.data[0].name+"</legend>";
			var startplace= start+"<div class='layui-timeline-title'>"+ data.data[0].startTime + "  从" +data.data[0].startPlace+"出发</div>"+end;
			for(var i=0;i<data.data.length-1;i++){
				str2+=start+"<div class='layui-timeline-title'>"+ data.data[i].time + "  经过" +data.data[i].place+"</div>"+end;			    
			}
			var str3 = start2 +"<div class='layui-timeline-title'>"+ data.data[data.data.length-1].time + "  经过" +data.data[data.data.length-1].place+"</div>"+end;
			$('#stationinfo1').append(str1);
			$('#stationinfo2').append(startplace+str2+str3);
			var addst = "<button type='button' class='layui-btn'>添加停靠站</button>";
			$('#addst').append(addst);
		}
	});
	}
	
function deleteRoute(id){
	$.ajax({
		type:"post",
		url:"/",
		async:true
	});
}
