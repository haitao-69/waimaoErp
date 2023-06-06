function login(){
    $.ajax(
		{
			type:"post",
			dataType:"json",
			url:"http://localhost:9000/waimaoErp/api/v1/login",
			data:{
				user_name:$("#username").val(),
                psw:$("#password").val()
			},
			success:function(result){ //当返回结果的http响应码为200时
				let code = result.code;
                if(code == 1000){ //代表登录成功
                    alert(result.msg);
                    window.localStorage.setItem("LS_USERNAME",$("#username").val());
                    window.location.href = "index.html";
                }else if(code == 1002){
                    alert(result.msg);
                }
			},
			error:function(result){ //当返回结果的http响应码为500时
				alert("登录失败，服务器程序出现错误");
                console.log(result);
			}
		}
	);
}