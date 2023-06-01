
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Thêm Danh Mục</h1>
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

			<h2 class="section-title">Thêm danh mục sản phẩm mới</h2>
			<form:form class="form" action="add" method="post" modelAttribute="addcategory">

				<div class="form-group">
					<label class="form-label" for="categoryCode">Mã danh mục:</label>
	
					<form:input path="id" class="form-input" type="text"
						id="id"/>
						<c:if test="${idnull != null}">
							<div class="alert alert-danger">
								${idnull}
							</div>
						</c:if>

				</div>
				<div class="form-group">
					<label class="form-label" for="categoryName">Tên danh mục:</label>
					<form:input path="name" class="form-input" type="text"
						id="name"  />
					<c:if test="${namenull != null}">
							<div class="alert alert-danger">
								${namenull}
							</div>
					</c:if>
				</div>
				<c:if test="${success != null}">
							<div class="alert alert-success">
								${success}
							</div>
						</c:if>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Thêm mới</button>
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

.btn {
	display: inline-block;
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border-radius: 5px;
	border: none;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.2s ease-in-out;
}

.btn:hover {
	background-color: #0069d9;
}

.section-title {
	margin-bottom: 30px;
	text-align: center;
}
</style>

</main>