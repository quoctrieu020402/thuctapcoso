<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>So sánh</title>
</head>
<body>
	<h1 style="text-align: center; margin-bottom:30px">So sánh 2 loại máy</h1>
	<div class="row" style="position: relative;">
		<div class="col l-6">
			
			<h4> ${product1.name}</h4>
			<div class="row">
				<div class="col l-6">
					<div class="picture" style="width: 100%;">
						<img src="/templates/images/${product1.image}" />
					</div>
				</div>
				<div class="col l-6">
					<p>Hãng ${product1.category.name}</p>
					<p>Dòng máy ${product1.machineSeries.name}</p>
					<p id="price"></p>
					<p>${product1.description}</p>
				</div>
			</div>


		</div>
		<div class="col l-6">
		
			<h4> ${product2.name}</h4>
			<div class="row">
				<div class="col l-6">
					<div class="picture" style="width: 100%;">
						<img src="/templates/images/${product2.image}" />
					</div>
				</div>
				<div class="col l-6">
					<p>Hãng ${product2.category.name}</p>
					<p>Dòng máy ${product2.machineSeries.name}</p>
					<p id="price2"></p>
					<p>${product2.description}</p>
				</div></div>
	</div>
	<div class="row" style="margin-top:30px">
	 <h2 style="text-align:center">Thông số kỹ thuật</h2>
		<div class="col l-6">
		
                   
                    <ul class="info"><li>
                <p>Màn hình</p>
                <div style="text-align: center">${product1.config.screenSize}</div>
            </li><li>
                <p>Hệ điều hành</p>
                <div style="text-align: center">${product1.config.system}</div>
            </li><li>
                <p>Card đồ hoạ</p>
                <div style="text-align: center">${product1.config.cardGraphic}</div>
            </li><li>
                <p>RAM</p>
                <div style="text-align: center">${product1.config.ram}</div>
            </li><li>
                <p>Bộ nhớ trong</p>
                <div style="text-align: center">${product1.config.rom}</div>
            </li><li>
                <p>Dung lượng pin</p>
                <div style="text-align: center">${product1.config.pin}</div>
            </li></ul>
               
		</div>
		<div class="col l-6">
                    <ul class="info"><li style="text-align: center">
               
                <div style="width:100%">${product2.config.screenSize}</div>
            </li><li style="text-align: center">
               
                <div style="width:100%">${product2.config.system}</div>
            </li><li style="text-align: center">
                
                <div style="width:100%">${product2.config.cardGraphic}</div>
            </li><li style="text-align: center">
               
                <div style="width:100%">${product2.config.ram}</div>
            </li><li style="text-align: center">
               
                <div style="width:100%">${product2.config.rom}</div>
            </li><li style="text-align: center">
               
                <div style="width:100%">${product2.config.pin}</div>
            </li></ul>
               
		</div>
	</div>
	
	<script type="text/javascript">
		function changePrice(){
			let element = document.getElementById("price");
			let element2 = document.getElementById("price2");
			
			const amount = ${product1.price};
			const amount2 = ${product2.price};
			let vnd = amount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
			let vnd2 = amount2.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
			element.innerHTML = "Giá tiền " + vnd;
			element2.innerHTML = "Giá tiền " + vnd2;
		}
		
		changePrice();
	</script>
</body>
</html>