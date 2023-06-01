
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách sản phẩm</h1>
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

			<table class="category-table">
				<thead>
					<tr>
						<th>Ảnh sản phẩm</th>
						<th>Mã sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Dánh giá sản phẩm</th>
						<th>Giá sản phẩm</th>
						<th>Số lượng sản phẩm</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct}">
						<tr>
						
							<td><img src="/templates/images/${product.image}" alt="Product Image"></td>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.description}</td>
							<td>${product.price}</td>
							<td>${product.number}</td>
							
							
							<td id="edit-cell">
								<a href="edit?idp=${product.id}" class="edit-button" >Sửa</a>
								<c:if test="${product.number == 0}">
									<a href="delete?idp=${product.id}" class="edit-button" >Xóa</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<!-- các hàng khác ở đây -->
				</tbody>
			</table>
		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
	<script>
    function edit() {
        window.location.href = "/admin/category/edit?idc=${category.id}"; // Thay đổi link cần chuyển hướng tới
    }
    function delete1() {
        window.location.href = "http://example.com/delete"; // Thay đổi link cần chuyển hướng tới
    }
</script>
</main>