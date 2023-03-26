<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/png"
	href="template/web/images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="template/web/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="template/web/css/util.css" />
<link rel="stylesheet" type="text/css" href="template/web/css/main.css" />

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" name="LoginForm" action="<c:url value='j_spring_security_check' /url>" method="post">
					<div class="logo login100-form-title">
						<a href="#"> <img src="template/web/images/logo.jpg" alt="" /></a>
					</div>

					<div class="text-login">
						<span> ĐĂNG NHẬP </span>
					</div>
					
					<div>
						<span style="color: red"><c:if test="${not empty error}">$error</c:if></span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="username"
							placeholder="Tên đăng nhập" /> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" name="password"
							placeholder="Mật khẩu" /> <span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-12">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox"
								name="remember-me" /> <label class="label-checkbox100"
								for="ckb1"> Nhớ mật khẩu </label>
						</div>

						<div>
							<a href="#" class="txt1"> Quên mật khẩu? </a>
						</div>
					</div>

					<div class="register p-b-20">
						<a href="#">Đăng ký tài khoản</a>
					</div>

					<div class="container-login100-form-btn">
						<input type="submit" value="Login" class="login100-form-btn">Đăng nhập</input>
					</div>

					<div class="text-center p-t-20 p-b-20">
						<span class="txt2"> Hoặc </span>
					</div>

					<div class="login100-form-social flex-c-m">
						<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
							<i class="fa fa-facebook-f" aria-hidden="true"></i>
						</a> <a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
					</div>
				</form>

				<div class="login100-more"
					style="background-image: url('template/web/images/login-banner.jpg')">
				</div>

			</div>
		</div>
	</div>
</body>
</html>