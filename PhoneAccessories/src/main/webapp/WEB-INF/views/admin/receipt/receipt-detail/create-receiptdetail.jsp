
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

			<form:form modelAttribute="chiTietPhieuNhap" method="POST"
				action="/admin/receipt-detail/create?idr=${idr}">
				<form:errors path="*" cssClass="error" />

				<table class="category-table" id="chiTietPhieuNhap">
					<thead>
						<tr>
							<th>Mã sản phẩm</th>
							<th>Số lượng</th>
							<th>Giá Nhập</th>
							<th>Tổng Tiền</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="receiptDetail"
							items="${chiTietPhieuNhap.getListReceiptDetail()}"
							varStatus="loop">
							<tr>
								<td><div class="form-group">
										<form:select class="custom-select"
											path="listReceiptDetail[${loop.index}].product.id"
											items="${products}" itemLabel="name" itemValue="id"></form:select>
									</div></td>
									
								<td><div class="form-group">
										<form:input class="form-control" type="number"
											path="listReceiptDetail[${loop.index}].quantity" />
									</div></td>
								
								<td><div class="form-group">
										<form:input class="form-control" type="number"
											path="listReceiptDetail[${loop.index}].price" />
									</div></td>
								<td><div class="form-group">
										
									</div>${receiptDetail.quantity*receiptDetail.price}</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td>Tổng phiếu nhập:</td>
							<td>${sum}</td>
							
						</tr>
					</tbody>
				</table>

				<br>

				<button type="submit">Lưu</button>
			</form:form>


		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
	<script>
		function themSanPham() {
			var table = document.getElementById("chiTietPhieuNhap");
			var row = table.insertRow();
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var input1 = document.createElement("input");
			input1.type = "text";
			input1.name = "chiTietPhieuNhapList[" + table.rows.length
					+ "].product.id";
			cell1.appendChild(input1);
			var input2 = document.createElement("input");
			input2.type = "number";
			input2.name = "chiTietPhieuNhapList[" + table.rows.length
					+ "].quantity";
			cell2.appendChild(input2);
			var button = document.createElement("button");
			button.type = "button";
			button.onclick = function() {
				xoaSanPham(row.rowIndex);
			};
			button.innerHTML = "Xóa";
			cell3.appendChild(button);
		}
	</script>
</main>