<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.bean.DichVu"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>LIỆT KÊ DANH SÁCH DỊCH VỤ</title>
<%@ include file="header.jsp"%>
</head>

<body>

	<header> 
	<%@ include file="Nav.jsp"%>
	</header>

	<div class="container mt-3" class ="DanhSach">
		<h2>LIỆT KÊ DANH SÁCH DỊCH VỤ</h2>
		
  		<table class="table table-bordered table-striped " id="example">
			<thead>
				<tr>
					<th>Mã Dịch Vụ</th>
					<th>Tên Dịch Vụ</th>
					<th>Đơn Vị Tính</th>
					<th>Đơn Giá</th>
					<th>Chức Năng</th>
				</tr>
			</thead>
			<tbody id="myTable">
			
			<c:forEach items="${listDSDV}" var="dichVu">
				<tr>
						<td>${dichVu.maDV}</td>
						<td>${dichVu.tenDV}</td>
						<td>${dichVu.donViTinh}</td>
						<td>${dichVu.donGia}</td>
						<td>
							<div class="dropdown">
								<button type="button" class="btn btn-primary dropdown-toggle"
									data-toggle="dropdown">Option</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="SuaThongTinServlet?maDV=${dichVu.maDV}&chucNang=suaDV">Edit</a>
									<a class="dropdown-item" href="XoaThongTinServlet?maDV=${dichVu.maDV}&chucNang=xoaDV">Delete</a>
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