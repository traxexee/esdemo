<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
</head>
<body >

<div id="detail-all">
    <input type="hidden" id="detail" value="${doc.content}"/>

</div>
</body>
<!-- 依 赖 脚 本 -->
<script src="/static/component/layui/layui.js"></script>
<script src="/static/component/pear/pear.js"></script>
<!-- 框 架 初 始 化 -->
<script>
    layui.use(['admin','jquery',"convert"], function() {
        var admin = layui.admin,
            $ = layui.jquery;
        $(function() {
            var detail = $("#detail").val();
            $("#detail-all").html(detail);

        });
    })
</script>
</html>