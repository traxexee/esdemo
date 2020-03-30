var pageContext="/monitorplat";
window.sessionStorage.setItem("lockcms",false);
layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

   //登录按钮
    form.on("submit(login)",function(data){
        $.ajax({
            type : 'post',
            url :pageContext+"/login/login",
            contentType : "application/json;charset=utf-8",
            data :JSON.stringify(data.field),
            success : function(data) {
                if(data.code==0){
                    window.location.href = "page/index";
                }else{
                    layer.msg(data.msg);
                    $("#name").val("");
                    $("#password").val("");
                    $("#code").val("");
                    $("#yzm").attr("src", pageContext+"/yzm/codeImage?" + Math.random());
                }
            }
        })
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
function changeCode() {
    $("#yzm").attr("src", pageContext+"/yzm/codeImage?" + Math.random());
}
/*autodivheight();
function autodivheight(){
    var winHeight=0;
    if (window.innerHeight)
        winHeight = window.innerHeight;
    else if ((document.body) && (document.body.clientHeight))
        winHeight = document.body.clientHeight;
    if (document.documentElement && document.documentElement.clientHeight)
        winHeight = document.documentElement.clientHeight;
    document.getElementById("test").style.height= winHeight +"px";
}
window.onresize=autodivheight; //浏览器窗口发生变化时同时变化DIV
*/