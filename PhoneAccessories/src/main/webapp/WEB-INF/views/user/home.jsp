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
	<div class="contain-products" style="">

		<ul id="products" class="homeproduct group flexContain">
			<li class="sanPham"><a href="chitietsanpham.html?Oppo-F9"> <img
					src="img/products/oppo-f9-red-600x600.jpg" alt="">
					<h3>Oppo F9</h3>
					<div class="price">
						<strong>7.690.000₫</strong>
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
		</ul>
		<div class="pagination"></div>
	</div>
</body>
</html>