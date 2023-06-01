<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	<table class="listSanPham">
		<tbody>
			<tr>
				<th>STT</th>
				<th>Sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
				<th>Xóa</th>
			</tr>
			<c:if test="${ListProduct.isEmpty()}">
				<tr>
				<td colspan="7"> 
					<h1 style="color:red; background-color:white; font-weight:bold; text-align:center; padding: 15px 0;">
						giỏ hàng trống
					</h1> 
				</td>
			</tr>
			</c:if>
			
			<c:if test="${!ListProduct.isEmpty()}">
				
				<c:forEach var="dc" items="${ListProduct}" varStatus="loop">
					<tr>
				<td>${loop.index + 1 }</td>
				<td class="noPadding imgHide">
					<a target="_blank" href="#" title="Xem chi tiết">
						${dc.product.name }
						<img src="#">
					</a>
				</td>
				<td class="alignRight">${dc.product.price } ₫</td>
				<td class="soluong">
					<button ><i class="fa fa-minus" onclick="redirectPage(`<c:url value='/user/cart/${dc.card.id}/product/${dc.product.id}/except'/>`)"></i></button>
					<input size="1" onchange="" value="${dc.quantity }">
					<button ><i class="fa fa-plus" onclick="redirectPage(`<c:url value='/user/cart/${dc.card.id}/product/${dc.product.id}/add'/>`)"></i></button>
				</td>
				<td class="alignRight">${dc.product.price * dc.quantity}₫</td>
				<td class="noPadding"> <i class="fa fa-trash" onclick="redirectPage(`<c:url value='/user/cart/${dc.card.id}/remove/product/${dc.product.id}/'/>`)"></i> </td>
				</tr>
				
				</c:forEach>
				
				
			</c:if>
			<tr style="font-weight:bold; text-align:center">
				
				<td colspan="5" class="thanhtoan" onclick="redirectPage(`<c:url value='/user/order'/>`)"> Xác nhận mua hàng </td>
				<td class="xoaHet" onclick="redirectPage(`<c:url value='/user/cart/remove/all'/>`)"> Xóa hết </td>
			</tr>
			
		</tbody></table>
</body>
</html>