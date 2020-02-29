<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>ĐĂNG NHẬP HỆ THỐNG</title>
<%@ include file="header.jsp"%>
</head>

<body>
<header>
	<%@include file = "Nav.jsp" %> 
</header>
	
<div class="container">
  <form class ="MyForm" action = "DangNhapServlet" method = "post">
    <h2>Đăng nhập hệ thống</h2>
    <div class="form-group">
      <label for="userName">Tên đăng nhập</label>
      <input id="userName" type="text" class="form-control" placeholder="Nhập UserName"  name = "userName" required>
    </div>

    <div class="form-group">
      <label for = "password">Mật khẩu</label>
      <input id="password" type="text" class="form-control"  placeholder="Nhập mật khẩu" name="password" required>
    </div>
    
    <p style="color: red"> ${error}</p>
    
    <button type="submit" class="btn btn-primary" value = "submitLogin" name="submitLG">Đăng Nhập</button>
    <button type="reset" class="btn btn-primary"  value="submit" name="submit">Hủy</button>
    <p style="color: red"> ${login}</p>
  </form>
</div>

<!-- Footer -->
<%@ include file = "Footer.jsp" %>
<!-- Footer -->
</body>
</html>