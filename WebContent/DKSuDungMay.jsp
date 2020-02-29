<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ĐĂNG KÝ SỬ DỤNG MÁY</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<header> 
	<%@ include file="Nav.jsp"%>
	</header>
	
	<div class="container">
		<form class ="MyForm" action="DKSDMayServlet" onsubmit = "return validateFormDKSDMay()">
			<h2>ĐĂNG KÝ SỬ DỤNG MÁY</h2>
			<div class="form-group">
				<p  style="color: red"> ${thongBaoLoi} </p>
				<label for="maKH">Mã khách hàng</label>
				<input type="text" class="form-control" id="maKH" placeholder="Nhập mã khách hàng (KHxxxxx) x: là ký tự số"
				name="maKH" onkeyup = "validateMaKH('maKH','errorMaKH')" list="listMaKH">
				<p id= "errorMaKH" style="color: red"></p>
				<datalist id="listMaKH">
					<c:forEach items="${listMaKH}" var="maKH">
						<option value="${maKH}" >${maKH}</option>
					</c:forEach>
				</datalist>
			</div>
			
			<div class="form-group">
				<label for="maMay">Mã máy</label> 
				<input id="maMay" type="text" class="form-control" placeholder="Nhập mã máy (MAYxxxx) x: là ký tự số" 
      				name = "maMay" onkeyup = "validateMaMay('maMay','errorMM')" list="listMaMay">
     			 <p id="errorMM"  style="color: red"></p>
				<datalist id="listMaMay">
					<c:forEach items="${listMaMayDR}" var="maMay">
						<option value="${maMay}" >${maMay}</option>
					</c:forEach>
				</datalist>
			</div>
			<div class="form-group">
				<label for="ngayBD">Ngày bắt đầu sử dụng</label>
				<input type="date" class="form-control" id="ngayBD" placeholder="Nhập ngày bắt đầu sử dụng" name="ngayBD" required>
			</div>
			<div class="form-group">
				<label for="gioBD">Giờ bắt đầu sử dụng</label>
				<input type="time" class="form-control" id="gioBD" placeholder="Nhập giờ bắt đầu sử dụng" name="gioBD" required>
			</div>
			<div class="form-group">
				<label for="thoiGianSD">Thời gian sử dụng Máy</label>
				<input type="text" class="form-control" id="thoiGianSD" placeholder="Nhập thời gian sử dụng" name="thoiGianSD"
				onkeyup = "validateNumber('thoiGianSD','errorTG')">
				<p id = "errorTG" style="color: red"></p>
			</div>
			<p id="errorRong"  style="color: red"></p> 
			<button type="submit" class="btn btn-primary" name = "submit" value = "sumitDKSDMay">Submit</button>
		</form>
	</div>
	<!-- Footer -->
	<%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>