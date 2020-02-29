<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>TẠO MÁY MỚI</title>
<%@ include file="header.jsp"%>
</head>

<body>
<header>
	<%@ include file = "Nav.jsp" %>
</header>
	
<div class="container" >
  <form class ="MyForm" action = "TaoMayMoiServlet" method = "post" onsubmit="return validateFormTaoMay()">
    
    <h2>TẠO MÁY MỚI</h2>
    
    <p style="color: red"> ${error}</p>
    
    <div class="form-group">
      <label for="maMay">Mã máy</label>
      <input id="maMay" type="text" class="form-control" placeholder="Nhập mã máy (MAYxxxx) x: là ký tự số" 
      name = "maMay" onkeyup = "validateMaMay()">
      <p id="errorMM"  style="color: red"></p> 
    </div>

    <div class="form-group">
   		<label>Trạng Thái</label>
   		<select class="form-control" name="trangThai">
	      <option value="Đang rảnh" selected>Đang rảnh</option>
	      <option value="Có người dùng" >Có người dùng</option>
	      <option value="Đang sửa chữa">Đang sửa chữa</option>
   		</select>
	</div>
    
    <div class="form-group">
      <label for = "viTri">Vị trí</label>
      <input id="viTri" type="text" class="form-control"  placeholder="Nhập vị trí" name="viTri">
    </div>
    <p id="errorRong"  style="color: red"></p> 
    <button type="submit" class="btn btn-primary" value = "submitTaoMay" name="submit">Submit</button>

  </form>
</div>

<!-- Footer -->
<%@ include file = "Footer.jsp" %>
<!-- Footer -->
</body>
</html>