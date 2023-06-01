
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Chi tiết phiếu đặt</h1>
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

			<div class="user-info">
				<h3>Thông tin khách hàng</h3>
				<div class="user-field">
					<label>Họ tên:</label> <span>${order.user.surname} ${order.user.name}</span>
				</div>
				<div class="user-field">
					<label>Số điện thoại:</label> <span>${order.user.sdt}</span>
				</div>
				<div class="user-field">
					<label>Địa chỉ:</label> <span>${order.user.address}</span>
				</div>
			</div>

			<table class="category-table">
				<thead>
					<tr>
						<th>Sản phẩm</th>
						<th>Số lượng</th>
						<th>Giá sản phẩm</th>
						<th>Tổng giá</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderdetail" items="${listOrderDetail}">
						<tr>
							<td>${orderdetail.product.name}</td>
							<td>${orderdetail.quantity}</td>
							<td>${orderdetail.product.price}</td>
							<td>${orderdetail.product.price*orderdetail.quantity}</td>
						</tr>
					</c:forEach>
					<!-- các hàng khác ở đây -->
				</tbody>
			</table>

			<div style="text-align: right;">
				<a href="/admin/order/list" type="button" class="btn btn-primary"
					style="background-color: #4caf50; color: white; width: 100px; border: none; margin-top: 10px;">Quay
					lại</a>
				<c:if test="${order.status == 'Đang xử lí'}">
					<a href="/admin/order/confirm?ido=${order.id}" type="button"
						class="btn btn-primary"
						style="background-color: #4caf50; color: white; width: 100px; border: none; margin-top: 10px; margin-left: 10px">Xác
						nhận</a>
					<a href="/admin/order/confirm?ido=${order.id}&status=huy"
						type="button" class="btn btn-primary"
						style="background-color: red; color: white; width: 100px; border: none; margin-top: 10px; margin-left: 10px;">Hủy</a>
				</c:if>
			</div>
		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>

</main>

<style>
.user-info {
	border: 1px solid #ddd;
	padding: 20px;
	margin-bottom: 20px;
}

.user-field {
	margin-bottom: 10px;
}

.user-field label {
	font-weight: bold;
}

.user-field span {
	margin-left: 10px;
}
</style>