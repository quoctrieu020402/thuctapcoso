<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang chủ</title>

<link href="/templates/user/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous">

<script src="/templates/user/js/Jquery/Jquery.min.js"></script>
<script src="/templates/user/js/owlcarousel/owl.carousel.min.js"></script>
<link rel="stylesheet" href="/templates/user/js/owlcarousel/owl.carousel.min.css">
<link rel="stylesheet" href="/templates/user/js/owlcarousel/owl.theme.default.min.css">
<link rel="stylesheet" href="/templates/user/css/style.css">
<link rel="stylesheet" href="/templates/user/css/topnav.css">
<link rel="stylesheet" href="/templates/user/css/header.css">
<link rel="stylesheet" href="/templates/user/css/banner.css">
<link rel="stylesheet" href="/templates/user/css/taikhoan.css">
<link rel="stylesheet" href="/templates/user/css/trangchu.css">
<link rel="stylesheet" href="/templates/user/css/gioHang.css">
<link rel="stylesheet" href="/templates/user/css/home_products.css">
<link rel="stylesheet" href="/templates/user/css/pagination_phantrang.css">
<link rel="stylesheet" href="/templates/user/css/footer.css">
<link rel="stylesheet" href="/templates/user/css/chitietsanpham.css">


</head>
<body>
	
	<section>
		<%@ include file="/common/user/header.jsp"%>
		
<%-- 		<%@ include file="/common/user/banner.jsp"%>
 --%>		
		<dec:body></dec:body>
	</section>
	
	<%@ include file="/common/admin/footer.jsp"%>
	
	<script src="/templates/user/js/redirect.js"></script>
</body>
</html>