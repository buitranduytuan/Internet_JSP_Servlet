<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>LIỆT KÊ DANH SÁCH KHÁCH HÀNG</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<header> <%@ include file="Nav.jsp"%>
	</header>

	<div class="container mt-3" class ="DanhSach">
		<h2>LIỆT KÊ DANH SÁCH KHÁCH HÀNG</h2>
		<table class="table table-bordered table-striped " id="example">
			<thead>
				<tr>
					<th>Mã khách hàng</th>
					<th>Tên khách hàng</th>
					<th>Địa chỉ</th>
					<th>Số điện thoại</th>
					<th>Địa Email</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody id="myTable">
			<c:forEach items="${listDSKH}" var="khachHang">
				<tr>
						<td>${khachHang.maKH}</td>
						<td>${khachHang.tenKH}</td>
						<td>${khachHang.diaChi}</td>
						<td>${khachHang.sdt}</td>
						<td>${khachHang.email}</td>
						<td>
							<div class="dropdown">
								<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Option</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="SuaThongTinServlet?maKH=${khachHang.maKH}&chucNang=suaKH">Edit</a>
									<a class="dropdown-item" href="XoaThongTinServlet?maKH=${khachHang.maKH}&chucNang=xoaKH">Delete</a>
								</div>
							</div>
						</td>
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
			"pageLength": 6
		});
    });
	</script>
	
	<!-- Footer -->
	<%@ include file="Footer.jsp"%>
	<!-- Footer -->
</body>
</html>