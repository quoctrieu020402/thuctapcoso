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

	<!--banner  -->
	<div class="banner">
		<div class="owl-carousel owl-theme owl-loaded owl-drag">
			<div class="owl-stage-outer">
				<div class="owl-stage"
					style="transition: all 0.45s ease 0s; width: 17400px; transform: translate3d(-10222px, 0px, 0px);">
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner5.png"> <img
								src="/templates/user/img/banners/banner5.png">
							</a>
						</div>
					</div>
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner6.png"> <img
								src="/templates/user/img/banners/banner6.png">
							</a>
						</div>
					</div>
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner7.png"> <img
								src="/templates/user/img/banners/banner7.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner1.png"> <img
								src="/templates/user/img/banners/banner1.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner2.png"> <img
								src="/templates/user/img/banners/banner2.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner3.png"> <img
								src="/templates/user/img/banners/banner3.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner4.png"> <img
								src="/templates/user/img/banners/banner4.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner5.png"> <img
								src="/templates/user/img/banners/banner5.png">
							</a>
						</div>
					</div>
					<div class="owl-item" style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner6.png"> <img
								src="/templates/user/img/banners/banner6.png">
							</a>
						</div>
					</div>
					<div class="owl-item active center"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner7.png"> <img
								src="/templates/user/img/banners/banner7.png">
							</a>
						</div>
					</div>

					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner1.png"> <img
								src="/templates/user/img/banners/banner1.png">
							</a>
						</div>
					</div>
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner2.png"> <img
								src="/templates/user/img/banners/banner2.png">
							</a>
						</div>
					</div>
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner3.png"> <img
								src="/templates/user/img/banners/banner3.png">
							</a>
						</div>
					</div>
					<div class="owl-item cloned"
						style="width: 770px; margin-right: 100px;">
						<div class="item">
							<a target="_blank" href="img/banners/banner4.png"> <img
								src="/templates/user/img/banners/banner4.png">
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="owl-nav disabled">
				<button type="button" role="presentation" class="owl-prev">
					<span aria-label="Previous">‹</span>
				</button>
				<button type="button" role="presentation" class="owl-next">
					<span aria-label="Next">›</span>
				</button>
			</div>
			<div class="owl-dots"></div>
		</div>
	</div>

	<!--gif  -->
	<div class="gif">
		<img src="/templates/user/img/banners/blackFriday.gif" alt=""
			style="width: 100%;">
	</div>

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
				<a href="index.html?price=0-2000000">Dưới 2 triệu</a><a
					href="index.html?price=2000000-4000000">Từ 2 - 4 triệu</a><a
					href="index.html?price=4000000-7000000">Từ 4 - 7 triệu</a><a
					href="index.html?price=7000000-13000000">Từ 7 - 13 triệu</a><a
					href="index.html?price=13000000-0">Trên 13 triệu</a>
			</div>
		</div>

		<div class="promosFilter dropdown">
			<button class="dropbtn">Khuyến mãi</button>
			<div class="dropdown-content">
				<a href="index.html?promo=giamgia">Giảm giá</a><a
					href="index.html?promo=tragop">Trả góp</a><a
					href="index.html?promo=moiramat">Mới ra mắt</a><a
					href="index.html?promo=giareonline">Giá rẻ online</a>
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

	<!--sản phẩm  -->
	<div class="contain-products" style="">

		<ul id="products" class="homeproduct group flexContain">
			<c:forEach items="${Products}" var="product">
				<li class="sanPham"><a href="product/details"> <img
						src=${product.image } alt="">
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
</body>
</html>