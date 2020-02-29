<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-sm bg-primary navbar-light justify-content-center">
  
  <a class="navbar-brand" href="DanhSachMayServlet"><img src="image/fpt-logo.png" alt=""></a>
  <a class="navbar-brand" href="DanhSachMayServlet">
  <h4 style="padding: 0; margin: 5px; color: white">TuanBTD</h4>
  </a>
  <ul class="navbar-nav nav nav-pills">
    <li class="nav-item">
      <div class="dropdown">
              <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> Tạo Mới
              </button>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="TaoMayMoiServlet">Tạo mới Máy</a>
                <a class="dropdown-item" href="TaoKHMoiServlet">Tạo mới Khách hàng</a>
                <a class="dropdown-item" href="TaoDVMoiServlet">Tạo mới Dịch Vụ</a>
              </div>
          </div>
    </li>
    <li class="nav-item">
      <div class="dropdown">
              <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> Liệt Kê Danh Sách
              </button>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="DanhSachMayServlet">Liệt kê danh sách Máy</a>
                <a class="dropdown-item" href="DanhSachDVServlet">Liệt kê danh sách Dịch vụ</a>
                <a class="dropdown-item" href="DanhSachKHServlet">Liệt kê danh sách Khách Hàng</a>
                <a class="dropdown-item" href="ThongTinKhachHangSuDungMayVaDVServlet">Liệt kê toàn bộ thông tin khách hàng</a>
              </div>
          </div>
    </li>
    <li class="nav-item">
      <div class="dropdown">
              <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> Đăng Ký Sử Dụng
              </button>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="DKSDMayServlet">Đăng ký sử dụng Máy</a>
                <a class="dropdown-item" href="DKSDDichVuServlet">Đăng ký sử dụng Dịch vụ</a>
              </div>
          </div>
    </li>  
    
    <li class="nav-item">
    <c:if test="${userName != null}">
    	<div class="dropdown">
           <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> Xin Chào ${userName}
           </button>
            <div class="dropdown-menu">
				<a class="dropdown-item" href="DangXuatServlet">Đăng xuất</a>
           </div>
         </div>
    </c:if>
    
    <li class="nav-item">
    	<c:set var="now" value="<%=new java.util.Date()%>" />
      	<div class="dropdown">
              <button type="button" class="btn btn-primary">
              	<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" />
              </button>
        </div>
    </li>
    
  </ul>

<%-- 
Lấy ngày giờ hiện tại
<c:set var="now" value="<%=new java.util.Date()%>" />
     <p>
           <fmt:formatDate type="time" value="${now}" />
     </p>
     <p>
           <fmt:formatDate type="date" value="${now}" />
     </p>
     <p>
           <fmt:formatDate type="both" value="${now}" />
     </p> --%>
</nav>