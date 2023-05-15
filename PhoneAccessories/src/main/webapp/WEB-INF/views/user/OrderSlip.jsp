<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="listDonHang">
		<table class="listSanPham">
			<tbody>
				<tr>
					<th colspan="6">
						<h3 style="text-align: center;">Phiếu đặt hàng ngày: ${date}</h3>
					</th>
				</tr>
				<tr>
					<th>STT</th>
					<th>Sản phẩm</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
					
				</tr>
					<c:forEach var="dc" items="${list}" varStatus="loop">
				<tr>
						<td>${loop.index + 1 }</td>
					<td class="noPadding imgHide"><a target="_blank"
						href="chitietsanpham.html?Xiaomi-Redmi-Note-5"
						title="Xem chi tiết"> ${dc.product.name } <img
							src="img/products/xiaomi-redmi-note-5-pro-600x600.jpg">
					</a></td>
					<td class="alignRight">${dc.product.price } ₫</td>
					<td class="soluong">${dc.quantity }</td>
					<td class="alignRight">${dc.product.price * dc.quantity} ₫</td>

				</tr>
					</c:forEach>

				<tr style="font-weight: bold; text-align: center; height: 4em;">
					<td colspan="4">TỔNG TIỀN:</td>
					<td class="alignRight">${sumMoney}</td>
					
				</tr>
			</tbody>
		</table>
		<hr>
	</div>
	
	<div class="body-lienhe">
		<div class="lienhe-info">

			<div class="guithongtin">
				<p style="font-size: 22px; color: gray">Gửi thông tin liên lạc
					cho chúng tôi:</p>
				<hr>
				<form name="formlh" onsubmit="return nguoidung()">
					<table cellspacing="10px" style="display:flex;justify-content: center;">
						<tbody >
							<tr>
								<td>Họ và tên</td>
								<td><input type="text" name="ht" size="40" maxlength="40"
									placeholder="Họ tên" autocomplete="off" required=""></td>
							</tr>
							<tr>
								<td>Điện thoại liên hệ</td>
								<td><input type="text" name="sdt" size="40" maxlength="11"
									minlength="10" placeholder="Điện thoại" required=""></td>
							</tr>
							
							<tr>
								<td>Tiêu đề</td>
								<td><input type="text" name="tde" size="40" maxlength="100"
									placeholder="Tiêu đề" required=""></td>
							</tr>
							<tr>
								<td>Nội dung</td>
								<td><textarea name="nd" rows="5" cols="44" maxlength="500"
										wrap="physical" placeholder="Nội dung liên hệ" required=""></textarea></td>
							</tr>
							<tr>
								<td></td>
								<td><button type="submit" style="height: 40px;
    width: 100%;">Gửi thông tin liên hệ để xác nhận đặt hàng đặt hàng</button></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

		</div>
	</div>
</body>
</html>