<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

	<div class="slideshow-container">
		<div class="slide">
			<img src="/templates/user/img/banners/banner1.png" alt="Image 1">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner2.png" alt="Image 2">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner3.png" alt="Image 3">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner4.png" alt="Image 4">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner5.png" alt="Image 5">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner6.png" alt="Image 6">
		</div>
		<div class="slide">
			<img src="/templates/user/img/banners/banner7.png" alt="Image 7">
		</div>

	</div>

	<script type="text/javascript">
	const slides = document.querySelectorAll('.slide');
	let currentIndex = 0;

	function showSlide(index) {
	  slides.forEach((slide, i) => {
	    if (i === index) {
	      slide.classList.add('active');
	    } else {
	      slide.classList.remove('active');
	    }
	  });
	}

	function nextSlide() {
	  currentIndex = (currentIndex + 1) % slides.length;
	  showSlide(currentIndex);
	}

	setInterval(nextSlide, 3000); // Chuyển đổi hình ảnh mỗi 3 giây (3000ms)

	</script>

	<!--gif  -->
	<!-- <div class="gif">
		<img src="/templates/user/img/banners/blackFriday.gif" alt=""
			style="width: 100%;">
	</div> -->

	<!-- lọc theo menu logo hãng  -->
	<div class="companyMenu group flexContain">
		<a href="index.html?company=macbook"><img
			src="/templates/user/img/company/macbook.jpg"></a><a
			href="index.html?company=asus"><img
			src="/templates/user/img/company/asus.png"></a><a
			href="index.html?company=hp"><img
			src="/templates/user/img/company/hp.png"></a><a
			href="index.html?company=Samsung"><img
			src="/templates/user/img/company/Samsung.jpg"></a><a
			href="index.html?company=msi"><img
			src="/templates/user/img/company/msi.jpg"></a><a
			href="index.html?company=acer"><img
			src="/templates/user/img/company/acer.png"></a><a
			href="index.html?company=microsoft"><img
			src="/templates/user/img/company/microsoft.png"></a><a
			href="index.html?company=gigabyte"><img
			src="/templates/user/img/company/gigabyte.png"></a>
	</div>

	<!--bộ lọc  -->
	<div class="flexContain">
		<div class="pricesRangeFilter dropdown">
			<button class="dropbtn">Giá tiền</button>
			<div class="dropdown-content">
				<a href="index.html?price=0-2000000">Dưới 10 triệu</a><a
					href="index.html?price=2000000-4000000">Từ 10 - 15 triệu</a><a
					href="index.html?price=4000000-7000000">Từ 15 - 20 triệu</a><a
					href="index.html?price=7000000-13000000">Từ 20 - 25 triệu</a><a
					href="index.html?price=13000000-0">Trên 25 triệu</a>
			</div>
		</div>

		<div class="promosFilter dropdown">
			<button class="dropbtn">Khuyến mãi</button>
			<div class="dropdown-content">
				<a href="index.html?promo=giamgia">Giảm giá</a><a
					href="index.html?promo=tragop">Trả góp</a>
			</div>
		</div>

		<div class="starFilter dropdown">
			<button class="dropbtn">Số lượng sao</button>
			<div class="dropdown-content">
				<a href="index.html?star=3">Trên 2 sao</a><a
					href="index.html?star=4">Trên 3 sao</a><a href="index.html?star=5">Trên
					4 sao</a>
			</div>
		</div>

		<div class="sortFilter dropdown">
			<button class="dropbtn">Sắp xếp</button>
			<div class="dropdown-content">
				<a href="index.html?sort=price-ascending">Giá tăng dần</a><a
					href="index.html?sort=price-decrease">Giá giảm dần</a><a
					href="index.html?sort=star-ascending">Sao tăng dần</a><a
					href="index.html?sort=star-decrease">Sao giảm dần</a><a
					href="index.html?sort=rateCount-ascending">Đánh giá tăng dần</a><a
					href="index.html?sort=rateCount-decrease">Đánh giá giảm dần</a><a
					href="index.html?sort=name-ascending">Tên A-Z</a><a
					href="index.html?sort=name-decrease">Tên Z-A</a>
			</div>
		</div>

	</div>



	<div class="contain-products" style="">
		<ul id="products" class="homeproduct group flexContain">
			<c:forEach items="${products}" var="product">
				<li class="sanPham"><a href="/product/${product.id}"> <img
						src=${product.image } alt="${product.name }">
						<h3>${product.name}</h3>
						<div class="price">
							<strong>${product.price }</strong>
						</div>
						<div class="ratingresult">
							<i class="fa fa-star"></i><i class="fa fa-star"></i><i
								class="fa fa-star"></i><i class="fa fa-star"></i><i
								class="fa fa-star"></i><span>188 đánh giá</span>
						</div> <label class="giamgia"> <i class="fa fa-bolt"></i> Giảm
							500.000₫
					</label>
						<div class="tooltip">
							<button class="themvaogio"
								onclick="themVaoGioHang('Opp0', 'Oppo F9'); return false;">
								<span class="tooltiptext" style="font-size: 15px;">Thêm
									vào giỏ</span> +
							</button>
						</div>
				</a></li>
			</c:forEach>
		</ul>
		<div class="pagination"></div>
	</div>
	<!-- Sử dụng vòng lặp để hiển thị thông tin sản phẩm -->
	<div class="contain-products" style="">
		<ul id="products" class="homeproduct group flexContain">
			<c:forEach items="${searchResults}" var="searchResult">
				<li class="sanPham"><a href="/product/${searchResult.id}"> <img
						src=${searchResult.image } alt="${searchResult.name }">
						<h3>${searchResult.name}</h3>
						<div class="price">
							<strong>${searchResult.price }</strong>
						</div>
						<div class="ratingresult">
							<i class="fa fa-star"></i><i class="fa fa-star"></i><i
								class="fa fa-star"></i><i class="fa fa-star"></i><i
								class="fa fa-star"></i><span>188 đánh giá</span>
						</div> <label class="giamgia"> <i class="fa fa-bolt"></i> Giảm
							500.000₫
					</label>
						<div class="tooltip">
							<button class="themvaogio"
								onclick="themVaoGioHang('Opp0', 'Oppo F9'); return false;">
								<span class="tooltiptext" style="font-size: 15px;">Thêm
									vào giỏ</span> +
							</button>
						</div>
				</a></li>
			</c:forEach>
		</ul>
		<div class="pagination"></div>
	</div>


	<div>
		<a th:href="@{/products?pageNo=0}">First</a> <a
			th:href="@{/products?pageNo=${currentPage - 1}}">Previous</a> <span
			th:text="${currentPage}"></span> <a
			th:href="@{/products?pageNo=${currentPage + 1}}">Next</a> <a
			th:href="@{/products?pageNo=${totalPages - 1}}">Last</a>
	</div>
</body>
</html>