function zdlj(begin,end){
	$('#zdlj').html("");
	$.ajax({
        		type:"post",
        		url:"/map/getmap",
        		async:true,
        		dataType: 'json',
				data:{
					begin: begin,
					end: end
				},
				success:function(data){
					var length = data.data.length;
					var str1 = "<p style='font-size: larger;'>从"+data.data[0]+"到"+data.data[length-1]+"的最短路径如下：</p>";
					var str2 = "<br />";
			    	var str3 = "<ul class='layui-timeline' style='margin-left:10%;'>";
			    	var str4 = "</ul>";
			    	var strs1="<li class='layui-timeline-item'>"
			    		+"<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>"
			    		+"<div class='layui-timeline-content layui-text'>"
			    		+"<h3 class='layui-timeline-title'>"+data.data[0]+"</h3>" + "<p> 从"+data.data[0]+"出发</p>";
			    	var strs3 = "<li class='layui-timeline-item'>"
			    		+"<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>"
			    		+"<div class='layui-timeline-content layui-text'>"
			    		+"<h3 class='layui-timeline-title'>"+data.data[length-1]+"</h3>"+"<p> 终点"+data.data[length-1]+"</p>";
			    	var str6 = "</div></li>";
			    	var str = str1 + str2 +str2 + str3 +strs1 + str6;
			    	for (var i=1;i<data.data.length-1;i++){
			    		var str5 = "<li class='layui-timeline-item'>"
			    		+"<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>"
			    		+"<div class='layui-timeline-content layui-text'>"
			    		+"<h3 class='layui-timeline-title'>"+data.data[i]+"</h3>";
			    		var str8 = "<p> 经过"+data.data[i]+"</p>";
			    		str = str + str5 + str8 + str6;
			    	}
			    	str = str + strs3 + str6 +str4;
					var str10 = "<p style='font-size: larger;' class='layui-icon'>&#xe66c;&#xe66c;&#xe66c;&nbsp;总路程约为 "+data.count+"km</p>"
					str = str +str10 ;
					$('#zdlj').append(str);
				},
				error: function(){
					alert("failed!");
				}
				
        	});
        	
}
