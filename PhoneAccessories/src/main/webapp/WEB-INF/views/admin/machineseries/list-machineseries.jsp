
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách dòng máy</h1>
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
						<th>Mã dòng máy</th>
						<th>Tên dòng máy</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="machineseries" items="${listMachineSeries}">
						<tr>
							<td>${machineseries.id}</td>
							<td>${machineseries.name}</td>
							<td style="display: flex;">
								<div style="width: 10%;">
									<a href="edit?idm=${machineseries.id}" class="edit-button">Sửa</a>
								</div>
								<div style="width: 10%; margin-left: 20px">
									<a href="delete?idm=${machineseries.id}" class="edit-button">Xóa</a>
								</div>
								<c:if test="${message != null && idc == machineseries.id}">
									<div style="width: 60%;">
										<div class="alert alert-danger">${message}</div>
									</div>
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