$(function(){
	/* 关闭按钮*/
	$(".login_layer .login-panel .login-panel-close").click(function(){
		$(".login_layer").css("display","none");
		$(".login_layer .login-box .login-panel-title").html("");
		$(".login_layer .login-box .login-panel-hint").html("");
		$(".login_layer .login-panel .login_panel_op").html("");
	});
	
	/*登录*/
	$(".header .btn-login").click(function(){
		$(".login_layer .login-box .login-panel-title").html("手机快捷登录");
		$(".login_layer .login-box .login-panel-hint").html("别担心，无账号自动注册不会导致手机号被泄露");
		$(".login_layer .login-panel .login_panel_op").html("登录");
		$(".login_layer .login-panel .login_panel_change_login_type").css("display","block");
		$(".login_layer .login-panel form .form_input_item.password").css("display","none");
		$(".login_layer .login-panel form .login_protocol").css("display","none");
		$(".login_layer").css("display","block");
	});
	/*注册*/
	$(".header .btn-register").click(function(){
		$(".login_layer .login-box .login-panel-title").html("手机号码注册");
		$(".login_layer .login-box .login-panel-hint").html("<div class='login-panel-go'>已有账号？<a class='btn-login' href='#'>去登录</a></div>");		
		$(".login_layer .login-panel form .form_input_item.picverifycode").css("display","block");
		$(".login_layer .login-panel form .form_input_item.messageverifycode").css("display","block");
		$(".login_layer .login-panel form .form_input_item.password").css("display","block");
		$(".login_layer .login-panel form .login_protocol").css("display","block");		
		$(".login_layer .login-panel .login_remember").css("display","none");
		$(".login_layer").css("display","block");
	});
	/*账号密码登录*/
	$(document).on("click",".login_layer .login-panel .change_login_type.common",function(){
		$(".login_layer .login-box .login-panel-title").html("账号密码登录");
		$(".login_layer .login-box .login-panel-hint").html("");
		$(".login_layer .login-panel .login_panel_op").html("登录");
		$(".login_layer .login-panel .login_panel_forget_password").html("<a href='#'>忘记密码</a>");
		$(".login_layer .login-panel form .form_input_item.password").css("display","block");
		$(".login_layer .login-panel .login_remember").css("display","block");
		$(".login_layer .login-panel .login_panel_forget_password").css("display","block");		
		$(".login_layer .login-panel form .form_input_item.picverifycode").css("display","none");
		$(".login_layer .login-panel form .form_input_item.messageverifycode").css("display","none");
		$(".login_layer .login-panel .longin_type_bottom_text").css("display","none");
        
		$(this).text("手机快捷登录");
		$(this).addClass("phone");
		$(this).removeClass("common");
	});
	/*手机快捷登录*/
	$(document).on("click",".login_layer .login-panel .change_login_type.phone,.login_layer .login-panel .btn-login",function(){
		$(".login_layer .login-box .login-panel-title").html("手机快捷登录");
		$(".login_layer .login-box .login-panel-hint").html("别担心，无账号自动注册不会导致手机号被泄露");
		$(".login_layer .login-panel .login_panel_op").html("登录");
		$(".login_layer .login-panel .login_panel_forget_password").html("");
		$(".login_layer .login-panel form .form_input_item.picverifycode").css("display","block");
		$(".login_layer .login-panel form .form_input_item.messageverifycode").css("display","block");		
		$(".login_layer .login-panel .login_remember").css("display","block");	
		$(".login_layer .login-panel .longin_type_bottom_text").css("display","block");
		$(".login_layer .login-panel .login_panel_change_login_type").css("display","block");		
		$(".login_layer .login-panel form .form_input_item.password").css("display","none");
		$(".login_layer .login-panel form .form_input_item.setpassword").css("display","none");
		$(".login_layer .login-panel form .login_protocol").css("display","none");		
		$(".login_layer .login-panel .change_login_type").text("账号密码登录");
		$(this).removeClass("phone");
		$(this).addClass("common");
	})
	/**找回密码*/
	$(".login_layer .login-panel .login_panel_forget_password").click(function(){
		$(".login_layer .login-box .login-panel-title").html("找回密码");
		$(".login_layer .login-box .login-panel-hint").html("");
		$(".login_layer .login-panel .login_panel_op").html("修改密码");		
		$(".login_layer .login-panel form .form_input_item.picverifycode").css("display","block");
		$(".login_layer .login-panel form .form_input_item.messageverifycode").css("display","block");
		$(".login_layer .login-panel form .form_input_item.setpassword").css("display","block");
		$(".login_layer .login-panel .login_remember").css("display","none");		
		$(".login_layer .login-panel .longin_type_bottom_text").css("display","none");
		$(".login_layer .login-panel form .form_input_item.password").css("display","none");
	});
	
	
	
});


		var postAjax = function(url,postData,successFunction,option){
			var returnFlag=false;
			var defaultOptions={
				type:"post",
				async:true,
				errorFunction:errorFunction,
				successArguments: "",
				errorArguments: "",
				contentType:"application/json; charset=utf-8",/*传入数据类型*/
				dataType:"json"/* 返回的数据类型*/
			};			
			var currentOptions = $.extend(defaultOptions, options);//https://www.runoob.com/jquery/misc-extend.html
			$.ajax({
				type:currentOptions.type,
				url:url,
				data:postData,
				async:currentOptions.async,
				contentType:currentOptions.contentType,
				dataTyp:currentOptions.dataType,
				beforeSend:function(){
					loading();
				},
				success:function(resultData){
					if(resultData&&isSuccess(resultData.resultCode)){
						if(defaultOptions&&defaultOptions.successArguments){
							sucessFunction(resultData,defaultOptions.successArguments);
						}else{
							sucessFunction(resultData);
						}
						returnFlag = true;
					}else{
						defaultOptions.errorFunction(resultData);
						returnFlag = false;
					}
					
					
				},
				complete:function(){
					deleteLoading();
				},
				error:function(result){
					deleteLoading();
				},
				
				
			});
		}
		function loading(){
		
		}
		function deleteLoading(){
		
		}
		function isSuccess(resultCode){
		return ("10"===resultCode)
		}
		function errorFunction(resultData) {
		showMessage(resultData);
		}
		
		function showMessage(resultData) {
		alert(resultData.description);
		}
