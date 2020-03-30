$(document).ready( function () {
    $('#Table').DataTable({
    	  "iDisplayLength": 100,
		   "order": [[ 6, "asc" ]]	
    }
    
    );
 
} );
layui.use(['layer', 'form'], function(){
	  var layer = layui.layer


	});
$(document).on("click",".details",function(){
    $(this).find("cite").text("手续费使用_"+this.name);
    $(this).attr("data-url", parent.pageContext+"/orgFee/" + this.id);
    parent.addTab($(this));

});
$(document).on("click",".pro",function(){
    $(this).find("cite").text("县市_"+this.name);
    $(this).attr("data-url", parent.pageContext+"/org/province/" + this.id);
    parent.addTab($(this));

});
$(document).on("click",".tu",function(){
    $(this).find("cite").text("折线图_"+this.name);
    $(this).attr("data-url", parent.pageContext+"/province/day/" + this.id);
    parent.addTab($(this));

});
$(document).on("click",".forecast",function(){
    $(this).find("cite").text("手续费预估_"+this.name);
    $(this).attr("data-url", parent.pageContext+"/forecast/" + this.id);
    parent.addTab($(this));

});
$(document).on("click",".refresh",function(){
	    		  $.ajax({
	    			url: parent.pageContext +"/org/refresh",
	    			type:"get",
	    			success:function(result){
	    			if(result.code==0){
	    				window.location.reload()
	    			}else(
	    					layer.msg("刷新失败"))
	    				}   									
	    		   })
	    	});
$(document).on("click",".tips",function(){
	var name=this.name;
	 layer.msg(name)
});