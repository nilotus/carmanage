$('#ech1').one('click',function(){
	    var myCharts1 = echarts.init(document.getElementById('pic1'));
	    var myCharts2 = echarts.init(document.getElementById('pic2'));
	    var myCharts4 = echarts.init(document.getElementById('pic4'));
	    var myCharts3 = echarts.init(document.getElementById('pic3'));
	    //var colors = [  '#8DB6CD','#D2691E', '#5F9EA0', '#A52A2A','#CDB7B5' ];
	    myCharts1.setOption({
	    	//color:colors,
	    	title: {
		        text: '车辆类型统计',
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
	                name:'近一年车辆类型统计',
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
		        text: '车辆状态统计',
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
	                name:'近一年车辆类型统计',
	                type:'pie',
	                clockwise:'true',
	                startAngle:'0',
	                radius : '60%',
	                center: ['50%', '50%'],
	                data:[]
	            }
	        ]
	    });
	    var option2 = {
            title: {
                text: '近7年车辆状态统计'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data: ['运行中', '报废', '维修', '丢失']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: ['2013年', '2014年', '2015年', '2016年', '2017年', '2018年', '2019年']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '运行中',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '报废',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '维修',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '丢失',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: []
                }
                
            ]
        };
        var option = {
            title: {
                text: '近7年车辆类型统计'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data: ['微型车', '小型车', '中型车', '大型车']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: ['2013年', '2014年', '2015年', '2016年', '2017年', '2018年', '2019年']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '微型车',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '小型车',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '中型车',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: []
                },
                {
                    name: '大型车',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: []
                }
                
            ]
        };
        myCharts4.setOption(option);
        myCharts3.setOption(option2);
	    myCharts1.showLoading();
	    myCharts2.showLoading();
	    myCharts4.showLoading();
	    myCharts3.showLoading();
	    var arr =[];
		var arr2 =[];
		var names =[];
		var names2 =[];
		var a=[];
        var b=[];
        var c=[];
        var d=[];
        var a2=[];
        var b2=[];
        var c2=[];
        var d2=[];
	    $.ajax({
	    	type:"post",
	    	dataType: 'json',
	    	url: '/car/year',
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
	    	url: '/car/year2',
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
	    $.ajax({
        	type:"post",
        	url:"/car/countkind",
        	async:true,
        	dataType: 'json',
			contentType: 'application/json',
			success:function(result){
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						a.push(result.data.kind1[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						b.push(result.data.kind2[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						c.push(result.data.kind3[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						d.push(result.data.kind4[i]);
				}
				myCharts4.hideLoading();
				myCharts4.setOption({
					series:[
					{
						name:'微型车',
						data:a
					},
					{
						name:'小型车',
						data:b
					},
					{
						name:'中型车',
						data:c
					},
					{
						name:'大型车',
						data:d
					}]
				});
			},
			error:function(){
				alert("failed");
			}
        	
        });
        $.ajax({
        	type:"post",
        	url:"/car/countstate",
        	async:true,
        	dataType: 'json',
			contentType: 'application/json',
			success:function(result){
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						a2.push(result.data.kind1[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						b2.push(result.data.kind2[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						c2.push(result.data.kind3[i]);
					}
				for (var i=result.data.kind1.length-1;i>=0;i--) {
						d2.push(result.data.kind4[i]);
				}
				myCharts3.hideLoading();
				myCharts3.setOption({
					series:[
					{
						name:'运行中',
						data:a2
					},
					{
						name:'报废',
						data:b2
					},
					{
						name:'维修',
						data:c2
					},
					{
						name:'丢失',
						data:d2
					}]
				});
			},
			error:function(){
				alert("failed");
			}
        	
        });
  })