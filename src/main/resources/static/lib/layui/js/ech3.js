$('#ech3').one('click',function(){
	    var myCharts1 = echarts.init(document.getElementById('ech31'))  
	    var myCharts2 = echarts.init(document.getElementById('ech32')) 
	    var colors = [  '#8DB6CD','#D2691E', '#5F9EA0', '#A52A2A','#CDB7B5' ];
	    myCharts1.setOption({
	    	color:colors,
	    	title: {
		        text: '事件类型统计',
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
	                name:'近一年事件类型统计',
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
			    color: ['#3398DB'],
			    title: {
			        text: '车辆事件地点统计',
			        subtext: '地点前7',
			        left: 'center'
		    	},
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			        	name:"城市",
			            type : 'category',
			            data : [],
			            axisTick: {
			                alignWithLabel: true
			            },
			            axisLabel:{
			            	interval:0,
			            	rotate:40
			            }
			        }
			    ],
			    yAxis : [
			        {
			        	name:"数量",
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'事件数量',
			            type:'bar',
			            barWidth: '60%',
			            data:[10, 52, 200, 334, 390, 330, 220]
			        }
			    ]
			};
        myCharts2.setOption(option);
	    myCharts1.showLoading();
	    myCharts2.showLoading();
	    var arr =[];
		var names =[];
		var a=[];
		var b=[];
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/event/kind',
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
	    	url: '/event/place',
	    	async:true,
	    	success:function(result){
	    		for (var i=0;i<result.data.length;i++){
	    			a.push(result.data[i].kind);
	    			b.push(result.data[i].count);
	    		}	    		
	    		myCharts2.hideLoading();
	    		myCharts2.setOption({
	    			xAxis:{
							data:a
					},
	    			series:{
	    				data:b
	    				//data:counts	    				
	    			}
	    		});
	    		
	    	},
	    	error:function(){
	    		alert("failed");
	    	}
	    	
	    });
	    
  })