window.onload = init;  
			var bdMap = null;  
			var city = {};  
			var hasRTT = false;//是否有实时路况  
			var rttCtrl = null;  
			function init(){  
			    try{  
			        // initData();  
			        var bdMap = new BMap.Map("container");  
			        bdMap.centerAndZoom(new BMap.Point(116.404, 39.915), 15);  
			          
			        bdMap.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件  
			        bdMap.addControl(new BMap.ScaleControl());  // 添加默认比例尺控件  
			        bdMap.enableScrollWheelZoom( true );  
			        rttCtrl = new BMapLib.TrafficControl();  
			        bdMap.addControl(rttCtrl);  
			    }catch( e ){}  
			}  
			/** 
			    打开或关闭实时路况 
			*/  
			function openOrCloseRTT(){  
			    if( hasRTT ){// 没有实时路况  
			        rttCtrl.hideTraffic();  
			    }else{  
			        rttCtrl.showTraffic({predictDate:{hour:15, weekday: 5}});  
			    }  
			    hasRTT = !hasRTT;  
			}  