<#import "../base.ftl" as base>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>统计小时</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${base.basePath}/layui/css/layui.css"/>
    <link rel="stylesheet" href="${base.basePath}/css/public.css"/>
    <link rel="stylesheet" href="${base.basePath}/css/main.css"/>
    <script src="${base.basePath}/echart/lib/esl.js"></script>
    <script src="${base.basePath}/echart/lib/config.js"></script>
    <script src="${base.basePath}/echart/lib/jquery.min.js"></script>
    <script src="${base.basePath}/echart/lib/facePrint.js"></script>
    <script src="${base.basePath}/echart/lib/testHelper.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>


<body class="childrenBody" style="background: #f2f2f2;">
<style>
    h1 {
        line-height: 60px;
        height: 60px;
        background: #146402;
        text-align: center;
        font-weight: bold;
        color: #eee;
        font-size: 14px;
    }

    .chart {
        height: 600px;
    }
</style>
<div id="main" class="chart">
</div>
<script>

    require(
            (testHelper.hasURLParam('en')
                            ? [
                                'echarts',
                                // 'echarts/lang/en',
                            ]
                            : [
                                'echarts'
                            ]
            ).concat(
                    [
                        // 'echarts/chart/bar',
                        // 'echarts/chart/line',
                        // 'echarts/component/legend',
                        // 'echarts/component/graphic',
                        // 'echarts/component/grid',
                        // 'echarts/component/tooltip',
                        // 'echarts/component/brush',
                        // 'echarts/component/toolbox',
                        // 'echarts/component/title',
                        // 'zrender/vml/vml'
                    ]
            ),
            function (echarts) {

                var chart = echarts.init(document.getElementById('main'));

                var xAxisData = [<#list data.strings as num>${num}<#if num_has_next>,</#if></#list>];
                var data0 = [<#list data.strings as num>${data.nums[(num_index*24+0)]}<#if num_has_next>,</#if></#list>];
                var data1 = [<#list data.strings as num>${data.nums[(num_index*24+1)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data2 = [<#list data.strings as num>${data.nums[(num_index*24+2)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data3 = [<#list data.strings as num>${data.nums[(num_index*24+3)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data4 = [<#list data.strings as num>${data.nums[(num_index*24+4)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data5 = [<#list data.strings as num>${data.nums[(num_index*24+5)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data6 = [<#list data.strings as num>${data.nums[(num_index*24+6)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data7 = [<#list data.strings as num>${data.nums[(num_index*24+7)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data8 = [<#list data.strings as num>${data.nums[(num_index*24+8)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data9 = [<#list data.strings as num>${data.nums[(num_index*24+9)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data10 = [<#list data.strings as num>${data.nums[(num_index*24+10)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data11 = [<#list data.strings as num>${data.nums[(num_index*24+11)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data12 = [<#list data.strings as num>${data.nums[(num_index*24+12)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data13 = [<#list data.strings as num>${data.nums[(num_index*24+13)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data14 = [<#list data.strings as num>${data.nums[(num_index*24+14)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data15 = [<#list data.strings as num>${data.nums[(num_index*24+15)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data16 = [<#list data.strings as num>${data.nums[(num_index*24+16)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data17 = [<#list data.strings as num>${data.nums[(num_index*24+17)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data18 = [<#list data.strings as num>${data.nums[(num_index*24+18)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data19 = [<#list data.strings as num>${data.nums[(num_index*24+19)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data20 = [<#list data.strings as num>${data.nums[(num_index*24+20)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data21 = [<#list data.strings as num>${data.nums[(num_index*24+21)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data22 = [<#list data.strings as num>${data.nums[(num_index*24+22)]?string('#')}<#if num_has_next>,</#if></#list>];
                var data23 = [<#list data.strings as num>${data.nums[(num_index*24+23)]?string('#')}<#if num_has_next>,</#if></#list>];


                for (var i = 0; i < 10; i++) {


                    data2.push(-Math.random().toFixed(2));
                }

                var itemStyle = {
                    normal: {
                        barBorderRadius: 5,
                        label: {
                            show: true,
                            position: 'outside'
                        }
                    },
                    emphasis: {
                        label: {
                            position: 'outside'
                        },
                        barBorderColor: '#fff',
                        barBorderWidth: 1,
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowOffsetY: 0,
                        shadowColor: 'rgba(0,0,0,0.5)'
                    }
                };

                chart.setOption({
                    backgroundColor: '#eee',
                    title: {
                        text: '月交易',
                        padding: 20
                    },
                    legend: {
                        left: 150,
                        inactiveColor: '#abc',
                        borderWidth: 1,
                        data: [ '0','1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23',],
                        selected: {
                            // 'bar': false
                        },
                        // orient: 'vertical',
                        // x: 'right',
                        // y: 'bottom',
                        align: 'left',

                        tooltip: {
                            show: true
                        }
                    },
                    brush: {
                        xAxisIndex: 0
                    },
                    toolbox: {
                        top: 50,
                        // right: 20,
                        feature: {
                            magicType: {
                                type: ['line', 'bar', 'stack', 'tiled']
                            },
                            dataView: {},
                            saveAsImage: {
                                pixelRatio: 2
                            },
                            brush: {
                                type: ['rect', 'polygon', 'lineX', 'lineY', 'keep', 'clear']
                            },
                            restore: {},
                            dataZoom: {}
                        },

                        iconStyle: {
                            emphasis: {
                                textPosition: 'top'
                                // textAlign: 'right'
                            }
                        }
                    },
                    tooltip: {},
                    grid: {
                        top: 100
                    },
                    xAxis: {
                        data: xAxisData,
                        name: '横轴',
                        silent: false,
                        axisTick: {
                            alignWithLabel: true
                        },
                        // axisLabel: {
                        //     show: false
                        // },
                        // axisTick: {
                        //     show: false
                        // },
                        axisLine: {
                            onZero: true
                            // lineStyle: {
                            //     width: 5
                            // }
                        },
                        splitLine: {
                            show: true
                        },
                        splitArea: {
                            show: true
                        }
                    },
                    yAxis: {
                        inverse: false,
                        // axisLabel: {
                        //     show: false
                        // },
                        // axisLine: {
                        //     lineStyle: {
                        //         width: 5
                        //     }
                        // },
                        axisTick: {
                            show: false
                        },
                        // splitLine: {
                        //     show: false
                        // },
                        splitArea: {
                            show: false
                        }
                    },
                    series: [{
                        name: '0',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'move',
                        data: data0
                    }, {
                        name: '1',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data1
                    }, {
                        name: '2',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data2
                    }, {
                        name: '3',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data3
                    }, {
                        name: '4',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data4
                    }, {
                        name: '5',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data5
                    }, {
                        name: '6',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data6
                    }, {
                        name: '7',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data7
                    }, {
                        name: '8',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data8
                    }, {
                        name: '9',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data9
                    },{
                        name: '10',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'move',
                        data: data10
                    }, {
                        name: '11',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data11
                    }, {
                        name: '12',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data12
                    }, {
                        name: '13',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data13
                    }, {
                        name: '14',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data14
                    }, {
                        name: '15',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data15
                    }, {
                        name: '16',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data16
                    }, {
                        name: '17',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data17
                    }, {
                        name: '18',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data18
                    }, {
                        name: '19',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data19
                    },{
                        name: '20',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'move',
                        data: data20
                    }, {
                        name: '21',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data21
                    }, {
                        name: '22',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data22
                    }, {
                        name: '23',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'default',
                        data: data23
                    }]
                });

                chart.on('click', function (params) {
                    console.log(params);
                });

                chart.on('legendselectchanged', function (params) {
                    chart.setOption({
                        // title: {
                        // },
                        graphic: [{
                            type: 'circle',
                            shape: {
                                cx: 100,
                                cy: 100,
                                r: 20,
                            }
                        }]
                    });
                });

                window.onresize = chart.resize;
            }
    );
</script>
</body>

<script type="text/javascript" src="${base.basePath}/js/jquery.js"></script>
<script type="text/javascript" src="${base.basePath}/layui/layui.js"></script>
<script type="text/javascript" src="${base.basePath}/js/mainLayui.js"></script>

</html>