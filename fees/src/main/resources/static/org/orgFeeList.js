$(document).ready( function () {
    $('#Table').DataTable({
    	
    	  "iDisplayLength": 25,
		   "order": [[ 0, "desc" ]]	
    });
} );
layui.use(['layer', 'form'], function(){
	  var layer = layui.layer


	});

$(document).on("click",".details",function(){
   var name= this.name;
   var id = this.id;
    layer.prompt({
    	  formType: 2,
    	  title: name,
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
