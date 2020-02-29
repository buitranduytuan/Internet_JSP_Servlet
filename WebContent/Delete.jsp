<%@page import="model.bean.KhachHang"%>
<%@page import="model.bean.DichVu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.bean.May"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>DELETE</title>
<%@ include file="header.jsp"%>
</head>

<body>
<header>
	<%@ include file = "Nav.jsp" %>
</header>
	
<div class="container" >

	<c:if test="${xoaTT == 'xoaTTMay' }">
		<form class ="MyForm" action = "XoaThongTinServlet?maMay=${MayXoaTT.maMay}&chucNang=submitXoaMay" method = "post">
	    <h2>DELETE MÁY</h2>
	    <p>Bạn có muốn xóa thông tin của máy: ${MayXoaTT.maMay}</p>
	    <div class="form-group">
	      <table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã máy</th>
						<th>Trạng Thái</th>
						<th>Vị trí</th>
					</tr>
				</thead>
				<tbody id="myTable">
				<tr>
						<td>${MayXoaTT.maMay}</td>
						<td>${MayXoaTT.trangThai}</td>
						<td>${MayXoaTT.viTri}</td>
				<tr>
				</tbody>
				</table>
	    
	    <button type="submit" class="btn btn-primary" name="submit">Xóa Thông Tin</button>
	    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
	  </form>
	</c:if>
	
	<c:if test="${xoaTT == 'xoaTTDV' }">
		<form class ="MyForm" action = "XoaThongTinServlet?maDV=${DVXoaTT.maDV}&chucNang=submitXoaDV" method = "post">
	    <h2>DELETE DỊCH VỤ</h2>
	    <p>Bạn có muốn xóa thông tin của Dịch Vụ: ${DVXoaTT.maDV}</p>
	    <div class="form-group">
	      <table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã Dịch Vụ</th>
						<th>Tên Dịch Vụ</th>
						<th>Đơn Vị Tính</th>
						<th>Đơn Giá</th>
					</tr>
				</thead>
				<tbody id="myTable">
				<tr>
						<td>${DVXoaTT.maDV}</td>
						<td>${DVXoaTT.tenDV}</td>
						<td>${DVXoaTT.donViTinh}</td>
						<td>${DVXoaTT.donGia}</td>
				<tr>
				</tbody>
				</table>
	    
	    <button type="submit" class="btn btn-primary" name="submit">Xóa Thông Tin</button>
	    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
	  </form>
	</c:if>
	
	<c:if test="${xoaTT == 'xoaTTKH' }">
		<form class ="MyForm" action = "XoaThongTinServlet?maKH=${KHXoaTT.maKH}&chucNang=submitXoaKH" method = "post">
	    <h2>DELETE KHÁCH HÀNG</h2>
	    <p>Bạn có muốn xóa thông tin của Khách Hàng: ${KHXoaTT.maKH}</p>
	    <div class="form-group">
	      <table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã khách hàng</th>
						<th>Tên khách hàng</th>
						<th>Địa chỉ</th>
						<th>Số điện thoại</th>
						<th>Địa Email</th>
					</tr>
				</thead>
				<tbody id="myTable">
				<tr>
						<td>${KHXoaTT.maKH}</td>
						<td>${KHXoaTT.tenKH}</td>
						<td>${KHXoaTT.diaChi}</td>
						<td>${KHXoaTT.sdt}</td>
						<td>${KHXoaTT.email}</td>
				<tr>
				</tbody>
				</table>
	    
	    <button type="submit" class="btn btn-primary" name="submit">Xóa Thông Tin</button>
	    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
	  </form>
	</c:if>
</div>

<!-- Footer -->
<%@ include file = "Footer.jsp" %>
<!-- Footer -->
</body>
</html>