<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post"
		action="/user/profile/update?ids=${account1.id}"
		modelAttribute="account1" enctype="multipart/form-data">
		<div class="row mb-3">
			<label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Hình
				ảnh</label>
			<div class="col-md-8 col-lg-9">
				<input name="avatar" type="file" class="form-control">

			</div>
		</div>

		<hr>
		<table>
			<tr>
				<th colspan="3">THÔNG TIN KHÁCH HÀNG</th>
			</tr>
			<tr>
				<td>Tài khoản:</td>
				<td><form:input path="account.username" type="text"></form:input></td>

			</tr>


			<tr>
				<td>Họ:</td>
				<td><form:input path="surname" type="text"></form:input></td>

			</tr>
			<tr>
				<td>Tên:</td>
				<td><form:input path="name" type="text"></form:input></td>

			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="account.email" type="text"></form:input></td>

			</tr>
			<tr>
				<td colspan="3" style="padding: 5px; border-top: 2px solid #ccc;"></td>
			</tr>

		</table>
		<div>
			<button type="submit">Cập nhật thông tin</button>
		</div>
	</form:form>
	<!-- End Profile Edit Form -->

	<div>
		<c:if test="${order.isEmpty()== true }">
			<p>Bạn chưa có đơn hàng nào</p>
		</c:if>
		<c:if test="${order.isEmpty() == false }">
			<c:forEach items="${order }" var="order">
				<table>
					<tr>
						<td>Mã phiếu đặt:</td>
						<td>${order.id }</td>

					</tr>


					<tr>
						<td>Trạng thái:</td>
						<td>${order.status }</td>

					</tr>
					<tr>
						<td>Địa chỉ:</td>
						<td>${order.address }</td>

					</tr>
					<tr>
						<td>Ngày lập:</td>
						<td>${order.date }</td>

					</tr>
					<tr>
						<td>Ghi chú:</td>
						<td>${order.note }</td>

					</tr>

					<tr>
						<td colspan="3" style="padding: 5px; border-top: 2px solid #ccc;"></td>
					</tr>

				</table>
			</c:forEach>

		</c:if>
	</div>

	<div class="listDonHang"></div>

	<script>
		addContainTaiKhoan();
		addPlc();
	</script>

	<div class="footer">
		<script>
			addFooter();
		</script>
	</div>

	<i class="fa fa-arrow-up" id="goto-top-page" onclick="gotoTop()"></i>
</body>
</html>