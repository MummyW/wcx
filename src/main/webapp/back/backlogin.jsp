<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>问查星登录界面</title>

        <!-- 导入CSS文件 -->
        <!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	<!-- 大标题 -->
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>问查星</strong> 后台管理系统</h1>
                            <div class="description">
                            	<p>
	                            	我们是一个专门支持用户做网上问卷调查的网站，对于做问卷调查，我们是认真的 . . .  
                                    <br/>
                                    customize and use it as you like!
                            	</p>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 框中内容 -->
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                                	<h3>用户登录</h3>
                            		<p>请您输入您的用户名与密码:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
                            	<!--按钮点击跳转页面 测试为survey.html-->
			                    <form role="form" action="" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">wcxmname</label>
			                        	<input type="text" name="form-username" placeholder="请输入您的用户名（6~10位）..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">wcxmpwd</label>
			                        	<input type="password" name="form-password" placeholder="请输入您的密码..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="button" class="btn" value="登录" onclick="managerLogin()">登录</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>使用第三方登录:</h3>
                        	<div class="social-login-buttons">
                            	<!--跳转三方登录界面-->
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>		<!--使得背景图片按一定规律变换图片-->
    </body>
<script type="text/javascript">
function managerLogin(){
	var wcxmname=$.trim( $("#form-username").val() );
	var wcxmpwd=$.trim( $("#form-password").val() );
	if(wcxmname=="" || wcxmpwd==""){
		alert("账号或密码为空...~")
		return;
	}
	$.post("managerLogin",{wcxmname:wcxmname,wcxmpwd:wcxmpwd},function(data){
		alert(data);
		if(data!=null && data!=""){
			location.href="manager/index.html";
		}else{
			alert("账号或密码错误...")
		}
	},"json");
}
</script>
</html>