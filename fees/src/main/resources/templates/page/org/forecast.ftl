<#import "../base.ftl" as base>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>手续费预测</title>
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
<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">昨天剩余</label>
                <div class="layui-input-inline">
                    <input type="tel" name="yesterday" id="yesterday" autocomplete="off"  class="layui-input" value="${org.fee}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">历史使用<label>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">最大值</label>
                <div class="layui-input-inline">
                    <input type="tel" name="max" autocomplete="off" class="layui-input" value="${max}"
                           readonly="readonly">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">平均值</label>
                <div class="layui-input-inline">
                    <input type="tel" name="avg" id="avg" autocomplete="off" class="layui-input" value="${avg}"
                           readonly="readonly">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">最小值</label>
                <div class="layui-input-inline">
                    <input type="tel" name="min" autocomplete="off" class="layui-input" value="${min}"
                           readonly="readonly">
                </div>
            </div>
        </div>
        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">今天使用<label>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">已使用</label>
                <div class="layui-input-inline">
                    <input type="tel" name="used" id="used" autocomplete="off" class="layui-input" value="${org.orgCost.cost}" onchange="changeUse()"
                          >
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">当前剩余</label>
                <div class="layui-input-inline">
                    <input type="tel" name="using" id="using" autocomplete="off" class="layui-input"
                           value="${org.fee-org.orgCost.cost}" readonly="readonly">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">预计剩余</label>
                <div class="layui-input-inline">
                    <input type="tel" name="use" id="use" autocomplete="off" class="layui-input"
                           value="${org.fee-org.orgCost.forecast}" readonly="readonly">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">事件</label>
            <div class="layui-input-block">
                <input type="radio" name="multiple" value="1.5" id="input1" title="推文">
                <input type="radio" name="multiple" value="3"  id="input2" title="月度账单">
                <input type="radio" name="multiple" value="1.1"  id="input3"title="无" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">预计剩余</label>
                <div class="layui-input-inline">
                    <input type="tel" name="remaining" id="remaining" autocomplete="off" class="layui-input"
                           value="${(org.fee -(avg*1.1) )?c  }">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">可使用天数</label>
                <div class="layui-input-inline">
                    <input type="tel" name="tian" id="tian" autocomplete="off" class="layui-input" value="${org.fee/avg/1.1}">
                </div>
            </div>
        </div>
    </form>
</blockquote>
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

                var xAxisData = [<#list orgFeeList.billDate as num>${num}<#if num_has_next>,</#if></#list>];
                var data1 = [ <#list orgFeeList.feeOut as num>${num?string('#.00')}<#if num_has_next>,</#if></#list>];
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
                        text: '每日手续费使用',
                        padding: 20
                    },
                    legend: {
                        left: 150,
                        inactiveColor: '#abc',
                        borderWidth: 1,
                        data: [{
                            name: '金额'
                        }],
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
                        name: '金额',
                        type: 'bar',
                        stack: 'one',
                        itemStyle: itemStyle,
                        cursor: 'move',
                        data: data1
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
<script type="text/javascript" src="${base.basePath}/org/forecast.js"></script>
</html>