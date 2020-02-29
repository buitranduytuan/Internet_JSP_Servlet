<%@page import="model.bean.ThongTinKhachHangSuDungMayVaDV"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LIỆT KÊ TOÀN BỘ THÔNG TIN KHÁCH HÀNG</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<header> <%@ include file="Nav.jsp"%>
	</header>

	<div class="container mt-3" class ="MyForm">
		<h2>LIỆT KÊ TOÀN BỘ THÔNG TIN KHÁCH HÀNG</h2>
		
		<table class="table table-bordered table-striped " id="example">
			<thead>
				<tr>
					<th>Mã KH</th>
					<th>Tên KH</th>
					<th>Mã Máy</th>
					<th>Vị Trí</th>
					<th>Trạng thái</th>
					<th>Ngày BĐ sử dụng</th>
					<th>Giờ BĐ sử dụng</th>
					<th>Thời gian SD Máy</th>
					<th>Mã DV</th>
					<th>Ngày SD Dịch Vụ</th>
					<th>Giờ SD Dịch Vụ</th>
					<th>Số lượng</th>
					<th>Tổng tiền</th>
				</tr>
			</thead>
			<tbody id="myTable">
			<c:forEach items="${listThongTin}" var="thongTin">
				<tr>
					<td>${thongTin.maKH}</td>
					<td>${thongTin.tenKH}</td>
					<td>${thongTin.maMay}</td>
					<td>${thongTin.viTri}</td>
					<td>${thongTin.trangThai}</td>
					<td>${thongTin.ngayBDSDMay}</td>
					<td>${thongTin.gioBDSDMay}</td>
					<td>${thongTin.thoiGianSDMay}</td>
					<td>${thongTin.maDV}</td>
					<td>${thongTin.ngaySD}</td>
					<td>${thongTin.gioSD}</td>
					<td>${thongTin.soLuong}</td>
					<td>${thongTin.tongTien}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
	$(document).ready(function() {
        $('#example').DataTable({
			"ordering": false,
			"lengthChange": false,
			"searching": true,
			"pageLength": 5
		});
    });
	</script>

	<!-- Footer -->
	<%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>