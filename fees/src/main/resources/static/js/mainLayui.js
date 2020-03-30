layui.use(['form','layer','laydate','table','laytpl','element'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        element = layui.element;
    
    window.stroke = function(){
    	layer.open({
	           title : "交易渠道笔数详情",
	           type : 2,
	           area:['80%', '80%'],
	           content : pageContext+"/page/mainPage/stroke",
	           success : function(layero, index){
	        		   }
    	});
    }
    
    window.money = function(){
    	layer.open({
    		title : "交易渠道金额详情",
    		type : 2,
    		area:['80%', '80%'],
    		content : pageContext+"/page/mainPage/money",
    		success : function(layero, index){
    		}
    	});
    }
    
    window.getAllTrade = function(){
    	layer.open({
    		title : "今日交易详情",
    		type : 2,
    		area:['80%', '80%'],
    		content : pageContext+"/page/mainPage/trade",
    		success : function(layero, index){
    		}
    	});
    }
    
    

})