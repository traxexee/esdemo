
layui.use(['layer', 'form'], function(){
	  var layer = layui.layer
	});

$(document).on("click",".updateState",function(){
	var id = this.id 
	layer.confirm('确定已经提现成功', {icon: 3, title:'提示'}, function(index){
		  //do something
		  $.ajax({
  			url: parent.pageContext +"/orgFee/id/"+id+"/successState",
  			type:"PUT",
  			success:function(result){
  			if(result.code==0){
  				window.location.reload()
  			}else(
  					layer.msg("保存失败"))
  				}
  									
  		   })
		  layer.close(index);
		  window.close();
		});
	});

