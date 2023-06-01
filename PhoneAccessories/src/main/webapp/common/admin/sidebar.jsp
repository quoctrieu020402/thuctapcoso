<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="phoneaccessories.Utils.SecurityUtils"%>
<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link " href="index.html">
				<i class="bi bi-grid"></i> <span>Dashboard</span>
		</a></li>
		<!-- End Dashboard Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-menu-button-wide"></i><span>Danh Mục Sản Phẩm</span><i
				class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="components-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="/admin/category/list"> <i class="bi bi-circle"></i><span>Danh
							Sách</span>
				</a></li>
				<li><a href="/admin/category/add"> <i class="bi bi-circle"></i><span>Thêm</span>
				</a></li>
			</ul></li>
		<!-- End Components Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#"> <i
				class="bi bi-journal-text"></i><span>Sản Phẩm</span><i
				class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="forms-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="/admin/product/list"> <i class="bi bi-circle"></i><span>
							Danh sách sản phẩm</span>
				</a></li>

				<li><a href="/admin/product/add"> <i class="bi bi-circle"></i><span>
							Thêm sản phẩm</span>
				</a></li>

			</ul></li>
		<!-- End Forms Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-layout-text-window-reverse"></i><span>Phiếu
					Nhập</span><i class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="tables-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="/admin/receipt/list"> <i class="bi bi-circle"></i><span>
							Danh sách phiếu nhập</span>
				</a></li>
				<li><a href="/admin/receipt/add"> <i class="bi bi-circle"></i><span>
							Thêm phiếu nhập</span>
				</a></li>
			</ul></li>


		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-layout-text-window-reverse"></i><span>Phiếu
					Đặt</span><i class="bi bi-chevron-down ms-auto"></i>
		</a> <!-- #tables-nav  tables-nav-->
			<ul id="tables-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="/admin/order/list"> <i class="bi bi-circle"></i><span>
							Danh sách </span>
				</a></li>
				
			</ul></li>

		<!-- End Tables Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-bar-chart"></i><span>Nhà Cung Cấp</span><i
				class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="charts-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="/admin/supplier/list"> <i class="bi bi-circle"></i><span>Danh sách</span>
				</a></li>
				<li><a href="/admin/supplier/add"> <i
						class="bi bi-circle"></i><span>Thêm </span>
				</a></li>
				
			</ul></li>
		<!-- End Charts Nav -->

		<c:if
			test='true'>
			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-gem"></i><span>Quản lí tài khoản</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="icons-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<li><a href="/admin/staff/register"> <i
							class="bi bi-circle"></i><span>Thêm nhân viên</span>
					</a></li>
					<li><a href="/admin/staff/list"> <i
							class="bi bi-circle"></i><span>Danh sách nhân viên</span>
					</a></li>
					<li><a href="/admin/user/list"> <i
							class="bi bi-circle"></i><span>Danh sách khách hàng</span>
					</a></li>
					
				</ul></li>
		</c:if>
		<!-- End Icons Nav -->

		<li class="nav-heading">Pages</li>

		<li class="nav-item"><a class="nav-link collapsed"
			href="users-profile.html"> <i class="bi bi-person"></i> <span>Profile</span>
		</a></li>
		<!-- End Profile Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-faq.html"> <i class="bi bi-question-circle"></i> <span>F.A.Q</span>
		</a></li>
		<!-- End F.A.Q Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-contact.html"> <i class="bi bi-envelope"></i> <span>Contact</span>
		</a></li>
		<!-- End Contact Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-register.html"> <i class="bi bi-card-list"></i> <span>Register</span>
		</a></li>
		<!-- End Register Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-login.html"> <i class="bi bi-box-arrow-in-right"></i>
				<span>Login</span>
		</a></li>
		<!-- End Login Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-error-404.html"> <i class="bi bi-dash-circle"></i> <span>Error
					404</span>
		</a></li>
		<!-- End Error 404 Page Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="pages-blank.html"> <i class="bi bi-file-earmark"></i> <span>Blank</span>
		</a></li>
		<!-- End Blank Page Nav -->

	</ul>

</aside>