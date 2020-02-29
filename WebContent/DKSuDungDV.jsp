<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ĐĂNG KÝ SỬ DỤNG DỊCH VỤ</title>
<%@ include file="header.jsp"%>
<body>

	<header> 
	<%@ include file="Nav.jsp"%>
	</header>
	
	<div class="container">
		<form class ="MyForm" action="DKSDDichVuServlet" onsubmit = "return validateFormDKSDDV() ">
			<h2>ĐĂNG KÝ SỬ DỤNG DỊCH VỤ</h2>
			
			<div class="form-group">
				 <p  style="color: red"> ${thongBaoLoi} </p>
				
				<label for="maKH">Mã khách hàng</label>
				<input type="text" class="form-control" id="maKH" placeholder="Nhập mã khách hàng (KHxxxxx) x: là ký tự số"
				name="maKH" onkeyup = "validateMaKH('maKH','errorMaKH')" list="listMaKH">
				<p id= "errorMaKH" style="color: red"></p>
				<datalist id="listMaKH">
 	   				<c:forEach items="${listMaKH}" var="MaKH">
	   					<option value="${MaKH}" >${MaKH}</option>
	   				</c:forEach> 
				</datalist>
			</div>
			
			<div class="form-group">
				<label for="maDV">Mã dịch vụ</label>
				<input type="text" class="form-control" name = "maDV" placeholder="Nhập mã dịch vụ (DVxxx) x: là ký tự số"
				id="maDV" onkeyup="validateMaDV('maDV', 'errorMaDV')" list="listMaDV">
				<p id="errorMaDV"  style="color: red"></p>
				<datalist id="listMaDV">
 					 <c:forEach items="${listMaDV}" var="MaDV">
	   					<option value="${MaDV}" >${MaDV}</option>
	   				</c:forEach> 
				</datalist>
			</div>
			
			<div class="form-group">
				<label for="ngaySD">Ngày sử dụng</label>
				<input type="date" class="form-control" id="ngaySD" placeholder="Nhập ngày sử dụng" name="ngaySD" required>
			</div>
			<div class="form-group">
				<label for="gioSD">Giờ sử dụng</label>
				<input type="time" class="form-control" id="gioSD" placeholder="Nhập giờ sử dụng" name="gioSD" required>
			</div>
			<div class="form-group">
				<label for="soLuong">Số lượng</label>
				<input type="text" class="form-control" id="soLuong" placeholder="Nhập số lượng" name="soLuong"
				onkeyup = "validateNumber('soLuong','errorSL')">
				<p id = "errorSL" style="color: red"></p>
			</div>
			<p id="errorRong"  style="color: red"></p> 
			<p style="color: red"> ${errorNumber} </p>
			<button type="submit" class="btn btn-primary" name= "submit" value = "sumitDKSDDV">Submit</button>
		</form>
	</div>
	<!-- Footer -->
	<%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>