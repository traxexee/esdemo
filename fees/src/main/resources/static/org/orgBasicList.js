$(document).ready( function () {
    $('#Table').DataTable();
} );
layui.use(['layer', 'form'], function(){
	  var layer = layui.layer


	});

$(document).on("click",".updateState",function(){
	var name= this.name;
	var id = this.id 
	layer.confirm('确定'+name+'已经提现了', {icon: 3, title:'提示'}, function(index){
		  //do something
		  $.ajax({
  			url: parent.pageContext +"/orgFee/id/"+id+"/state",
  			type:"PUT",
  			success:function(result){
  			if(result.code==0){
  				window.location.reload()
  			}else(
  					layer.msg("保存失败"))
  				}
  									
  		   })
		  layer.close(index);
		});
	});

$(document).on("click",".details",function(){
   var name= this.name;
   var id = this.id;
   var value= this.data;
    layer.prompt({
    	  formType: 2,
    	  title: name,
    	  value: '',
    	}, function(value, index, elem){

    		  $.ajax({
    			url: parent.pageContext +"/orgFee/id/"+id+"/remark/"+value,
    			type:"PUT",
    			success:function(result){
    			if(result.code==0){
    				window.location.reload()
    			}else(
    					layer.msg("保存失败"))
    				}
    									
    		   })
    	  layer.close(index);
    	});
});
$(document).on("click",".mch_details",function(){
	console.log("title:"+this.title);
    $(this).find("cite").text("资金详请_"+this.name+"_"+this.id);
    $(this).attr("data-url", parent.pageContext+"/orgDetail/mchId/" + this.id+"/billDate/"+this.name+"/id/"+this.title);
    parent.addTab($(this));
});