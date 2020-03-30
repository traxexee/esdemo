<#import "base.ftl" as base>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>亿米特手续费系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${base.basePath}/favicon.ico">
    <link rel="stylesheet" href="${base.basePath}/layui/css/layui.css"/>
    <link rel="stylesheet" href="${base.basePath}/css/index.css"/>
    <script type="text/javascript" src="${base.basePath}/js/jquery.js"></script>
</head>
<!-- onload="connect()" -->
<body class="main_body" onload="">
<div class="layui-layout layui-layout-admin">
    <!-- 顶部 -->
    <div class="layui-header header">
        <div class="layui-main mag0">
            <a href="#" class="logo" style="padding:0px;width:200px"><img src="${base.basePath}/images/logo2.png"></a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:;" class="seraph hideMenu icon-caidan"></a>
            <!-- 顶级菜单 -->
            <ul class="layui-nav mobileTopLevelMenus" mobile>
                <li class="layui-nav-item" data-menu="Management">
                    <a href="javascript:;"><i class="seraph icon-caidan"></i><cite>系统菜单</cite></a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this" data-menu="contentManagement"><a href="javascript:;"><i class="layui-icon"
                                                                                                data-icon="&#xe63c;">&#xe63c;</i><cite>手续费使用</cite></a>
                        </dd>
                        <dd data-menu="memberCenter"><a href="javascript:;"><i class="seraph icon-icon10"
                                                                               data-icon="icon-icon10"></i><cite>用户中心</cite></a>
                        </dd>
                        <dd data-menu="systemSettings"><a href="javascript:;"><i class="layui-icon"
                                                                                 data-icon="&#xe620;">&#xe620;</i><cite>系统设置</cite></a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav topLevelMenus" pc>
                <li class="layui-nav-item layui-this" data-menu="contentManagement">
                    <a href="javascript:;"><i class="layui-icon" data-icon="&#xe63c;">&#xe63c;</i><cite>手续费使用</cite></a>
                </li>
                <li class="layui-nav-item" data-menu="memberCenter" pc>
                    <a href="javascript:;"><i class="seraph icon-icon10"
                                              data-icon="icon-icon10"></i><cite>用户中心</cite></a>
                </li>
                <li class="layui-nav-item" data-menu="systemSettings" pc>
                    <a href="javascript:;"><i class="layui-icon" data-icon="&#xe620;">&#xe620;</i><cite>系统设置</cite></a>
                </li>
            </ul>
            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav top_menu">
                <!-- <li class="layui-nav-item" pc>
                    <a href="javascript:;" class="clearCache">
                        <i class="layui-icon" data-icon="&#xe640;">&#xe640;</i>
                        <label id = "normalAlarm">0</label>
                        <label id = "middleAlarm"></label>
                        <label id = "seriousAlarm"></label>
                    </a>
                </li> -->
                <li class="layui-nav-item lockcms" pc>
                    <a href="javascript:;"><i class="seraph icon-lock"></i><cite>锁屏</cite></a>
                </li>
                <li class="layui-nav-item" id="userInfo">
                    <a href="javascript:;"><cite class="adminName">系统操作</cite></a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="/page/user/changePwd.html"><i class="seraph icon-xiugai"
                                                                                           data-icon="icon-xiugai"></i><cite>修改密码</cite></a>
                        </dd>
                        <dd pc><a href="javascript:;" class="changeSkin"><i
                                class="layui-icon">&#xe61b;</i><cite>更换皮肤</cite></a></dd>
                        <dd><a href="#" onclick="logout();" class="signOut"><i
                                class="seraph icon-tuichu"></i><cite>退出</cite></a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="user-photo">
            <input type="hidden" id="lockUserName" value="张三">
            <p>你好！<span>张三</span>, 欢迎登录</p>
        </div>
        <div class="navBar layui-side-scroll" id="navBar">
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="${base.basePath}/main"><i class="layui-icon"
                                                                               data-icon=""></i><cite>后台首页</cite></a>
                </li>
            <#list provinces as province>
                <li class="layui-nav-item ">
                    <a href="javascript:;" data-url="${base.basePath}/province/day/${province.id}"><i class="layui-icon" data-icon=""></i><cite>${province.province}</cite></a>
                </li>
            </#list>

            </ul>
        </div>
    </div>
    <!-- 右侧内容 -->
    <div class="layui-body layui-form">
        <div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs">
                <li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>
            </ul>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i>
                            刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="seraph icon-prohibit"></i> 关闭其他</a>
                        </dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="seraph icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src="${base.basePath}/org" name="监控首页"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
    <div class="layui-footer footer">
        <p><span>copyright @2018 亿米特数据科技有限公司</span></p>
    </div>
</div>

<!-- 移动导航 -->
<div class="site-tree-mobile"><i class="layui-icon">&#xe602;</i></div>
<div class="site-mobile-shade"></div>

</body>
<script type="text/javascript" src="${base.basePath}/layui/layui.js"></script>
<script type="text/javascript" src="${base.basePath}/js/index.js"></script>
<script type="text/javascript" src="${base.basePath}/js/cache.js"></script>

</html>