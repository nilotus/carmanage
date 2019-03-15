layui.use(['element', 'laydate', 'form', 'table', 'jquery'], function () {
        var element = layui.element;
        var laydate = layui.laydate;
        var table = layui.table;
        var $ = layui.jquery;
        var form = layui.form;
        //渲染laydate
        laydate.render({
            elem: '#nt',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#st',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#et',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#rst2',
            theme: 'molv'
            ,type: 'datetime'
        });
        
        laydate.render({
            elem: '#ret2',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#rst',
            theme: 'molv'
            ,type: 'datetime'
        });
        
        laydate.render({
            elem: '#ret',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#est2',
            theme: 'molv'
            ,type: 'datetime'
        });
        
        laydate.render({
            elem: '#eet2',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#est',
            theme: 'molv'
            ,type: 'datetime'
        });
        
        laydate.render({
            elem: '#eet',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#eventime',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#dbd',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e21',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e22',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e23',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e81',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e82',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e83',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e84',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e85',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e86',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e87',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e88',
            theme: 'molv'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#e89',
            theme: 'molv'
            ,type: 'datetime'
        });
        form.on('submit(demo1)', function(data){
  		addstation(routeid,data.field.place,data.field.time);
  		return false;
    	})
        //渲染表格 car
        var tableIns = table.render({
            elem: '#demo',
            height: 312,
            url: '/car/selectAll', //数据接口
            method: 'post',
            page: true, //开启分页
            limit: 10,
            cols: [[ //表头
                {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
                , {field: 'carKind', title: '车辆类型', width: '10%', align:'center'}
                , {field: 'carSeat', title: '车载座', width: '6%', sort: true, align:'center'}
                , {field: 'carLoad', title: '车载重', width: '6%', align:'center'}
                , {field: 'carFactory', title: '车厂', width: '15%', align:'center'}
                , {field: 'carColor', title: '车颜色', width:'9%',align:'center' }
                , {field: 'carState', title: '车辆状态', width: '9%', align:'center'}
                , {field: 'carOwner', title: '车主', width: '10%', align:'center'}
                , {field: 'carON', title: '车主联系方式', width: '10%', align:'center'}
                , {field: 'date', title: '日期', width: '15%', align:'center'}
            ]]
        });
        var tableIns5 = table.render({
            elem: '#demo2',
            height: 312,
            url: '/car/selectAll', //数据接口
            method: 'post',
            page: true, //开启分页
            limit: 10,
            cols: [[ //表头
                {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
                , {field: 'carKind', title: '车辆类型', width: '10%', align:'center'}
                , {field: 'carSeat', title: '车载座', width: '6%', sort: true, align:'center'}
                , {field: 'carLoad', title: '车载重', width: '6%', align:'center'}
                , {field: 'carFactory', title: '车厂', width: '15%', align:'center'}
                , {field: 'carColor', title: '车颜色', width:'9%',align:'center' }
                , {field: 'carState', title: '车辆状态', width: '9%', align:'center'}
                , {field: 'carOwner', title: '车主', width: '10%', align:'center'}
                , {field: 'carON', title: '车主联系方式', width: '10%', align:'center'}
                , {field: 'date', title: '日期', width: '15%', align:'center'}
            ]]
        });
        //提交表单--插入数据 car
        form.on('submit(sub)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.number,
            	"carKind": data1.field.kind,
            	"carSeat": data1.field.seat,
            	"carLoad": data1.field.heavy,
            	"carFactory": data1.field.factory,
            	"carColor": data1.field.color,
            	"carState": data1.field.state,
            	"carOwner": data1.field.name,
            	"carON": data1.field.phone,
            	"date": data1.field.nt
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/car/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        //提交表单--重载表格 car
        form.on('submit(select)',function(data2){
        	var adata = {
        		"carNumber":data2.field.number2,
        		"carKind": data2.field.kind2,
				"st":data2.field.st,
				"et":data2.field.et
          };
        	var ndata = JSON.stringify(adata);
        	tableIns.reload({
        		url: '/car/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.number2,
	        		"carKind": data2.field.kind2,
					"st":data2.field.st,
					"et":data2.field.et
        		}
        	});
        	return false;
        });
        form.on('submit(select2)',function(data2){
        	var adata = {
        		"carNumber":data2.field.number2,
        		"carKind": data2.field.kind2,
				"st":data2.field.st,
				"et":data2.field.et
          };
        	var ndata = JSON.stringify(adata);
        	tableIns5.reload({
        		url: '/car/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.number2,
	        		"carKind": data2.field.kind2,
					"st":data2.field.st,
					"et":data2.field.et
        		}
        	});
        	return false;
        });
	    //渲染表格 router
	    var tableIns2 = table.render({
	        elem: '#router',
	        height: 312,
	        url: '/route/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '12%', align:'center'}
	            , {field: 'startTime', title: '出发时间', width: '14%', align:'center'}
	            , {field: 'startPlace', title: '出发地点', width: '15%', sort: true, align:'center'}    
	            , {field: 'endTime', title: '到达时间', width: '14%', align:'center'}
	            , {field: 'destination', title: '目的地', width:'15%',align:'center' }
	            , {field: 'state', title: '运行状态', width: '10%', align:'center'}
	            , {field: 'cost', title: '花销', width: '10%', align:'center'}
	        ]]
	    });
	    var tableStation = table.render({
	        elem: '#station',
	        height: 312,
	        url: '/route/select1', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'routeId', title: 'routeID', width: '10%', sort: true, align:'center'}
	            , {field: 'carNumber', title: '车牌号', width: '20%', sort: true, align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '20%', align:'center'}
	            , {field: 'startTime', title: '出发时间', width: '25%', align:'center'}
	            , {field: 'startPlace', title: '出发地点', width: '25%', align:'center'}
	            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
	        ]]
	    });
	    //监听行工具事件
		  table.on('tool(station)', function(obj){
		    var data = obj.data;
		    //console.log(obj)
		    if(obj.event === 'del'){
		    	layer.confirm('确定要取消运输么？', {
                btn: ['确定','取消'], //按钮
	            }, function(){
	                deleteRoute(data.routeId);
	            });	      
		    } else if(obj.event === 'edit'){
		    	getRoute(data.routeId);
		    }
		  });
	    //提交表单--插入数据 router
	    form.on('submit(subr1)', function (data1) {
	    	console.log(data1);
            var adata = {
            	"carNumber": data1.field.rnumber,
            	"driverIN": data1.field.rIN,
            	"startTime": data1.field.rst,
            	"startPlace": data1.field.rsp,
            	"endTime": data1.field.ret,
            	"destination": data1.field.rep,
            	"state": data1.field.rstate,
            	"cost": data1.field.rcost
            };
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/route/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            return false;
        });
        //提交表单--重载表格 router
        form.on('submit(subr2)',function(data2){
        	console.log(data2);
        	var adata = {
        		"carNumber":data2.field.rNumber2,
        		"driverIN": data2.field.rIN2,
				"startTime":data2.field.rst2,
				"endTime":data2.field.ret2,
				"state":data2.field.rstate2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns2.reload({
        		url: '/route/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.rNumber2,
	        		"driverIN": data2.field.rIN2,
					"startTime":data2.field.rst2,
					"endTime":data2.field.ret2,
					"state":data2.field.rstate2
        		}
        	});
        	return false;
        });
	    //渲染表格 event
	    var tableIns3 = table.render({
	        elem: '#event',
	        height: 312,
	        url: '/event/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
	            , {field: 'eventTime', title: '事件时间', width: '15%', align:'center'}
	            , {field: 'eventPlace', title: '事件地点', width: '15%', sort: true, align:'center'}
	            , {field: 'eventKind', title: '事件类型', width: '10%', align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '15%', align:'center'}
	            , {field: 'eventReason', title: '事件原因', width:'15%',align:'center' }
	            , {field: 'eventInfo', title: '事件信息', width: '20%', align:'center'}
	        ]]
	    });
	    var tableIns6 = table.render({
	        elem: '#event2',
	        height: 312,
	        url: '/event/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
	            , {field: 'eventTime', title: '事件时间', width: '15%', align:'center'}
	            , {field: 'eventPlace', title: '事件地点', width: '15%', sort: true, align:'center'}
	            , {field: 'eventKind', title: '事件类型', width: '10%', align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '15%', align:'center'}
	            , {field: 'eventReason', title: '事件原因', width:'15%',align:'center' }
	            , {field: 'eventInfo', title: '事件信息', width: '20%', align:'center'}
	        ]]
	    });
	    var tableIns7 = table.render({
	        elem: '#event3',
	        height: 312,
	        url: '/event/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
	            , {field: 'eventTime', title: '事件时间', width: '15%', align:'center'}
	            , {field: 'eventPlace', title: '事件地点', width: '15%', sort: true, align:'center'}
	            , {field: 'eventKind', title: '事件类型', width: '10%', align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '15%', align:'center'}
	            , {field: 'eventReason', title: '事件原因', width:'15%',align:'center' }
	            , {field: 'eventInfo', title: '事件信息', width: '20%', align:'center'}
	        ]]
	    });
	    var tableIns8 = table.render({
	        elem: '#event4',
	        height: 312,
	        url: '/event/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'carNumber', title: '车牌号', width: '10%', sort: true, align:'center'}
	            , {field: 'eventTime', title: '事件时间', width: '15%', align:'center'}
	            , {field: 'eventPlace', title: '事件地点', width: '15%', sort: true, align:'center'}
	            , {field: 'eventKind', title: '事件类型', width: '10%', align:'center'}
	            , {field: 'driverIN', title: '驾驶员编号', width: '15%', align:'center'}
	            , {field: 'eventReason', title: '事件原因', width:'15%',align:'center' }
	            , {field: 'eventInfo', title: '事件信息', width: '20%', align:'center'}
	        ]]
	    });
	    //提交表单--插入数据 event
        form.on('submit(sube)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.eNumber,
            	"eventTime": data1.field.eventime,
            	"eventPlace": data1.field.eplace,
            	"eventKind": data1.field.ekind,
            	"driverIN": data1.field.eIN,
            	"eventReason": data1.field.ereason,
            	"eventInfo": data1.field.einfo
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/event/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        form.on('submit(sube3)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.eNumber,
            	"eventTime": data1.field.eventime,
            	"eventPlace": data1.field.eplace,
            	"eventKind": data1.field.ekind,
            	"driverIN": data1.field.eIN,
            	"eventReason": data1.field.ereason,
            	"eventInfo": data1.field.einfo
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/event/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        form.on('submit(sube5)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.eNumber,
            	"eventTime": data1.field.eventime,
            	"eventPlace": data1.field.eplace,
            	"eventKind": data1.field.ekind,
            	"driverIN": data1.field.eIN,
            	"eventReason": data1.field.ereason,
            	"eventInfo": data1.field.einfo
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/event/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        form.on('submit(sube7)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.eNumber,
            	"eventTime": data1.field.eventime,
            	"eventPlace": data1.field.eplace,
            	"eventKind": data1.field.ekind,
            	"driverIN": data1.field.eIN,
            	"eventReason": data1.field.ereason,
            	"eventInfo": data1.field.einfo
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/event/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        form.on('submit(sube9)', function (data1) {
            console.log(data1);
            var adata = {
            	"carNumber": data1.field.eNumber,
            	"eventTime": data1.field.eventime,
            	"eventPlace": data1.field.eplace,
            	"eventKind": data1.field.ekind,
            	"driverIN": data1.field.eIN,
            	"eventReason": data1.field.ereason,
            	"eventInfo": data1.field.einfo
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/event/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        //提交表单--重载表格 event
        form.on('submit(sube4)',function(data2){
        	console.log(data2);
        	var adata = {
        		"carNumber":data2.field.eNumber2,
        		"eventKind": data2.field.ekind2,
				"st":data2.field.est2,
				"et":data2.field.eet2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns6.reload({
        		url: '/event/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.eNumber2,
	        		"eventKind": data2.field.ekind2,
					"st":data2.field.est2,
					"et":data2.field.eet2
        		}
        	});
        	return false;
        });
        //提交表单--重载表格 event
        form.on('submit(sube6)',function(data2){
        	console.log(data2);
        	var adata = {
        		"carNumber":data2.field.eNumber2,
        		"eventKind": data2.field.ekind2,
				"st":data2.field.est2,
				"et":data2.field.eet2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns7.reload({
        		url: '/event/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.eNumber2,
	        		"eventKind": data2.field.ekind2,
					"st":data2.field.est2,
					"et":data2.field.eet2
        		}
        	});
        	return false;
        });
        //提交表单--重载表格 event
        form.on('submit(sube8)',function(data2){
        	console.log(data2);
        	var adata = {
        		"carNumber":data2.field.eNumber2,
        		"eventKind": data2.field.ekind2,
				"st":data2.field.est2,
				"et":data2.field.eet2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns8.reload({
        		url: '/event/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.eNumber2,
	        		"eventKind": data2.field.ekind2,
					"st":data2.field.est2,
					"et":data2.field.eet2
        		}
        	});
        	return false;
        });
        //提交表单--重载表格 event
        form.on('submit(sube2)',function(data2){
        	console.log(data2);
        	var adata = {
        		"carNumber":data2.field.eNumber2,
        		"eventKind": data2.field.ekind2,
				"st":data2.field.est2,
				"et":data2.field.eet2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns3.reload({
        		url: '/event/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"carNumber":data2.field.eNumber2,
	        		"eventKind": data2.field.ekind2,
					"st":data2.field.est2,
					"et":data2.field.eet2
        		}
        	});
        	return false;
        });
	    //渲染表格 driver
	    var tableIns4 = table.render({
	        elem: '#driver',
	        height: 312,
	        url: '/driver/selectAll', //数据接口
	        method: 'post',
	        page: true, //开启分页
	        limit: 10,
	        cols: [[ //表头
	            {field: 'LN', title: '驾驶员编号', width: '17%', sort: true, align:'center'}
	            , {field: 'name', title: '驾驶员姓名', width: '17%', align:'center'}
	            , {field: 'sex', title: '性别', width: '16%', sort: true, align:'center'}
	            , {field: 'age', title: '年龄', width: '16%', align:'center'}
	            , {field: 'phone', title: '联系方式', width: '17%', align:'center'}
	            , {field: 'LK', title: '驾照类型', width:'17%',align:'center' }
	        ]]
	    });
	    //提交表单--插入数据 driver
        form.on('submit(subd)', function (data1) {
            console.log(data1);
            var adata = {
            	"ln": data1.field.dIN,
            	"name": data1.field.dname,
            	"sex": data1.field.dsex,
            	"age": data1.field.dbd,
            	"phone": data1.field.dphone,
            	"lk": data1.field.dLK
            }
            var ndata = JSON.stringify(adata);
            $.ajax({
                type: 'post',
                url: '/driver/insert',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: ndata,
                //data: "{\"carNumber\":\"" + data1.field.number + "\",\"carKind\":\"" + data1.field.kind + "\",\"carSeat\":\"" + data1.field.seat + "\",\"carLoad\":\"" + data1.field.heavy + "\",\"carFactory\":\"" + data1.field.factory + "\",\"carColor\":\"" + data1.field.color + "\",\"carState\":\"" + data1.field.state + "\",\"carOwner\":\"" + data1.field.name + "\",\"carON\":\"" + data1.field.phone + "\",\"date\":\"" + data1.field.nt + "\"}",
                //验证用户名是否可用
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
            })
            //防止页面跳转
            return false;
        });
        //提交表单--重载表格 driver
        form.on('submit(subd2)',function(data2){
        	console.log(data2);
        	var adata = {
        		"LN":data2.field.dIN2,
        		"LK": data2.field.dLK2
          };
        	var ndata = JSON.stringify(adata);
        	tableIns4.reload({
        		url: '/driver/select',
        		method: 'post',
        		contentType: 'application/json',
        		page: true, //开启分页
            	limit: 10,
        		where:{
        			"ln":data2.field.dIN2,
        			"lk": data2.field.dLK2
        		}
        	});
        	return false;
        });
});