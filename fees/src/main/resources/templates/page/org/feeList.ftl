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
            <th width="100">商户号</th>
            <th width="100">记账时间</th>
            <th width="100">系统备注</th>
            <th width="100">申请人</th>
             <th width="100">收支类型(业务类型)</th>
             <th width="100">收支金额</th>
        </tr>
        </thead>
        <tbody>
   
        </tbody>
    </table>
</div>


<script type="text/javascript" charset="utf8" src="${app.basePath}/layui/layui.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/js/main.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/datatable/js/jquery.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="${app.basePath}/org/feeList.js"></script>
</body>
</html>