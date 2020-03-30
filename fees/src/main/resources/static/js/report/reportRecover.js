layui.use(['form','layer','laydate','table','laytpl','element','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        element = layui.element,
        upload = layui.upload;
    
    var endDate= laydate.render({
        elem: '#end_time',//选择器结束时间
        type: 'datetime',
        min:"1970-1-1",//设置min默认最小值
        done: function(value,date){
            startDate.config.max={
                year:date.year,
                month:date.month-1,//关键
                date: date.date,
                hours: 0,
                minutes: 0,
                seconds : 0
            }
        }
    });
    //日期范围
    var startDate=laydate.render({
        elem: '#start_time',
        type: 'datetime',
        max:"2099-12-31",//设置一个默认最大值
        done: function(value, date){
            endDate.config.min ={
                year:date.year,
                month:date.month-1, //关键
                date: date.date,
                hours: 0,
                minutes: 0,
                seconds : 0
            };
        }
    });
    
    

})