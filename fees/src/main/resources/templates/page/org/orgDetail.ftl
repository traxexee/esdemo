<#import "../base.ftl" as app>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>___县公司__天__流水--</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${app.basePath}/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${app.basePath}/css/public.css" media="all"/>
    <link rel="stylesheet" href="${app.basePath}/datatable/css/jquery.dataTables.css">
    <link rel="stylesheet" href="${app.basePath}/datatable/css/dataTables.bootstrap.css">
</head>
<body class="childrenBody">
<div style="padding: 15px;">
    <table id="Table" class="layui-table">
        <thead>
        <tr>
            <th scope="col" colspan="15">流水列表</th>
        </tr>
        <tr class="text-c">
       		<th width="100">日期</th>
            <th width="100">商户号</th>
            <th width="100">账户类型</th>
            <th width="100">记账时间</th>
            <th width="100">系统备注</th>
            <th width="100">申请人</th>
             <th width="100">收支类型(业务类型)</th>
             <th width="100">收支金额</th>
            <th width="100">状态</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
       <#list orgDetails as s>
        <tr>
         <td width="100">${s.billDate}</td>
            <td width="100">${s.mchId}</td>
         
            
            <th width="100">${s.accountType}</th>
            <th width="100">${s.chargeTime}</th>
            <th width="100"> ${s.remark}</th>
            <td width="100">${s.applicant}
            </td>
            <td width="100">${s.paymentType}(${s.businessType })</td>
            <td width="100">${s.paymentAmount}</td>
            <td width="100">
              <a class="layui-bg-green updateState" id="${s.id?c}" name="${s.billDate}_${s.mchId}" href="javascript:void(0)" "> 修改为已处理</a></td>
            <td width="100">
             <a class="layui-bg-green details" id="${s.id?c}"  name="${s.billDate}_${s.mchId}" href="javascript:void(0)" "> 修改备注</a>
                </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>


<script type="text/javascript" charset="utf8" src="${app.basePath}/layui/layui.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/js/main.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/datatable/js/jquery.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/org/orgBasicList.js"></script>
</body>
</html>