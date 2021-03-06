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
            <th width="100">手续费余额</th>
            <th width="100">手续费支出</th>
            <th width="100">充入手续费</th>
            
            <th width="100">基本账户</th>
            <th width="100">入账笔数</th>
            <th width="100">入账金额</th>
            <th width="100">出账笔数</th>
            <th width="100">出账金额</th>
  
           
            <th width="100">运营账户</th>
             <th width="100">运营支出</th>
            <th width="100">运营入账</th>
            <th width="100">备注</th>
        
                    <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list orgFees as s>
        <tr>
         <td width="100">${s.billDate}</td>
            <td width="100">${s.fee}</td>
            <td width="100">${s.feeOut}</td>
            <td width="100">${s.feeIn}</td>
            
            <th width="100">${s.basic}</th>
            <th width="100">${s.incomeNum}</th>
            <th width="100"> ${s.incomeMoney}</th>
            <td width="100">${s.payOutNum!'0.00'}
            </td>
            <td width="100">${s.payOutMoney}</td>
            <td width="100">${s.operation}</td>
            <td width="100">${s.operationOut}</td>
            <td width="100">${s.operationIn}</td>
            <td width="100">${s.remark!''}</td>
          
            <td width="100">
             <a class="layui-bg-green details" id="${s.id?c}"  name="${s.billDate}_${org.name}"  href="javascript:void(0)" "> 添加备注</a>;
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
<script type="text/javascript" charset="utf8" src="${app.basePath}/org/orgFeeList.js"></script>
</body>
</html>