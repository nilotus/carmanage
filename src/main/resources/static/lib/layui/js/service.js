function service(i){
	var title1 = "使用反馈";
	var title2 = "在线客服";
	var title3 = "授权管理";
	var str1 = "<div style='text-align: center;'>"
					+"<br />"
					+"<p>你好，感谢您的使用</p>"
					+"<p>反馈信息请发送至邮箱1634983132@qq.com</p>"
					+"<p>感谢您的反馈，祝您生活愉快！</p>";
	var str2 = "<div style='text-align: center;'>"
					+"<br />"
					+"<p>你好，感谢您的使用</p>"
					+"<p>如果您在使用过程中遇到了问题请联系XXX</p>"
					+"<p>我们将尽快处理，祝您生活愉快！</p>";
	var str3 = "<div style='text-align: center;'>"
					+"<br />"
					+"<p>你好，感谢您的使用</p>"
					+"<p>如果您在使用过程中需要更高的权限请联系XXX</p>"
					+"<p>我们将尽快处理，祝您生活愉快！</p>";
	var title = "";
	var str = "";
	if(i==1){
		title = title1;
		str = str1;
	}
	if(i==2){
		title = title1;
		str = str2;
	}
	if(i==3){
		title = title3;
		str = str3;
	}
  	layer.open({
			type: 1,
			title:title,
			skin: 'layui-layer-rim', //加上边框
			area: ['350px', '200px'], //宽高
			content:str
			});
  }