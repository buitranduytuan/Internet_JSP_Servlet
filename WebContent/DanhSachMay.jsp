<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.bean.May"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>LIỆT KÊ DANH SÁCH MÁY</title>
<%@ include file="header.jsp"%>
</head>

<body>
	<header> 
	<%@ include file="Nav.jsp"%>
	</header>

	<div class="container mt-3" class ="DanhSach">
		<h2>LIỆT KÊ DANH SÁCH MÁY</h2> 	
  		<table class="table table-bordered table-striped " id = "example">
			<thead>
				<tr>
					<th>Mã máy</th>
					<th>Trạng Thái</th>
					<th>Vị trí</th>
	 				<th>Chức năng</th> 
				</tr>
			</thead>
			<tbody id="myTable">
			
			<c:forEach items="${listDSMay}" var="may">
			<tr>
					<td>${may.maMay}</td>
					<td>${may.trangThai}</td>
					<td>${may.viTri}</td>
					<td>
						<div class="dropdown">
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">Option</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="SuaThongTinServlet?maMay=${may.maMay}&chucNang=suaMay">Edit</a>
								<a class="dropdown-item" href="XoaThongTinServlet?maMay=${may.maMay}&chucNang=xoaMay">Delete</a>
								<c:if test="${may.trangThai == 'Có người dùng' }">
									<a class="dropdown-item" href="SuaThongTinServlet?maMay=${may.maMay}&chucNang=tatMay">Tắt Máy</a>
								</c:if>
								<c:if test="${may.trangThai == 'Đang rảnh' }">
									<a class="dropdown-item" href="SuaThongTinServlet?maMay=${may.maMay}&chucNang=moMay">Mở Máy</a>
								</c:if>
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