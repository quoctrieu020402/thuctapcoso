
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách danh mục</h1>
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
						<th>Mã thể loại</th>
						<th>Tên thể loại</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${listCategory}">
						<tr>
							<td>${category.id}</td>
							<td>${category.name}</td>
							<td id="edit-cell">
								<a href="edit?idc=${category.id}" class="edit-button" >Sửa</a>
								<a href="delete?idc=${category.id}" class="edit-button" >Xóa</a>
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