<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TẠO MỚI KHÁCH HÀNG</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<header> <%@ include file="Nav.jsp"%>
	</header>

	<div class="container">
		<form class ="MyForm" action="TaoKHMoiServlet" method = "post" onsubmit = "return validateTaoKH()">
			<h2>TẠO MỚI KHÁCH HÀNG</h2>
			
    		<p style="color: red"> ${error}</p>
    		
			<div class="form-group">
				<label for="maKH">Mã khách hàng</label>
				<input type="text" class="form-control" id="maKH" placeholder="Nhập mã khách hàng (KHxxxxx) x: là ký tự số" name="maKH" 
				onkeyup = "validateMaKH()">
				<p id= "errorMaKH" style="color: red"></p>
			</div>
			<div class="form-group">
				<label for="tenKH">Tên khách hàng</label> <input type="text"
					class="form-control" id="tenKH" placeholder="Nhập tên khách hàng" name="tenKH">
			</div>
			<div class="form-group">
				<label for="diaChi">Địa chỉ</label> <input type="text" class="form-control" id="diaChi"
					placeholder="Nhập địa chỉ khách hàng" name="diaChi">
			</div>
			<div class="form-group">
				<label for="sdt">Số điện thoại</label> <input type="text"
					class="form-control" id="sdt" placeholder="Nhập số điện thoại" onkeyup = "validatePhone('sdt','errorPhone')" name="sdt">
					<p id= "errorPhone" style="color: red"></p>
			</div>
			<div class="form-group">
				<label for="email">Địa chỉ Email</label> <input type="email"
					class="form-control" id="email" placeholder="Nhập địa chỉ email" onkeyup = "validateEmail('email','errorEmail')" name="email">
					<p id= "errorEmail" style="color: red"></p>
			</div>
			<p id="errorRong"  style="color: red"></p> 
			<button type="submit" class="btn btn-primary" name = "submit" value = "submitTaoKH">Submit</button>
		</form>
	</div>
	
	<!-- Footer --> <%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>