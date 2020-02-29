package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.DichVuBO;
import model.BO.KhachHangBO;
import model.BO.MayBO;
import model.bean.DichVu;
import model.bean.KhachHang;
import model.bean.May;

/**
 * Servlet implementation class SuaThongTinServlet
 */
@WebServlet("/SuaThongTinServlet")
public class SuaThongTinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaThongTinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			request.setAttribute("login", "Bạn phải đăng nhập trước khi sử dụng trang Web!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
				
		request.setCharacterEncoding("UTF-8");
		String maMay = request.getParameter("maMay");
		May may = MayBO.getThongTinMay(maMay);
		String maDV = request.getParameter("maDV");
		DichVu dichVu = DichVuBO.getThongTinDV(maDV);
		String maKH = request.getParameter("maKH");
		KhachHang khachHang = KhachHangBO.getThongTinKH(maKH);
		String chucNang = request.getParameter("chucNang");
		
		// SỬA MÁY
		if(chucNang.equals("submitSuaMay")) { // nhấn nút Xác nhận Sửa Thông Tin Máy ở trang SuaThongTin.jsp
			String trangThai = request.getParameter("trangThai");
			String viTri = request.getParameter("viTri");
			MayBO.suaThongTinMay(maMay, trangThai, viTri);
			response.sendRedirect("DanhSachMayServlet");
		} 
		if(chucNang.equals("suaMay")) {  // chuyển đến trang SuaThongTin.jsp từ trang DanhSachMay.jsp
			request.setAttribute("suaTT", "suaTTMay");
			request.setAttribute("MaySuaTT", may);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SuaThongTin.jsp");
			dispatcher.forward(request, response);
		}
		if(chucNang.equals("moMay")) {  // mở máy thì đổi trạng thái máy thành có người dùng
			
			MayBO.suaThongTinMay(maMay, "Có người dùng", may.getViTri());
			response.sendRedirect("DanhSachMayServlet");
		}
		if(chucNang.equals("tatMay")) {  // tắt máy thì đổi trạng thái thành Đang rảnh
			
			MayBO.suaThongTinMay(maMay, "Đang rảnh", may.getViTri());
			response.sendRedirect("DanhSachMayServlet");
		}
		
		
		// SỬA DỊCH VỤ
		if(chucNang.equals("submitSuaDV")) { // nhấn nút Xác nhận Sửa Thông Tin DV ở trang SuaThongTin.jsp
			String tenDV = request.getParameter("tenDV");
			String donViTinh = request.getParameter("donViTinh");
			int donGia = Integer.valueOf(request.getParameter("donGia"));
			DichVuBO.suaThongTinDV(maDV, tenDV, donViTinh, donGia);
			response.sendRedirect("DanhSachDVServlet");
		} 
		if(chucNang.equals("suaDV")) {  // chuyển đến trang SuaThongTin.jsp từ trang DanhSachDichVu.jsp
			request.setAttribute("suaTT", "suaTTDV");
			request.setAttribute("DVSuaTT", dichVu);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SuaThongTin.jsp");
			dispatcher.forward(request, response);
		}
		
		
		// SỬA KHÁCH HÀNG
		if(chucNang.equals("submitSuaKH")) { // nhấn nút Xác nhận Sửa Thông Tin Khách Hàng ở trang SuaThongTin.jsp
			String tenKH = request.getParameter("tenKH");
			String diaChi = request.getParameter("diaChi");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			KhachHangBO.suaThongTinKH(maKH, tenKH, diaChi, sdt, email);
			response.sendRedirect("DanhSachKHServlet");
		} 
		if(chucNang.equals("suaKH")) {  // chuyển đến trang SuaThongTin.jsp từ trang DanhSachKH.jsp
			request.setAttribute("suaTT", "suaTTKH");
			request.setAttribute("KHSuaTT", khachHang);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SuaThongTin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
