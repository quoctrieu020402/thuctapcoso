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
	<!--end banner  -->

	<div class="gif">
		<img src="/templates/user/img/banners/blackFriday.gif" alt=""
			style="width: 100%;">
	</div>
	<!--end gif  -->

	<div class="companyMenu group flexContain">

		<a href="product?categoryId=1"><img
			src="/templates/user/img/company/macbook.jpg"></a><a
			href="product?categoryId=2"><img
			src="/templates/user/img/company/acer.png"></a><a
			href="product?categoryId=3"><img
			src="/templates/user/img/company/asus.jpg"></a><a
			href="product?categoryId=4"><img
			src="/templates/user/img/company/dell.jpg"></a><a
			href="product?categoryId=5"><img
			src="/templates/user/img/company/gigabyte.png"></a><a
			href="product?categoryId=6"><img
			src="/templates/user/img/company/hp.png"></a><a
			href="product?categoryId=7"><img
			src="/templates/user/img/company/lenovo.jpg"></a><a
			href="product?categoryId=8"><img
			src="/templates/user/img/company/msi.jpg"></a><a
			href="product?categoryId=9"><img
			src="/templates/user/img/company/Samsung.jpg"></a><a
			href="product?categoryId=10"><img
			src="/templates/user/img/company/microsoft.png"></a>

	</div>

	<div class="flexContain">

		<div class="pricesRangeFilter dropdown">
			<button class="dropbtn">Giá tiền</button>
			<div class="dropdown-content">
				<a href="findbycenterprice?price1=0&price2=2000000">Dưới 2 triệu</a><a
					href="findbycenterprice?price1=2000000&price2=4000000">Từ 2 - 4
					triệu</a><a href="findbycenterprice?price1=4000000&price2=7000000">Từ
					4 - 7 triệu</a><a
					href="findbycenterprice?price1=7000000&price2=13000000">Từ 7 -
					13 triệu</a><a href="findbycenterprice?price1=13000000&price2=0">Trên
					13 triệu</a>
			</div>
		</div>

		<div class="sortFilter dropdown">
			<button class="dropbtn">Sắp xếp</button>
			<div class="dropdown-content">
				<a href="price?sortType=price-asc">Giá tăng dần</a> <a
					href="price?sortType=price-desc">Giá giảm dần</a> <a
					href="price?sortType=name-asc">Tên A-Z</a><a
					href="price?sortType=name-desc">Tên Z-A</a>
			</div>
		</div>

	</div>
	<!-- End khung chọn bộ lọc -->

	<div class="choosedFilter flexContain">
		<a id="deleteAllFilter" style="display: block;" href="product.html">
			<h3>Xóa bộ lọc</h3>
		</a>
	</div>
	<!-- Những bộ lọc đã chọn -->
	<hr>

	<!-- Mặc định mới vào trang sẽ ẩn đi, nế có filter thì mới hiện lên -->
	<div class="contain-products" style="">
		<div class="filterName">
			<input type="text" placeholder="Lọc trong trang theo tên..."
				onkeyup="filterProductsName(this)">
		</div>
		<!-- End FilterName -->

		<ul id="products" class="homeproduct group flexContain">
			<div id="khongCoSanPham">
				<i class="fa fa-times-circle"></i> Không có sản phẩm nào
			</div>
			<!-- End Khong co san pham -->

			<c:forEach var="product" items="${listProduct }">
				<li class="sanPham"><a href="product_detail?id=${product.id }">
						<img src="/templates/user/access/img/${product.image}" alt="">
						<h3>${product.name}</h3>
						<div class="price">
							<fmt:formatNumber value="${product.price}" type="currency"
								currencySymbol="" maxFractionDigits="0"></fmt:formatNumber>
							đ

						</div>
						<div class="tooltip">
							<button class="themvaogio"
								onclick="themVaoGioHang; return false;">
								<span class="tooltiptext" style="font-size: 15px;">Xem
									chi tiết</span> +
							</button>
						</div>
				</a></li>
			</c:forEach>



			<!-- End products -->
			
			<div class="contain-products" style="">
		<ul id="products" class="homeproduct group flexContain">
			<c:forEach items="${searchResults}" var="searchResult">
				<li class="sanPham"><a href="product_detail?id=${product.id }"> <img
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
		
	</div>
	<!--End search  -->
	
	</div>
	<div class="pagination">
		<ul id="pagination" class="saleoff"></ul>
	</div>
	<!-- Div hiển thị khung sp hot, khuyến mãi, mới ra mắt ... -->
	<div class="contain-khungSanPham"></div>

	</section>
	<!-- End Section -->

	<!-- /form -->


	<!-- /sign up -->
	</div>
	<!-- tab-content -->

	</div>
	<!-- /taikhoan -->
	</div>
	<div class="plc">
		<section>
			<ul class="flexContain">
				<li>Giao hàng hỏa tốc trong 1 giờ</li>
				<li>Thanh toán linh hoạt: tiền mặt, visa / master, trả góp</li>
				<li>Trải nghiệm sản phẩm tại nhà</li>
				<li>Lỗi đổi tại nhà trong 1 ngày</li>
				<li>Hỗ trợ suốt thời gian sử dụng. <br>Hotline: <a
					href="tel:12345678" style="color: #288ad6;">12345678</a>
				</li>
			</ul>
		</section>
	</div>

	<i class="fa fa-arrow-up" id="goto-top-page" onclick="gotoTop()"></i>

	<script>
		//phân trang
		
		const products = document.querySelectorAll(".sanPham");// lấy tất cả item ra
		const itemsPerPage = 10; // Số sản phẩm mỗi trang
		const numPages = Math.ceil(products.length / itemsPerPage); // Tổng số trang
		
		// Hiển thị danh sách sản phẩm cho trang đầu tiên
		showPage(1);
		
		// Tạo các nút liên kết phân trang
		const pagination = document.querySelector(".pagination");
		for (let i = 1; i <= numPages; i++) {
		  const li = document.createElement("li");
		  const link = document.createElement("a");
		  link.textContent = i;
		  link.href = "#";
		  if (i === 1) {
		    li.classList.add("active");
		  }
		  
		  li.appendChild(link);
		  pagination.appendChild(li);
		
		  // Xử lý sự kiện click cho từng nút liên kết
		  link.addEventListener("click", function (event) {
		    event.preventDefault();
		    // Xóa class active của tất cả các nút liên kết khác
		    const activeLink = pagination.querySelector("li.active");
		    if (activeLink) activeLink.classList.remove("active");
		    // Thêm class active vào nút liên kết được click
		    li.classList.add("active");
		
		    showPage(i);
		  });
		}
		
		// Hiển thị sản phẩm cho trang được chọn
		function showPage(pageNumber) {
		  const startIndex = (pageNumber - 1) * itemsPerPage;
		  const endIndex = startIndex + itemsPerPage;
		  for (let i = 0; i < products.length; i++) {
		    if (i >= startIndex && i < endIndex) {
		      products[i].style.display = "block";
		    } else {
		      products[i].style.display = "none";
		    }
		  }
		}
//end phân trang
		
</script>


	
	

</body>
</html>