
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

		
			<table>
				<tr>
					<th style="width: 40%;" >Tên thành phần</th>
					<th >Thông số</th>
				</tr>
				<tr>
					<td style="width: 40%;" >Màn hình</td>
					<td>${config.screenSize} </td>
				</tr>
				<tr>
					<td style="width: 40%;" >Vi xử lý</td>
					<td>${config.resolution}</td>
				</tr>
				<tr>
					<td style="width: 40%;" >Bộ nhớ</td>
					<td>${config.ram}</td>
				</tr>
				<tr>
					<td style="width: 40%;" >Lưu trữ</td>
					<td>${config.rom}</td>
				</tr>
				<tr>
					<td style="width: 40%;">Card đồ họa</td>
					<td>${config.cardGraphic}</td>
				</tr>
				<tr>
					<td style="width: 40%;">Hệ điều hành</td>
					<td>${config.system}</td>
				</tr>
				<tr>
					<td style="width: 40%;" >Pin</td>
					<td>${config.pin}</td>
				</tr>
			</table>
		

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
</main>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

h1 {
	color: #333;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-top: 20px;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 8px;
	width: 40%;
}

table th {
	background-color: #f2f2f2;
	text-align: left;
	
}

table tr:nth-child(even) {
	background-color: #f9f9f9;
}

table tr:hover {
	background-color: #f5f5f5;
}
</style>


