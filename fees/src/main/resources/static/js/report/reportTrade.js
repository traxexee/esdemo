layui.use(['form','layer','laydate','table','laytpl','element'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        element = layui.element;
    
    //数据列表
    var tableIns = table.render({
        elem: '#tradeList',
        url : parent.pageContext+'/Analyse/getAllTrade',
        cellMinWidth : 95,
        page : true,
        height : "full-150",
        limit : 10,
        limits : [10,15,20,25],
        id : "tradeTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'analyseChannelName', title: '交易渠道',align:"center"},
            {field: 'analyseMoney', title: '交易金额',align:'center'},
            {field: 'analyseTime', title: '交易时间',align:"center",templet:function(d){
            	return new Date(parseInt(d.analyseTime)).toLocaleString().replace(/:\d{1,2}$/,'').replace("/","-").replace("/","-"); 
            }}
        ]]
    });
    
    
    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("strokeTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });
    
    

})