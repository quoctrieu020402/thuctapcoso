
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Thêm cấu hình</h1>
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

			<h2 class="section-title">Thêm sản phẩm mới</h2>

			<form:form modelAttribute="addConfig" method="POST"
				enctype="multipart/form-data"
				style="border: 1px solid #ccc; padding: 20px ;">
				<div class="card-body">

				
					<c:if test="${error != ''}">
						<span>${error}</span>
					</c:if>
					<c:if test="${imgnull != null}">
						<div class="alert alert-danger">${imgnull}</div>
					</c:if>

					<spring:bind path="screenSize">
						<div class="form-group">
							<label for="exampleInputEmail1">Kích thước màn hình</label>
							<form:input type="text" class="form-control" path="screenSize" />
						</div>
						<c:if test="${idnull != null}">
							<div class="alert alert-danger">${idnull}</div>
						</c:if>
					</spring:bind>

					<spring:bind path="system">
						<div class="form-group">
							<label for="exampleInputEmail1">Hệ điều hành</label>
							<form:input type="text" class="form-control" path="system" />
						</div>
						<c:if test="${namenull != null}">
						<div class="alert alert-danger">${namenull}</div>
					</c:if>
					</spring:bind>

					<spring:bind path="ram">
						<div class="form-group">
							<label for="exampleInputEmail1">Ram</label>
							<form:input class="form-control" path="ram" />
						</div>
						
					</spring:bind>
					
					<spring:bind path="rom">
						<div class="form-group">
							<label for="exampleInputEmail1">Rom</label>
							<form:input class="form-control" path="rom" />
						</div>
						
					</spring:bind>

					<spring:bind path="resolution">
						<div class="form-group">
							<label for="exampleInputEmail1">Độ phân giải</label>
							<form:input type="text" class="form-control" path="resolution" />
						</div>

					</spring:bind>
					
					<spring:bind path="cardGraphic">
						<div class="form-group">
							<label for="exampleInputEmail1">Card màn hình</label>
							<form:input type="text" class="form-control" path="cardGraphic" />
						</div>

					</spring:bind>
					
					<spring:bind path="pin">
						<div class="form-group">
							<label for="exampleInputEmail1">Pin</label>
							<form:input type="text" class="form-control" path="pin" />
						</div>

					</spring:bind>

					
					
					

				</div>
				<!-- /.card-body -->
				<c:if test="${not empty success}">
					<c:if test="${success != null}">
						<div class="alert alert-success">${success}</div>
					</c:if>
				</c:if>
				<div class="button">
					<button type="submit" class="btn btn-primary">Thêm</button>
				</div>
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
</style>

</main>