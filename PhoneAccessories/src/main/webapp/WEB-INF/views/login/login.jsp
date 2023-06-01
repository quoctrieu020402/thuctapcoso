<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="/templates/login/access/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="/templates/login/access/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/templates/login/access/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="/templates/login/access/css/style.css">

<title>Login #8</title>
</head>
<body>



	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-md-6 order-md-2">
					<img src="/templates/login/access/images/undraw_file_sync_ot38.svg"
						alt="Image" class="img-fluid">
				</div>
				<div class="col-md-6 contents">
					<div class="row justify-content-center">
						<div class="col-md-8">
							<div class="mb-4">
								<h3>
									Chào mừng đến với <strong>PhonesShop</strong>
								</h3>

							</div>
							<c:if test="${param.incorrectAccount != null}">
								<div class="alert alert-danger">Tài khoản hoặc mật khẩu không chính xác
									</div>
							</c:if>
							<form action="j_spring_security_check" method="post">

								<div class="form-group first">
									<label for="username">Tài Khoản</label> <input type="text"
										class="form-control" id="username" name="j_username" />

								</div>
								<div class="form-group last mb-4">
									<label for="password">Mật Khẩu</label> <input type="password"
										class="form-control" id="password" name="j_password" />

									<p class="error" style="color: red; margin-left: 10px">
										${error}</p>
								</div>

								<div class="d-flex mb-5 align-items-center">
									<label class="control control--checkbox mb-0"><span
										class="caption">Ghi nhớ </span> <input type="checkbox"
										checked="checked" />
										<div class="control__indicator"></div> </label> <span class="ml-auto"><a
										href="#" class="forgot-pass">Quên mật khẩu</a></span>
								</div>

								<input type="submit" value="Đăng Nhập"
									class="btn text-white btn-block btn-primary"> <a
									href="/signin" class="btn text-white btn-block btn-primary">Đăng
									kí</a> <span class="d-block text-left my-4 text-muted"> Hoặc
									đăng nhập với </span>

								<div class="social-login">
									<a href="#" class="facebook"> <span
										class="icon-facebook mr-3"></span>
									</a> <a href="#" class="twitter"> <span
										class="icon-twitter mr-3"></span>
									</a> <a href="#" class="google"> <span class="icon-google mr-3"></span>
									</a>
								</div>
							</form>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>


	<script src="/templates/login/access/js/jquery-3.3.1.min.js"></script>
	<script src="/templates/login/access/js/popper.min.js"></script>
	<script src="/templates/login/access/js/bootstrap.min.js"></script>
	<script src="/templates/login/access/js/main.js"></script>
</body>
</html>