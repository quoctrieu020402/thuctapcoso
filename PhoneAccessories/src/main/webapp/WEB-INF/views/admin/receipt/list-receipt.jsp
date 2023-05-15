
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
						<th>Mã phiếu nhập</th>
						<th>Ngày nhập</th>
						<th>Nhà cung cấp</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="receipt" items="${listReceipt}">
						<tr>
							<td>${receipt.id}</td>
							<td><fmt:formatDate value="${receipt.date}" pattern="dd/MM/yyyy" /></td>
							<td>${receipt.supplier.name}</td>
							<td id="edit-cell">
								
								
								
								<c:choose>
									<c:when test="false">
									<a  hidden="True" href="/admin/receipt-detail/quantity?idr=${receipt.id}" class="edit-button" >Thêm chi tiết phiếu nhập</a>
									</c:when>
								<c:otherwise>
								<a  	 href="/admin/receipt-detail/quantity?idr=${receipt.id}" class="edit-button" >Thêm chi tiết phiếu nhập</a>
								</c:otherwise>
								
								
								</c:choose>
								
								
								<a href="edit?idc=${receipt.id}" class="edit-button" >Sửa</a>
								<a href="delete?idc=${receipt.id}" class="edit-button" >Xóa</a>

								
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
	
</main>