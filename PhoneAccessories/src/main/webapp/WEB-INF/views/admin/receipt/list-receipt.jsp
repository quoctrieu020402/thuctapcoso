
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
					<tr >
						<th style="width: 12%;">Mã phiếu nhập</th>
						<th>Ngày nhập</th>
						<th>Nhân viên lập</th>
						<th>Nhà cung cấp</th>
						<th>Trạng thái</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="receipt" items="${listReceipt}">
						<tr>
							<td style="width: 12%;" >${receipt.id}</td>
							<td><fmt:formatDate value="${receipt.date}"
									pattern="dd/MM/yyyy" /></td>
							<td>${receipt.staff.account.username}</td>
							<td>${receipt.supplier.name}</td>
							<td>${receipt.status}</td>
							<td id="edit-cell">
							<c:choose>
									<c:when test="${empty receipt.listReceiptDetail}">
										<a 
											href="/admin/receipt-detail/quantity?idr=${receipt.id}"
											class="edit-button">Thêm chi tiết phiếu nhập</a>
									</c:when>
									<c:otherwise>
										<a href="/admin/receipt-detail/list?idr=${receipt.id}"
											class="edit-button">Xem chi tiết nhập</a>
									</c:otherwise>
								</c:choose> 
								<c:if test="${receipt.status == 0 || receipt.status == 2}">
									<a style="background-color: red;" href="delete?idr=${receipt.id}" class="edit-button">Xóa</a>
								</c:if>
								<c:if test="${receipt.status == 1}">
									<a style="float: right;margin-left: -30px" href="/admin/receipt/success?idr=${receipt.id}"
												class="edit-button">Hoàn Thành</a>
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

</main>