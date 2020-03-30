var pageContext="/monitorplat";
var seconds = "平均响应时长";
clearInterval(Analyse);
DashBoard();
var Analyse=setInterval('getAnalyse();',3000);
	function getAnalyse(){
		$.ajax({
	        type : 'post',
	        url :pageContext+"/Analyse/getAnalyse",
	        dataType: "json",
	        contentType : "application/json",
	        success : function(data) {
	            	$("#analyseRequest").html(data.analyseRequest);
	            	$("#analyseResponse").html(data.analyseResponse);
	            	$("#analyseError").html(data.analyseError);
	            	$("#analyseRequestTime").html(data.analyseRequestTime);
	          
	        }
		})
	}
	
	BrokenLine("AnalyseChart",6,"spline","container",pageContext+"/Analyse/getAnalyseNow",pageContext+"/Analyse/getFewMinutesAgo",true);
	
	//chartName:唯一名称	Times:初始加载点	ChartStyle：图标样式	DIV：渲染位置	URLNew：动态加载	URL：初始加载	x轴：时间
	function BrokenLine(ChartName,Times,ChartStyle,DIV,URLNew,URL,x) {
		Highcharts.setOptions({
			global: {
				useUTC: false
			}
		});
		$(document).ready(function() {
			var options = {
				chart: {
					renderTo: DIV,
					type: ChartStyle,
					marginRight: 30,
					events: {
						load: function() {
							var series = this.series;
							setInterval(function() {
								$.ajax({
									url: URLNew,// 实时获取最新数据
									type: "post",
									cache: false,
									dataType: "json",
									data: {},
									ifModified: false,
									success: function(result){
										var x = (new Date()).getTime();
										var j = 0;
										jQuery.each(result, function(m, obj) {
											series[j++].addPoint([x, parseInt(obj.analyseRequest)],false, true, true);
											series[j++].addPoint([x, parseInt(obj.analyseResponse)],false, true, true);
											series[j++].addPoint([x, parseInt(obj.analyseError)],false, true, true);
											series[j++].addPoint([x, parseInt(obj.analyseRequestTime)],false, true, true);
											
										});ChartName.redraw();
									}
								});
							}, 60000);
						}
					}
				},
				title: {
	                text: ''
	            },
				xAxis: {
					type: 'datetime',
				},
				yAxis: {
					title: {
						text: '',
					},
					minorTickInterval: 'auto',
					lineWidth:1,
					plotLines: [{
						value: 0,
						width: 1,
						color: '#808080'
					}]
				},
				legend:{
					layout: 'vertical',
					align: 'left',
					verticalAlign: 'top',
					padding:0,
					itemMarginTop:20
				},
				tooltip: {
					crosshairs: true,
					formatter: function() {
						if(this.series.name==seconds){
							return '<b>'+ this.series.name +'</b><br/>值：'+
							Highcharts.numberFormat(this.y, 2) +'毫秒<br/>时间：'+ 
							Highcharts.dateFormat('%Y-%m-%d %H:%M', this.x);
						}else{
							return '<b>'+ this.series.name +'</b><br/>值：'+
							Highcharts.numberFormat(this.y, 2) +'<br/>时间：'+ 
							Highcharts.dateFormat('%Y-%m-%d %H:%M', this.x);
						}
					}
				},
				credits: {
					enabled: false
				},
				plotOptions: {
					series: {
						cursor: 'pointer',
						point: {
							events: {
								click: function() {
									hs.htmlExpand(null, {
										pageOrigin: {
											x: this.pageX,
											y: this.pageY
										},
										headingText: this.series.name,
										maincontentText: '值：' + this.y +':<br/>时间：'+ Highcharts.dateFormat('%Y-%m-%e %H:%M', this.x),
									});
								}
							}
						},
						marker: {
							lineWidth: 1
						}
					}
				},
				series: [{name: '每分钟请求数'},{name: '每分钟响应数'},{name: '每分钟错误数'},{name: '平均响应时长'}]
			};
			$.ajax({
				url : URL,
				type : "post",
				cache : false,
				dataType : "json",
				data : {},
				ifModified : false,
				success : function(result) {
					var analyseRequest = [];
					var analyseResponse = [];
					var analyseError = [];
					var analyseRequestTime = [];
					var time = (new Date()).getTime();
					jQuery.each(result, function(m, obj) {
						analyseRequest.push([ time + (m - Times) * 60000,parseInt(obj.analyseRequest)]);
						analyseResponse.push([ time + (m - Times) * 60000,parseInt(obj.analyseResponse) ]);
						analyseError.push([ time + (m - Times) * 60000,parseInt(obj.analyseError) ]);
						analyseRequestTime.push([ time + (m - Times) * 60000,parseInt(obj.analyseRequestTime)]);
					});
					options.series[0].data = analyseRequest;
					options.series[1].data = analyseResponse;
					options.series[2].data = analyseError;
					options.series[3].data = analyseRequestTime;
					ChartName = new Highcharts.Chart(options);
				}
			});
		});
	}
	
	function DashBoard(){
		
		Highcharts.setOptions({
			
	});
	// 仪表
	var chart1 = Highcharts.chart('container-speed', {
		chart: {
			type: 'solidgauge'
		},
		title: null,
		pane: {
				center: ['50%', '50%'],
				size: '100%',
				startAngle: -90,
				endAngle: 90,
				background: {
						backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
						innerRadius: '60%',
						outerRadius: '100%',
						shape: 'arc'
				}
		},
		tooltip: {
				enabled: false
		},
		yAxis: {
				stops: [
						[0.1, '#55BF3B'], // green
						[0.5, '#DDDF0D'], // yellow
						[0.9, '#DF5353'] // red
				],
				min: 0,
				max: 100,
				/* lineWidth: 0,
				minorTickInterval: null,
				tickPixelInterval: 400,
				tickWidth: 0,
				title: {
						y: -70
				},*/
				labels: {
						y: -10
				} 
		},
		plotOptions: {
				solidgauge: {
						dataLabels: {
								y: -40,
								borderWidth: 0,
								useHTML: true
						}
				}
		},
			credits: {
					enabled: false
			},
			series: [{
					data: [80],
					dataLabels: {
							format: '<div style="text-align:center"><span style="font-size:25px;">{y}%</span>'
					}
			}]
	});
	// 定时刷新数据
	setInterval(function () {
			var point,
					newVal;
			if (chart1) {
					point = chart1.series[0].points[0];
					$.ajax({
						url : pageContext+"/machineSer/getMachineCPU",
						type : "post",
						cache : false,
						dataType : "json",
						data : {},
						ifModified : true,
						success : function(result) {
							if(result!=0){
								point.update(result);
							}
						}
					});
					
			}
	}, 3000);

	}


//layui.use(['form','element','layer','jquery'],function(){
//    var form = layui.form,
//        layer = parent.layer === undefined ? layui.layer : top.layer,
//        element = layui.element;
//        $ = layui.jquery;
//
//    //外部图标
//    $.get(iconUrl,function(data){
//        $(".outIcons span").text(data.split(".icon-").length-1);
//    })
//    
//
//})


