<%@page import="model.bean.KhachHang"%>
<%@page import="model.bean.DichVu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.bean.May"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>SỬA THÔNG TIN</title>
<%@ include file="header.jsp"%>
</head>

<body>
	<header>
		<%@ include file = "Nav.jsp" %>
	</header>
	
<div class="container">

<c:choose>
    <c:when test="${suaTT eq 'suaTTMay'}">
		<form class ="MyForm" action = "SuaThongTinServlet?chucNang=submitSuaMay" method = "post"> 
		    <h2>SỬA THÔNG TIN MÁY</h2>
		    
		    <div class="form-group">
		      <label for="maMay">Mã máy</label>
		      <input id="maMay" type="text" class="form-control" name = "maMay" value = "${MaySuaTT.getMaMay()}" readonly="readonly">
		 
		    </div>
		    <div class="form-group">
		      <label for = "trangThai">Trạng Thái</label>
		      	<select class="form-control" name="trangThai">
				    <option value="${MaySuaTT.trangThai}" selected>${MaySuaTT.trangThai}</option>
				    <option value="Có người dùng">Có người dùng</option>
			      	<option value="Đang rảnh">Đang rảnh</option>
			      	<option value="Đang sửa chữa">Đang sửa chữa</option>
		   		</select>
		    </div>
		    <div class="form-group">
		      <label for = "viTri">Vị trí</label>
		      <input id="viTri" type="text" class="form-control"  name="viTri" value = "${MaySuaTT.viTri}">
		    </div>
		 
		    <button type="submit" class="btn btn-primary" name="submit">Xác Nhận Sửa Thông Tin</button>
		    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
		  </form>
    </c:when>
    
    <c:when test="${suaTT eq 'suaTTDV'}">
		   <form class ="MyForm" action = "SuaThongTinServlet?chucNang=submitSuaDV" method = "post">
		    
		    <h2>SỬA THÔNG TIN DỊCH VỤ</h2>
		    
		    <div class="form-group">
		      <label for="maDV">Mã Dịch Vụ</label>
		      <input id="maDV" type="text" class="form-control" name = "maDV" value = "${DVSuaTT.maDV}" readonly="readonly">
		 
		    </div>
		    <div class="form-group">
		      <label for = "tenDV">Tên Dịch Vụ</label>
		      <input type="text" class="form-control" id="tenDV" name="tenDV" value = "${DVSuaTT.tenDV}">
		    </div>
		    <div class="form-group">
		      <label for = "donViTinh">Đơn Vị Tính</label>
		      	<select class="form-control" name="donViTinh">
				    <option value="${DVSuaTT.donViTinh}" selected>${DVSuaTT.donViTinh}</option>
				    <option value="VND">VND</option>
					<option value="USD">USD</option>
		   		</select>
		    </div>
		    <div class="form-group">
		      <label for = "donGia">Đơn Giá</label>
		      <input id="donGia" type="text" class="form-control"  name="donGia" value = "${DVSuaTT.donGia}">
		    </div>
		 
		    <button type="submit" class="btn btn-primary" name="submit">Xác Nhận Sửa Thông Tin</button>
		    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
		  </form>
    </c:when>
    
    <c:otherwise>
	    <form class ="MyForm" action = "SuaThongTinServlet?chucNang=submitSuaKH" method = "post">
	    
	    <h2>SỬA THÔNG TIN KHÁCH HÀNG</h2>
	    
	    <div class="form-group">
	      <label for="maKH">Mã Khách Hàng</label>
	      <input id="maKH" type="text" class="form-control" name = "maKH" value = "${KHSuaTT.maKH}" readonly="readonly">
	 
	    </div>
	    <div class="form-group">
	      <label for = "tenKH">Tên Khách Hàng</label>
	      <input type="text" class="form-control" id="tenKH" name="tenKH" value = "${KHSuaTT.tenKH}">
	    </div>
	    <div class="form-group">
	      <label for = "diaChi">Địa Chỉ</label>
	      <input id="diaChi" type="text" class="form-control"  name="diaChi" value = "${KHSuaTT.diaChi}" >
	    </div>
	    <div class="form-group">
	      <label for = "sdt">Số Điện Thoại</label>
	      <input type="text" class="form-control" id="sdt" name="sdt" value = "${KHSuaTT.sdt}" onkeyup = "validatePhone('sdt','errorPhone')">
	      <p id= "errorPhone" style="color: red"></p>
	    </div>
	    <div class="form-group">
	      <label for = "email">Email</label>
	      <input id="email" type="text" class="form-control"  name="email" value = "${KHSuaTT.email}" onkeyup = "validateEmail('email','errorEmail')">
	      <p id= "errorEmail" style="color: red"></p>
	    </div>
	 
	    <button type="submit" class="btn btn-primary" name="submit">Xác Nhận Sửa Thông Tin</button>
	    <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
	  </form>
    </c:otherwise>
</c:choose>
</div>

<!-- Footer -->
<%@ include file = "Footer.jsp" %>
<!-- Footer -->
</body>
</html>