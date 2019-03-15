$('#ech2').one('click',function(){
	    var myCharts1 = echarts.init(document.getElementById('ech21'))     
	    var colors = [  '#8DB6CD','#D2691E', '#5F9EA0', '#A52A2A','#CDB7B5' ];
	    myCharts1.setOption({
	    	color:colors,
	    	title: {
		        text: '运输时间统计',
		        subtext: '近一年',
		        left: 'center'
	    	},
	    	tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {d}%"
	        },
	        visualMap: {
	            show: false,
	            min: 500,
	            max: 600,
	            inRange: {
	                colorLightness: [0, 1]
	            }
	        },
	        legend: {
	        // orient: 'vertical',
	        // top: 'middle',
	        bottom: 10,
	        left: 'center',
	        data:[]
    		},
	    	series : [
	            {
	                name:'运输时间统计',
	                type:'pie',
	                clockwise:'true',
	                startAngle:'0',
	                radius : '60%',
	                center: ['50%', '50%'],
	                data:[]
	            }
	        ]
	    });
	    
        
	    myCharts1.showLoading();
	   
	    var arr =[];
		var names =[];
		
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/route/routetime',
	    	async:true,
	    	success:function(result){
	    		console.log(result);
	    		for (var i=0;i<result.data.length;i++){
	    			names.push(result.data[i].kind);
	    			arr.push({
	    			 name:result.data[i].kind,
	    			 value:result.data[i].count
	    			});
	    		}	    		

				console.log(arr);
	    		myCharts1.hideLoading();
	    		myCharts1.setOption({
	    			legend: {
			        	data:names
		    		},
	    			series:{
	    				data:arr
	    				//data:counts	    				
	    			}
	    		});
	    		
	    	},
	    	error:function(){
	    		alert("failed");
	    	}
	    	
	    });
	    
  })