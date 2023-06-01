
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Thêm sản phẩm</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Home</a></li>
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<section class="section dashboard">


		<!-- Left side columns -->

		<div class="row">

			<h2 class="section-title">Thêm nhân viên</h2>

			<form:form action="signup" method="post" modelAttribute="account">

				<div class="form-group first">
					<label for="username">Tài Khoản</label>

					<form:input path="username" type="text" class="form-control"
						name="" id="username" />
					<form:errors path="username" cssClass="text-danger" />

					<c:if test="${checktk}">
						<div class="alert alert-danger">${errorun}</div>
					</c:if>

				</div>

				<div class="form-group last mb-4">
					<label for="email">Email</label>
					<form:input path="email" type="email" class="form-control"
						id="email" />

					<c:if test="${checkemail}">
						<div class="alert alert-danger">${errorem}</div>
					</c:if>

				</div>

				<div class="form-group last mb-4">
					<label for="password">Mật Khẩu</label>
					<form:input path="pasword" type="password" class="form-control"
						id="password" />

					<c:if test="${checkmk}">
						<div class="alert alert-danger">${errorpw}</div>
					</c:if>
				</div>

				<div class="form-group last mb-4">
					<label for="password">Xác nhận mật khẩu</label> <input
						name="passwordConfirm" type="password" class="form-control"
						id="passwordConfirm" />
					<p class="error" style="color: red; margin-left: 10px">
						<c:if test="${checkPassword}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
					</p>

				</div>

				<div class="form-group last mb-4">
					<label for="password">Chọn Quyền</label> <br>
					<div class="radio-option">
						<input type="radio" name="role" value="EMPLOYEE"> Nhân
						viên <input type="radio" name="role" value="ADMIN"> Admin
					</div>
				</div>

				<p class="error" style="color: red; margin-left: 10px">
					<c:if test="${check}">
						<div class="alert alert-success">${message}</div>
					</c:if>
				</p>

				<input type="submit" value="Đăng Kí"
					class="btn text-white btn-block btn-primary">

			</form:form>


		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
	<!-- CSS -->
	<style>
.form {
	max-width: 600px;
	margin: auto;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 20px;
}

.form-label {
	display: block;
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-input {
	display: block;
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.button {
	display: inline-block;
	padding: 10px 20px;
}

.section-title {
	margin-bottom: 30px;
	text-align: center;
}

.row {
	display: flex;
	justify-content: center;
	max-width: 600px;
	margin: 0 auto;
}

.form-group.last.mb-4 .radio-option {
            margin-bottom: 10px;
        }
.radio-option {
            margin-top: 10px;
        }
</style>

</main>