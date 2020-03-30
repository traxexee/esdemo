<#import "../base.ftl" as app>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页--</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${app.basePath}/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${app.basePath}/css/public.css" media="all"/>
</head>
<body class="childrenBody">
<div style="padding: 15px;">
    <ul class="layui-timeline">
    <#assign flag="0">
    <#if orgDetails?? && (orgDetails?size > 0) >
    <#list orgDetails as ss>
        <li class="layui-timeline-item" >
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <h3 class="layui-timeline-title">记账时间：  <#if ss.chargeTime??> ${ss.chargeTime}</#if> <#if ss.paymentType=="支出">
 <span style="color:green">${ss.paymentType}</span>
<#else><span style="color:red">${ss.paymentType}</span>  
</#if></h3>
                <p >
                    <br> ${ss.applicant} :${ss.businessName}                     
                    <br> 业务类型 :${ss.businessType} 
                    <br><#if ss.paymentType=="支出">
                 <#assign flag="1"/>
 <span style="color:green">${ss.paymentType}</span>
<#else>
 <#assign flag="0"/>
<span style="color:red">${ss.paymentType}</span>  
</#if> 金额：${ss.paymentAmount}
                    <br> 账户结余:${ss.accountBalance}
                    <br> 单号：${ss.wxBillNo}
                    <br> 备注： ${ss.remark}
                </p>
            </div>
        </li>
    </#list>
    </ul>

 <#else>
           没有详情
                        </#if>
                            <#if flag=="1">
  <a class="layui-bg-green updateState" id="${id}"  href="javascript:void(0)" "> 确认提现成功</a>
    <#else>
 <#assign flag="0"/>
 <span class="layui-bg-red" id="${id}"  href="javascript:void(0)" "> 提现失败</span>

</#if>
</div>
</div>
<script type="text/javascript" src="${app.basePath}/layui/layui.js"></script>
<script src="${app.basePath}/datatable/js/jquery.js"></script>
<script type="text/javascript" src="${app.basePath}/org/accountDetail.js"></script>
</body>
</html>