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
        elem: '#moneyScalList',
        url : parent.pageContext+'/Analyse/getAllMoneyScal',
        cellMinWidth : 95,
        page : true,
        height : "full-150",
        limit : 10,
        limits : [10,15,20,25],
        id : "moneyScalTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'analyseChannelName', title: '渠道名称',align:"center"},
            {field: 'analyseMoney', title: '总金额',align:'center'},
            {title: '操作', width:100, templet:'#moneyScalListBar',fixed:"right",align:"center"}
           
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
    
    table.on('tool(moneyScalList)', function(obj){
        var layEvent = obj.event,
        data = obj.data;
        if(layEvent === 'detail'){
        	var tableIns = table.render({
                elem: '#moneyScalDetailList',
                url : parent.pageContext+'/Analyse/getStrokeDetail',
                where: { analyseChannel: data.analyseChannel },
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limit : 20,
                limits : [20,30,50,100],
                id : "moneyScalTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'analyseTime', title: '缴费时间',align:"center",templet:function(d){
                    	return new Date(parseInt(d.analyseTime)).toLocaleString().replace(/:\d{1,2}$/,'').replace("/","-").replace("/","-"); 
                    }},
                    {field: 'analyseMoney', title: '缴费金额',align:'center'}
                   
                ]]
            });
        }
    });
    

})