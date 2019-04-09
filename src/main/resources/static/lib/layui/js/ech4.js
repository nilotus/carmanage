$('#ech4').one('click',function(){
	    var myCharts1 = echarts.init(document.getElementById('ech41'));
	    var myCharts2 = echarts.init(document.getElementById('ech42'));	    
	    var colors = [  '#8DB6CD','#D2691E', '#5F9EA0', '#A52A2A','#CDB7B5' ];
	    myCharts1.setOption({
	    	color:colors,
	    	title: {
		        text: '司机性别统计',
		        subtext: '近一年',
		        left: 'center'
	    	},
	    	tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
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
	                name:'近一年司机性别统计',
	                type:'pie',
	                clockwise:'true',
	                startAngle:'0',
	                radius : '60%',
	                center: ['50%', '50%'],
	                data:[]
	            }
	        ]
	    });
	    myCharts2.setOption({
	    	//color:colors,
	    	title: {
		        text: '驾照类型统计',
		        subtext: '近一年',
		        left: 'center'
	    	},
	    	tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
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
	                name:'近一年驾照类型统计',
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
	    myCharts2.showLoading();
	    
	    var arr =[];
		var arr2 =[];
		var names =[];
		var names2 =[];
		
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/driver/sex',
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
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/driver/lk',
	    	async:true,
	    	success:function(result){
	    		console.log(result);
	    		for (var i=0;i<result.data.length;i++){
	    			names2.push(result.data[i].kind);
	    			arr2.push({
	    			 name:result.data[i].kind,
	    			 value:result.data[i].count
	    			});
	    		}	    		

				console.log(arr2);
	    		
	    		myCharts2.hideLoading();
	    		myCharts2.setOption({
	    			legend: {
			        	data:names2
		    		},
	    			series:{
	    				data:arr2
	    				//data:counts	    				
	    			}
	    		});
	    		
	    	},
	    	error:function(){
	    		alert("failed");
	    	}
	    	
	    });
	    
  })