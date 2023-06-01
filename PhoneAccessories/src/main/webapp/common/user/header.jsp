<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="header group">
	<div class="logo">
		<a href="user/product"> <img src="img/logo.jpg"
			alt="Trang chủ Smartphone Store" title="Trang chủ Smartphone Store">
		</a>
	</div>
	<!-- End Logo -->

	
	<div class="content">
		<div class="search-header"
			style="position: relative; left: 162px; top: 1px;">
			<form class="input-search" method="get" action="/user/search">
				<div class="autocomplete">
					<input id="search-box" name="keyword" autocomplete="off" type="text"
						placeholder="Nhập từ khóa tìm kiếm...">
					<button type="submit">
						<i class="fa fa-search"></i> Tìm kiếm
					</button>
				</div>
			</form>
			<!-- End Form search -->

		</div>
		<!-- End Search header -->

		<script type="text/javascript">
			function search() {
				var keyword = document.getElementById("searchInput").value;
				window.location.href = "/search?keyword=" + keyword;
			}
		</script>

		<div class="tools-member">
			<div class="member">
				<security:authorize access="isAnonymous()">
					<a href="/login"> <i class="fa fa-user"></i>Tài khoản
					</a>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<a href="/user/profile"> <i class="fa fa-user"></i>Tài khoản
					</a>
					<div class="menuMember hide">
						<a href="nguoidung.html">Trang người dùng</a> <a
							onclick="if(window.confirm('Xác nhận đăng xuất ?')) logOut();">Đăng
							xuất</a>
					</div>
				</security:authorize>



			</div>
			<!-- End Member -->

			<div class="cart">
				<a href="/user/cart"> <i class="fa fa-shopping-cart"></i> <span>Giỏ
						hàng</span> <span class="cart-number"></span>
				</a>
			</div>
			<!-- End Cart -->

			<!--<div class="check-order">
                    <a>
                        <i class="fa fa-truck"></i>
                        <span>Đơn hàng</span>
                    </a>
                </div> -->
		</div>
		<!-- End Tools Member -->
	</div>
	<!-- End Content -->
</div>