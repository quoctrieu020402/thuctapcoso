
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

			<h2 class="section-title">Thêm sản phẩm mới</h2>

			<form:form modelAttribute="addProdcut" method="POST"
				enctype="multipart/form-data"
				style="border: 1px solid #ccc; padding: 20px ;">
				<div class="card-body">

					<div class="form-group">
						<label for="exampleInputFile">File hình ảnh</label>
						<div class="input-group">
							<div class="custom-file">
								<input type="file" name="avatar" id="exampleInputFile">
							</div>
						</div>
					</div>
					<c:if test="${error != ''}">
						<span>${error}</span>
					</c:if>
					<c:if test="${imgnull != null}">
						<div class="alert alert-danger">${imgnull}</div>
					</c:if>

					<spring:bind path="id">
						<div class="form-group">
							<label for="exampleInputEmail1">Mã sản phẩm</label>
							<form:input type="text" class="form-control" path="id" />
						</div>
						<c:if test="${idnull != null}">
							<div class="alert alert-danger">${idnull}</div>
						</c:if>
					</spring:bind>

					<spring:bind path="name">
						<div class="form-group">
							<label for="exampleInputEmail1">Tên sản phẩm</label>
							<form:input type="text" class="form-control" path="name" />
						</div>
						<c:if test="${namenull != null}">
						<div class="alert alert-danger">${namenull}</div>
					</c:if>
					</spring:bind>

					<spring:bind path="description">
						<div class="form-group">
							<label for="exampleInputEmail1">Mô tả</label>
							<form:textarea class="form-control" path="description" />
						</div>
						
					</spring:bind>

					<spring:bind path="price">
						<div class="form-group">
							<label for="exampleInputEmail1">Giá</label>
							<form:input type="text" class="form-control" path="price" />
						</div>

					</spring:bind>



					<div class="form-group"
						style="display: flex; flex-direction: column;">
						<label for="exampleInputEmail1">Loại sản phẩm</label>
						<form:select style="height: 40px;font-size: 20px;"
							path="category.id" items="${categorys}" itemLabel="id"
							itemValue="id"></form:select>
					</div>



				</div>
				<!-- /.card-body -->
				<c:if test="${not empty success}">
					<c:if test="${success != null}">
						<div class="alert alert-success">${success}</div>
					</c:if>
				</c:if>
				<div class="button">
					<button type="submit" class="btn btn-primary">Tạo</button>
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