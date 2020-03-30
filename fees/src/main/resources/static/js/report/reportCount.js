var pageContext="/monitorplat";
var endTime = new Date(new Date().setHours(0, 0, 0, 0))-0;
var statTime = endTime - 86400 * 1000;

getCountChart();
getReqChart(null);
getMoneyScal();
getStroke();
getCount();

Highcharts.setOptions({ 
	global: { 
		useUTC: false 
		} 
	});
//交易峰值曲线
function getCountChart(){
	$.getJSON(pageContext + '/report/getCountChart',{'rStartTime':statTime,'rEndTime':endTime},function (data) {
		Highcharts.chart('CountDiv', {
			chart: {
				zoomType: 'x'
			},
			title: {
				text: '交易峰值'
			},
			credits: {
			     enabled: false
			},
			xAxis: {
				type: 'datetime',
				dateTimeLabelFormats: {
					millisecond: '%H:%M:%S.%L',
					second: '%H:%M:%S',
					minute: '%H:%M',
					hour: '%H:%M',
					day: '%m-%d',
					week: '%m-%d',
					month: '%Y-%m',
					year: '%Y'
				}
			},
			tooltip: {
				dateTimeLabelFormats: {
					millisecond: '%Y-%m-%d %H:%M:%S.%L',
					second: '%Y-%m-%d %H:%M:%S',
					minute: '%Y-%m-%d %H:%M',
					hour: '%Y-%m-%d %H:%M',
					day: '%Y-%m-%d',
					week: '%m-%d',
					month: '%Y-%m',
					year: '%Y'
				}
			},
			yAxis: {
				title: {
					text: '交易量'
				},
				min:0
			},
			legend: {
				enabled: false
			},
			plotOptions: {
				area: {
					fillColor: {
						linearGradient: {
							x1: 0,
							y1: 0,
							x2: 0,
							y2: 1
						},
						stops: [
							[0, Highcharts.getOptions().colors[0]],
							[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
						]
					},
					marker: {
						radius: 2
					},
					lineWidth: 1,
					states: {
						hover: {
							lineWidth: 1
						}
					},
					threshold: null
				}
			},
			series: [{
				type: 'area',
				name: '交易量：',
				data: data.msg
			}]
		});
	});
}

function getMsgByType(id){
	if(id=="layuisecondli"){
		 document.getElementById('layuifirstli').style.backgroundColor = "white";
		 document.getElementById('layuisecondli').style.backgroundColor = "darkgray";
		 getReqChart('/report/getMoneyChart');
	}else{
		 document.getElementById('layuisecondli').style.backgroundColor = "white";
		 document.getElementById('layuifirstli').style.backgroundColor = "darkgray";
		 getReqChart('/report/getReqChart');
	}
}

//交易量+交易金额
function getReqChart(URL){
	if(URL == null){
		URL = '/report/getReqChart';
	}
	$.getJSON(pageContext + URL,{'rStartTime':statTime,'rEndTime':endTime},function (data) {
		Highcharts.chart('ReqDiv',{
			chart: {
				type: 'area',
				zoomType: 'x'
			},
			title: {
				text: ''
			},
			xAxis: {
				allowDecimals: false
			},
			legend: {
				align: 'right',
				verticalAlign: 'top',
				padding:0,
				floating:true
			},
			credits: {
				enabled: false
			},
			xAxis: {
				type: 'datetime',
				dateTimeLabelFormats: {
					millisecond: '%H:%M:%S.%L',
					second: '%H:%M:%S',
					minute: '%H:%M',
					hour: '%H:%M',
					day: '%m-%d',
					week: '%m-%d',
					month: '%Y-%m',
					year: '%Y'
				}
			},
			tooltip: {
				dateTimeLabelFormats: {
					millisecond: '%Y-%m-%d %H:%M:%S.%L',
					second: '%Y-%m-%d %H:%M:%S',
					minute: '%Y-%m-%d %H:%M',
					hour: '%Y-%m-%d %H:%M',
					day: '%Y-%m-%d',
					week: '%m-%d',
					month: '%Y-%m',
					year: '%Y'
				}
			},
			yAxis: {
				title: {
					text: '交易量'
				},
				min:0
			},
			colors:[
                Highcharts.getOptions().colors[0],
                'red',
            ],
			plotOptions: {
				area: {
					fillColor: {
						linearGradient: {
							x1: 0,
							y1: 0,
							x2: 0,
							y2: 1
						},
						stops: [
							[0, Highcharts.getOptions().colors[0]],
							[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')],
						]
					},
					marker: {
						radius: 2
					},
					lineWidth: 1,
					states: {
						hover: {
							lineWidth: 1
						}
					},
					threshold: null
				}
			},
			series: data
		});
	});
	
	
}



//金额比例
function getMoneyScal(){
	$.getJSON(pageContext + '/report/getMoneyScal',{'rStartTime':statTime,'rEndTime':endTime},function (data) {
		Highcharts.chart('moneyDiv', {
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie'
			},
			title: {
				text: '金额比例',
				align:"left",
				floating:true
			},
			tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			credits: {
			     enabled: false
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: false
					},
				}
			},
			series: [{
				name: 'Brands',
				colorByPoint: true,
				data: data
			}]
		});
	});
}


//交易笔数
function getStroke(){
	$.getJSON(pageContext + '/report/getStroke',{'rStartTime':statTime,'rEndTime':endTime},function (data) {
		Highcharts.chart('strokeDiv', {
			title: {
				text: '交易比例',
				align:"left",
				floating:true
			},
			credits: {
			     enabled: false
			},
			tooltip: {
				headerFormat: '{series.name}<br>',
				pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
			},
			plotOptions: {
				pie: {
					dataLabels: {
						enabled: false,
						distance: -50,
						style: {
							fontWeight: 'bold',
							color: 'white',
							textShadow: '0px 1px 2px black'
						}
					},
					startAngle: -90, // 圆环的开始角度
					endAngle: 90,    // 圆环的结束角度
					center: ['50%', '100%'],
					size:200
				}
			},
			series: [{
				type: 'pie',
				name: '交易占比',
				innerSize: '50%',
				data: data.msg
			}]
		});
	});
}

//交易整体信息
function getCount(){
	$.getJSON(pageContext + '/report/getCount',{'rStartTime':statTime,'rEndTime':endTime},function (data) {
		Highcharts.chart('countDiv', {
			chart: {
				type: 'column'
			},
			title: {
				text: '交易总数',
				align:"left",
				floating:true
			},
			credits: {
			     enabled: false
			},
			legend: {
				layout: 'vertical',
				align: 'right',
				verticalAlign: 'top',
				padding:0,
				floating:true
			},
			xAxis: {
				title: {
					text: null
				}
			},
			yAxis: {
				min: 0,
				title: {
					text: '',
				},
				labels: {
					overflow: 'justify'
				}
			},
			tooltip: {
				formatter: function() {
					if(this.series.name=="金额数"){
						return '<b>'+ this.series.name +'</b><br/>值：'+ this.y +'千元';
					}else{
						return '<b>'+ this.series.name +'</b><br/>值：'+ this.y;
					}
				}
			},
			plotOptions: {
				column: {
					dataLabels: {
						enabled: true,
						allowOverlap: true, // 允许数据标签重叠
					}
				}
			},
			series:data
		});
	});
}









layui.use(['form','layer','laydate','table','laytpl','element'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        element = layui.element;
    
    var endDate= laydate.render({
        elem: '#end_time',//选择器结束时间
        type: 'datetime',
        min:"1970-1-1",//设置min默认最小值
        done: function(value,date){
            startDate.config.max={
                year:date.year,
                month:date.month-1,//关键
                date: date.date,
                hours: 0,
                minutes: 0,
                seconds : 0
            }
        }
    });
    //日期范围
    var startDate=laydate.render({
        elem: '#start_time',
        type: 'datetime',
        max:"2099-12-31",//设置一个默认最大值
        done: function(value, date){
            endDate.config.min ={
                year:date.year,
                month:date.month-1, //关键
                date: date.date,
                hours: 0,
                minutes: 0,
                seconds : 0
            };
        }
    });
    
    var tableIns = table.render({
        elem: '#reportCountList',
        url : parent.pageContext+'/report/getReportByday',
        cellMinWidth : 95,
        page : true,
        height : "full-80",
        limit : 10,
        limits : [31,310,3100],
        id : "reportCountTable",
        cols : [[
             {field: 'rid',type: "checkbox", fixed:"left", width:50},
             {field: 'rstartTime', title: '时间',align:'center',width:180,templet:function(d){
            	 return new Date(parseInt(d.rstartTime)).toLocaleString().replace(/:\d{1,2}$/,'').replace("/","-").replace("/","-"); 
             }},
            {field: 'rrequest', title: '总交易量',align:"center"},
            {field: 'rerror', title: '错误交易量',align:"center",width:100,event: 'setSign', style:'cursor: pointer;'},
            {field: 'rmoney', title: '交易总金额',align:"center",width:100},
            {field: '', title: '整体平均响应',align:"center",width:150,templet:function(d){
           	 	return d.wxAverageTime+d.tuxAverageTime;
            }},
            {field: 'tradeMax', title: '整体最大响应',align:"center",width:150},
            {field: 'tradeMin', title: '整体最小响应',align:"center",width:150,templet:function(d){
            	if(d.tradeMin==10000000){
           	 		return 0;
           	 	}else{
           	 		return d.tradeMin
           	 	}
            }},
            {field: 'wxAverageTime', title: '回调平均时间',align:"center",width:150},
            {field: 'wxMaxTime', title: '回调最大时间',align:"center",width:150},
            {field: 'wxMinTime', title: '回调最小时间',align:"center",width:150,templet:function(d){
            	if(d.wxMinTime==10000000){
           	 		return 0;
           	 	}else{
           	 		return d.wxMinTime
           	 	}
            }},
            {field: 'msgAverageTime', title: '信息处理平均时间',align:"center",width:150},
            {field: 'msgMaxTime', title: '信息处理最大时间',align:"center",width:150},
            {field: 'msgMinTime', title: '信息处理最小时间',align:"center",width:150,templet:function(d){
           	 	if(d.msgMinTime==10000000){
           	 		return 0;
           	 	}else{
           	 		return d.msgMinTime
           	 	}
            }},
            {field: 'tuxAverageTime', title: '网关平均时间',align:"center",width:150},
            {field: 'tuxMaxTime', title: '网关最大时间',align:"center",width:150},
            {field: 'tuxMinTime', title: '网关最小时间',align:"center",width:150,templet:function(d){
           	 	if(d.tuxMinTime==10000000){
           	 		return 0;
           	 	}else{
           	 		return d.tuxMinTime
           	 	}
            }}
           
        ]]
    });
    
    
    
    $(".search_btn").on("click",function(){
    	statTime = $("#start_time").val()==""?0:new Date($("#start_time").val()).getTime();
    	endTime = $("#end_time").val()==""?0:new Date($("#end_time").val()).getTime();
    	table.reload("reportCountTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                "rStartTime":statTime,
                "rEndTime":endTime
            }
        })
        getCountChart();
        getMsgByType(null);
        getMoneyScal();
        getStroke();
        getCount();
    });
    
    window.reportMoney = function(){
    	layer.open({
	           title : "金额比例详情",
	           type : 2,
	           area:['80%', '80%'],
	           content : pageContext+"/page/report/reportMoney",
	           success : function(layero, index){
	        		   }
    	});
    }
    
    window.reportStroke = function(){
    	layer.open({
	           title : "渠道比例详情",
	           type : 2,
	           area:['80%', '80%'],
	           content : pageContext+"/page/report/reportStroke",
	           success : function(layero, index){
	        		   }
    	});
    }
    window.reportTrade = function(){
    	layer.open({
    		title : "交易详情",
    		type : 2,
    		area:['80%', '80%'],
    		content : pageContext+"/page/report/reportTrade",
    		success : function(layero, index){
    		}
    	});
    }
    
    table.on('tool(reportCountList)', function(obj){
        var data = obj.data;
        if(obj.event === 'setSign'){
        	$.ajax({
                type : 'post',
                url :parent.pageContext+"/report/showErrorSerial?rStartTime="+data.rstartTime,
                dataType: "json",
                contentType : "application/json",
                success: function (data) {
                	if(data.serial!=null&&data.serial!=""){
                		layer.open({
                			type: 1
                			,title: "错误流水" //不显示标题栏
                				,closeBtn: false
                				,area: '500px;'
                					,shade: 0.8
                					,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                						,btn: ['确定']
                		,btnAlign: 'c'
                			,moveType: 1 //拖拽模式，0或者1
                			,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;word-break: break-all; word-wrap:break-word;">' + data.serial + '</div>'
                			,success: function(layero){
                				
                			}
                		});
                	}
                }
            })
        	
        	
        }
      });
    

})