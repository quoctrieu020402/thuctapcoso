<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="chitietSanpham" style="margin-bottom: 100px">
	<h1>${product.name}</h1>
	<div class="rating">
		<i class="fa fa-star"></i><i class="fa fa-star"></i><i
			class="fa fa-star"></i><i class="fa fa-star"></i><i
			class="fa fa-star-o"></i><span> 372 đánh giá</span>
	</div>
	<div class="rowdetail group">
		<div class="picture">
			<img src="/templates/images/${product.image}" onclick="opencertain()">
		</div>
		<div class="price_sale">
			<div class="area_price">
				<strong>${product.price}</strong><label class="moiramat">
					Mới ra mắt </label>
			</div>
			<div class="ship" style="display: none;">
				<img src="img/chitietsanpham/clock-152067_960_720.png">
				<div>NHẬN HÀNG TRONG 1 GIỜ</div>
			</div>
			<div class="area_promo">
				<strong>khuyến mãi</strong>
				<div class="promo">
					<img src="img/chitietsanpham/icon-tick.png">
					<div id="detailPromo">Khách hàng sẽ được thử máy miễn phí tại
						cửa hàng. Có thể đổi trả lỗi trong vòng 2 tháng.</div>
				</div>
			</div>
			<div class="policy">
				<div>
					<img src="img/chitietsanpham/box.png">
					<p>Trong hộp có: Sạc, Tai nghe, Sách hướng dẫn, Cây lấy sim, Ốp
						lưng</p>
				</div>
				<div>
					<img src="img/chitietsanpham/icon-baohanh.png">
					<p>Bảo hành chính hãng 12 tháng.</p>
				</div>
				<div class="last">
					<img src="img/chitietsanpham/1-1.jpg">
					<p>1 đổi 1 trong 1 tháng nếu lỗi, đổi sản phẩm tại nhà trong 1
						ngày.</p>
				</div>
			</div>
			<div class="area_order">
				<!-- nameProduct là biến toàn cục được khởi tạo giá trị trong phanTich_URL_chiTietSanPham -->
				<a class="buy_now" href="<c:url value='/user/cart/${product.id}'/>">
					<b><i class="fa fa-cart-plus"></i> Thêm vào giỏ hàng</b>
					<p>Giao trong 1 giờ hoặc nhận tại cửa hàng</p>
				</a>
			</div>
		</div>
		<div class="info_product">
			<h2>Thông số kỹ thuật</h2>
			<ul class="info">
				<li>
					<p>Màn hình</p>
					<div>IPS LCD, 5.99', Full HD+</div>
				</li>
				<li>
					<p>Hệ điều hành</p>
					<div>Android 8.1 (Oreo)</div>
				</li>
				<li>
					<p>Camara sau</p>
					<div>12 MP và 5 MP (2 camera)</div>
				</li>
				<li>
					<p>Camara trước</p>
					<div>13 MP</div>
				</li>
				<li>
					<p>CPU</p>
					<div>Qualcomm Snapdragon 636 8 nhân</div>
				</li>
				<li>
					<p>RAM</p>
					<div>4 GB</div>
				</li>
				<li>
					<p>Bộ nhớ trong</p>
					<div>64 GB</div>
				</li>
				<li>
					<p>Thẻ nhớ</p>
					<div>MicroSD, hỗ trợ tối đa 128 GB</div>
				</li>
				<li>
					<p>Dung lượng pin</p>
					<div>4000 mAh, có sạc nhanh</div>
				</li>
			</ul>
		</div>
	</div>
	<div id="overlaycertainimg" class="overlaycertainimg">
		<div class="close" onclick="closecertain()">×</div>
		<div class="overlaycertainimg-content">
			<img id="bigimg" class="bigimg"
				src="img/products/xiaomi-redmi-note-5-pro-600x600.jpg">
			<div class="div_smallimg owl-carousel owl-loaded owl-drag">

				<div class="owl-stage-outer">
					<div class="owl-stage"
						style="transition: all 0s ease 0s; width: 2135px; transform: translate3d(610px, 0px, 0px);">
						<div class="owl-item active center" style="width: 304.96px;">
							<div class="item">
								<a> <img
									src="img/products/huawei-mate-20-pro-green-600x600.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item active" style="width: 304.96px;">
							<div class="item">
								<a> <img src="img/chitietsanpham/oppo-f9-mau-do-1-org.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item active" style="width: 304.96px;">
							<div class="item">
								<a> <img src="img/chitietsanpham/oppo-f9-mau-do-2-org.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item" style="width: 304.96px;">
							<div class="item">
								<a> <img src="img/chitietsanpham/oppo-f9-mau-do-3-org.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item" style="width: 304.96px;">
							<div class="item">
								<a> <img
									src="img/products/huawei-mate-20-pro-green-600x600.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item" style="width: 304.96px;">
							<div class="item">
								<a> <img src="img/chitietsanpham/oppo-f9-mau-do-3-org.jpg"
									onclick="changepic(this.src)">
								</a>
							</div>
						</div>
						<div class="owl-item" style="width: 304.96px;">
							<div class="item">
								<a> <img
									src="img/products/huawei-mate-20-pro-green-600x600.jpg"
									onclick="changepic(this.src)">
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
				<div class="owl-dots">
					<button role="button" class="owl-dot active">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
					<button role="button" class="owl-dot">
						<span></span>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="goiYSanPham">
	<div class="khungSanPham" style="border-color: #434aa8">
		<h3 class="tenKhung"
			style="background-image: linear-gradient(120deg, #434aa8 0%, #ec1f1f 50%, #434aa8 100%);">*
			Bạn có thể thích *</h3>
		<div class="listSpTrongKhung flexContain">
			<c:forEach items="${suggestedProducts}" var="suggestedProduct">
				<li class="sanPham">
				<div>
				<a
					href="/user/product_detail?id=${product.id }"> <img
						src="/templates/images/${suggestedProduct.image}" alt="">

						<h3>${suggestedProduct.name}</h3>

						<div class="price">
							<strong>${suggestedProduct.price}</strong>
						</div>
				</a>
				</div>
					<div >
						<a href="/user/${product.id }/compare/${suggestedProduct.id }/" class="compare"
							style="height: 30px; padding: 0px; display: flex; justify-content: center; align-items: center; background: #61a461; color: white">So
							sánh sản phẩm</a>
					</div></li>
			</c:forEach>
		</div>
	</div>
</div>