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
        });
        laydate.render({
            elem: '#st',
            theme: 'molv'
        });
        laydate.render({
            elem: '#et',
            theme: 'molv'
        });
        //渲染表格
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
        //提交表单--插入数据
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
                    alert("插入失败");
                }
            })
            //防止页面跳转
            return false;
        });
        //提交表单--重载表格
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
        		where:{
        			"carNumber":data2.field.number2,
	        		"carKind": data2.field.kind2,
					"st":data2.field.st,
					"et":data2.field.et
        		}
        	});
        	return false;
        });
    });