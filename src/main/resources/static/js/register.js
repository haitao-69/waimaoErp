function reg(){
	// let user_name = $("#user_name");
	$.ajax(
		{
			type:"post",
			dataType:"json",
			url:"http://localhost:9000/waimaoErp/api/v1/users",
			data:{
				user_name:$("#user_name").val(),
				psw:$("#psw").val(),
				address:$("#address").val(),
				phone:$("#phone").val(),
			},
			success:function(result){ //当返回结果的http响应码为200时
				alert(result.msg);
				if(result.code == 1000) //代表注册成功
					window.location.href="login.html";
			},
			error:function(result){ //当返回结果的http响应码为500时
				alert(result.msg);
			}
		}
	);
}