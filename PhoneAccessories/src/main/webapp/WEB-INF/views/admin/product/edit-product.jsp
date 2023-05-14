
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Chỉnh sửa sản phẩm</h1>
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
			<div class="col-md-6">
				<h2 class="section-title">Chỉnh sửa sản phẩm</h2>
				<form:form method="post" action="edit?idp=${product.id}" modelAttribute="product" enctype="multipart/form-data">
					
					<div class="form-group">
										<label for="exampleInputFile">File hình ảnh mới</label>
										<div class="input-group">
											<div class="custom-file">
												<input type="file" name="avatar" id="exampleInputFile">
											</div>
										</div>
									</div>
									<c:if test="${error != ''}">
										<span>${error}</span>
									</c:if>
                
					<div class="form-group">
						<label for="product-name">tên sản phẩm mới:</label>
						<form:input path="name" type="text"
							class="form-control"  name="name" />
						
					</div>
					<div class="form-group">
						<label for="product-description">Mô tả mới:</label> 
						<form:input path="description" type="text"
							class="form-control"  name="description"
							/>
						
					</div>
					
					<div class="form-group">
						<label for="product-price">Giá mới:</label> 
						<form:input path="price" type="text"
							class="form-control"  name="price"
							/>
						
					</div>
					
					<div class="form-group" style="display: flex;flex-direction: column;">
				<label for="exampleInputEmail1">Loại sản phẩm mới</label>
					<form:select style="height: 40px;font-size: 20px;" path="category.id" items="${categorys}" itemLabel="id" itemValue="id"></form:select>
                  </div>
                  <p>${message}</p>
					<button type="submit" class="btn btn-primary">Lưu</button>
					<a href="#" class="btn btn-default">Hủy</a>
				
				</form:form>
			</div>
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

.col-md-6 form {
    max-width: 500px; /* Giới hạn chiều rộng của form là 500px */
    margin: 0 auto; /* Căn giữa form */
}
</style>

</main>