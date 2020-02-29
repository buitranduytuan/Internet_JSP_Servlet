<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TẠO MỚI DỊCH VỤ</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<header> <%@ include file="Nav.jsp"%>
	</header>

	<div class="container">
		<form class ="MyForm" action="TaoDVMoiServlet" method = "post" onsubmit = "return validateFormTaoDV()">
			<div class="form-group">
				<h2>TẠO MỚI DỊCH VỤ</h2>
				
    			<p style="color: red"> ${error}</p>
    			
				<label for="maDV">Mã dịch vụ</label>
				<input type="text" class="form-control" id="maDV" placeholder="Nhập mã dịch vụ (DVxxx) x: là ký tự số" name="maDV"
				onkeyup="validateMaDV()">
				<p id="errorMaDV"  style="color: red"></p>
			</div>
			<div class="form-group">
				<label for="tenDV">Tên dịch vụ</label>
				<input type="text" class="form-control" id="tenDV" placeholder="Nhập tên dịch vụ" name="tenDV">
			</div>
			<div class="form-group">
   				<label>Đơn vị tính</label>
   					<select class="form-control" name="donViTinh">
		      			<option value="VND" selected>VND</option>
						<option value="USD">USD</option>
   					</select>
			</div>
			<div class="form-group">
				<label for="donGia">Đơn giá</label>
				<input type="text" class="form-control" id="donGia" placeholder="Nhập đơn giá" name="donGia"
				onkeyup = "validateNumber('donGia','errorDonGia')">
				<p id="errorDonGia"  style="color: red"></p>
			</div>
			<p id="errorRong"  style="color: red"></p> 
			<button type="submit" class="btn btn-primary" name = "submit" value = "submitTaoDV" >Submit</button>
		</form>
	</div>

	<!-- Footer --> <%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>