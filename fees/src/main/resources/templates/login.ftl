<#import "page/base.ftl" as base>
<!DOCTYPE html>
<html class="loginHtml">
<head>
	<meta charset="utf-8">
	<title>登录--layui后台管理模板 2.0</title>
	<meta name="renderer" content="webkit">
	<link rel="icon" href="${base.basePath}/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
	<link rel="stylesheet" href="${base.basePath}/layui/css/layui.css"/>
	<link rel="stylesheet" href="${base.basePath}/css/public.css"/>
</head>
<body class="loginBody">
	<form class="layui-form">
		<div class="login_face"><img src="${base.basePath}/images/timg.jpg" class="userAvatar"></div>
		<div class="layui-form-item input-item">
			<label for="name">用户名</label>
			<input type="text" placeholder="请输入用户名" autocomplete="off" id="name" name="name" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item">
			<label for="password">密码</label>
			<input type="password" placeholder="请输入密码" autocomplete="off" id="password" name="password" class="layui-input" lay-verify="required">
		</div>
		 <div class="layui-form-item input-item" id="imgCode">
            <label for="code">验证码</label>
            <input type="text" placeholder="请输入验证码" autocomplete="off" id="code" name="code" class="layui-input">
            <img id="yzm" height="36px" src="yzm/codeImage.jpg" onclick="changeCode()">
        </div>

        <div class="layui-form-item">
            <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
        </div>
	</form>
	<script type="text/javascript" src="${base.basePath}/layui/layui.js"></script>
	<script type="text/javascript" src="${base.basePath}/js/login.js"></script>
	<script type="text/javascript" src="${base.basePath}/js/cache.js"></script>
</body>
</html>