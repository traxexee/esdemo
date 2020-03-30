<#import "../base.ftl" as base>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>监控首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${base.basePath}/layui/css/layui.css"/>
    <link rel="stylesheet" href="${base.basePath}/css/public.css"/>
    <link rel="stylesheet" href="${base.basePath}/css/main.css"/>

    <link rel="stylesheet" href="${base.basePath}/datatable/css/jquery.dataTables.css">
    <link rel="stylesheet" href="${base.basePath}/datatable/css/dataTables.bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
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
</style>
<body class="childrenBody" style="background: #f2f2f2;">
<div style="padding: 15px;">
    <table id="Table" class="layui-table">
        <thead>
        <tr>
            <th scope="col" colspan="15">各省手续费汇总</th>
        </tr>
        <tr class="text-c">
            <th width="100">名称</th>
        <#--   <th width="100">省公司编号</th>-->
            <th width="100">商户号</th>
            <th width="100">记账时间</th>
            <th width="100">基本账户</th>
            <th width="100">运营账户</th>
            <th width="100">手续费账户</th>
            <th width="100">今日已用</th>
            <th width="100">当前手续费余额</th>
            <th width="100">预计今天手续费余额</th>
            <th width="100">安全系数</th>

            <th width="100">系统备注</th>
            <th width="100">建议充值</th>
            <th width="100">历史最大值</th>
            <th width="100">状态</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list data as s>
        <tr>
            <td width="100">${s.name}</td>
        <#--  <th width="100">${s.orgNo}</th>-->
            <th width="100">${s.mchId}</th>
            <td width="100"> ${s.lastUpdateTime!''}</td>


            <td width="100">${s.basic}</td>
            <td width="100">${s.operation}</td>
            <th width="100">${s.fee}</th>


            <td width="100"> ${s.orgCost.cost}</td>

            <th width="100">${(s.fee - s.orgCost.cost )?c  }</th>
            <td width="100">  ${s.fee-s.orgCost.forecast}</td>
            <#if s.fee <= 0>
                <td width="100">${s.fee-s.orgCost.forecast}</td>
            <#else>
                <th width="100">${(s.fee-s.orgCost.forecast) / s.fee}</th>
            </#if>


            <td width="100">${s.remark!''}</td>
            <td width="100" <#if (s.fee-s.orgCost.forecast)< s.orgCost.forecast>
                style="background-color:red;
color:black"
            <#elseif (s.fee-s.orgCost.forecast)< s.orgCost.forecast*5>
                style="background-color:orange;
color:black"
            </#if>>
                <#if (s.fee-s.orgCost.forecast)< s.orgCost.forecast>
            ${s.suggest * 5}
<#elseif (s.fee-s.orgCost.forecast)< s.orgCost.forecast*5>
                ${s.suggest * 3}
                </#if></td>

            <td width="100"> ${s.maxFee!''}</td>
            <#if s.state<= 0>
                <th width="100">未使用</th>
            <#else>
                <th width="100">使用中</th>
            </#if>
            <td width="100">
            <#if s.parProvinceId== 0>
                <a class="layui-bg-green pro" id="${s.id?c}" name="${s.name}_${s.orgNo}" href="javascript:void(0)">
                    各市<cite class="layui-hide">各市</cite></a>
                </#if>
                <a class="layui-bg-green details" id="history/${s.id?c}" name="${s.name}_${s.orgNo}" href="javascript:void(0)">
                    历史<cite class="layui-hide">历史</cite></a>
                <a class="layui-bg-green tu" id="${s.id?c}" name="${s.name}_${s.orgNo}" href="javascript:void(0)">
                    折线图<cite class="layui-hide">折线图</cite></a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>

<script type="text/javascript" src="${base.basePath}/layui/layui.js"></script>
<script type="text/javascript" src="${base.basePath}/js/main.js"></script>
<script type="text/javascript" src="${base.basePath}/datatable/js/jquery.js"></script>
<script type="text/javascript" src="${base.basePath}/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${base.basePath}/org/orgList.js"></script>

</html>