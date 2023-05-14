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
									Đăng kí tài khoản <strong>PhonesShop</strong>
								</h3>

							</div>
							<form:form action="signup" method="post" modelAttribute="account">

								<div class="form-group first">
									<label for="username">Tài Khoản</label>

									<form:input path="username" type="text" class="form-control" name =""
										id="username" />
									<form:errors path="username" cssClass="text-danger" />
									<p class="error" style="color: red; margin-left: 10px">										
													${errorun}										
									</p>
								</div>

								<div class="form-group last mb-4">
									<label for="email">Email</label>
									<form:input path="email" type="email" class="form-control"
										id="email" />
									
									<p class="error" style="color: red; margin-left: 10px">										
													${errorem}										
									</p>
	
						
								</div>

								<div class="form-group last mb-4">
									<label for="password">Mật Khẩu</label>
									<form:input path="pasword" type="password" class="form-control"
										id="password" />
									
									<p class="error" style="color: red; margin-left: 10px">										
													${errorpw}										
									</p>
								</div>

								<div class="form-group last mb-4">
									<label for="password">Xác nhận mật khẩu</label> <input
										name="passwordConfirm" type="password" class="form-control"
										id="passwordConfirm" />
									<p class="error" style="color: red; margin-left: 10px">
										<c:if test="${checkPassword}">
													${error}
										</c:if>
									</p>

								</div>
								<p class="error" style="color: red; margin-left: 10px">
										<c:if test="${check}">
													${message}
										</c:if>
									</p>
								
								<input type="submit" value="Đăng Kí"
									class="btn text-white btn-block btn-primary">

							</form:form>
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