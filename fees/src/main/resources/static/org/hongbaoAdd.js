layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;



    //监听提交
    form.on('submit(addUser)', function(data){
        $.ajax({
            type : 'post',
            url : "/fees/hongbao/send",
            contentType : "application/json;charset=utf-8",
            data :JSON.stringify(data.field),
            success : function(data) {
                console.log(data);
                if(data.code==0){
                    parent.location.reload();
                }else{
                    layer.msg(data.msg)
                }
            }
        })
        return false;
    });

})