$('#ech2').one('click',function(){
	    var myCharts1 = echarts.init(document.getElementById('ech21'))  
	    var myCharts2 = echarts.init(document.getElementById('ech22'));
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
	    option = {
		    	title: {
			        text: '运输消费统计',
			        subtext: '近一年',
			        left: 'center'
		    	},
		    	tooltip : {
		            trigger: 'axis',
		            formatter: "{a} <br/>【{b}】 : {c}"
		        },
			    xAxis: {
			    	name:"消费区间",
			        type: 'category',
			        data: ['0-200', '200-400', '400-600', '600-800', '800-1000', '1000-1200', '大于1200']
			    },
			    yAxis: {
			    	name:"运输次数",
			        type: 'value'
			    },
			    series: [{
			    	name:'运输次数',
			        data: [],
			        type: 'line',
			        smooth: true
			    }]
			};
        myCharts2.setOption(option);
	    myCharts1.showLoading();
	    myCharts2.showLoading();
	    var arr =[];
		var names =[];
		var cost = [];
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
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/route/cost',
	    	async:true,
	    	success:function(result){
	    		console.log(result);
	    		for (var i=0;i<result.data.length;i++){
	    			cost.push(result.data[i]);
	    		}	    		
	    		myCharts2.hideLoading();
	    		myCharts2.setOption({
	    			
	    			series:{
	    				data:cost
	    				//data:counts	    				
	    			}
	    		});
	    		
	    	},
	    	error:function(){
	    		alert("failed");
	    	}
	    	
	    });
  })