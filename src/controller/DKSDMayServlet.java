package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.KhachHangBO;
import model.BO.MayBO;
import model.BO.SuDungMayBO;

/**
 * Servlet implementation class DKSDMayServlet
 */
@WebServlet("/DKSDMayServlet")
public class DKSDMayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DKSDMayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			request.setAttribute("login", "Bạn phải đăng nhập trước khi sử dụng trang Web!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
				
		ArrayList<String> listMaMayDR = MayBO.getListMaMayDangRanh();
		ArrayList<String> listMaKH = KhachHangBO.getListMaKH();
		request.setAttribute("listMaMayDR", listMaMayDR);
		request.setAttribute("listMaKH", listMaKH);
		
		if ("sumitDKSDMay".equals(request.getParameter("submit"))) { // nhan vao nut submit o trang DKSuDungMay.jsp
			String maKH = request.getParameter("maKH");
			String maMay = request.getParameter("maMay");
			String ngayBD = request.getParameter("ngayBD");
			String gioBD = request.getParameter("gioBD");
			int thoiGianSD = Integer.valueOf(request.getParameter("thoiGianSD"));
			
			if (KhachHangBO.kiemTraTonTaiMaKH(maKH) && MayBO.kiemTraMaMayRanh(maMay) ) {
				SuDungMayBO.taoDKSuDungMay(maKH, maMay, ngayBD, gioBD, thoiGianSD);
				String viTri = MayBO.getThongTinMay(maMay).getViTri();
				MayBO.suaThongTinMay(maMay, "Có người dùng", viTri);
				response.sendRedirect("ThongTinKhachHangSuDungMayVaDVServlet");
			} else {
				if (KhachHangBO.kiemTraTonTaiMaKH(maKH) == false && MayBO.kiemTraMaMayRanh(maMay) == true) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Khách Hàng không tồn tại. Mời nhập lại");
				} else if (KhachHangBO.kiemTraTonTaiMaKH(maKH) == true && MayBO.kiemTraTonTaiMaMay(maMay) == false) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Máy không tồn tại. Mời nhập lại");
				} else if(KhachHangBO.kiemTraTonTaiMaKH(maKH) && MayBO.kiemTraTonTaiMaMay(maMay)&& MayBO.kiemTraMaMayRanh(maMay)==false ) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Máy đã có người dùng hoặc đang sửa chữa. Mời nhập lại.");
				}else if(KhachHangBO.kiemTraTonTaiMaKH(maKH)==false && MayBO.kiemTraTonTaiMaMay(maMay)&& MayBO.kiemTraMaMayRanh(maMay)==false ) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Khách Hàng không tồn tại. Mã Máy đã có người dùng hoặc đang sửa chữa. Mời nhập lại.");
				}
				else {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Khách Hàng và Mã Máy không tồn tại. Mời nhập lại");
				}

				RequestDispatcher rd = request.getRequestDispatcher("DKSuDungMay.jsp");
				rd.forward(request, response);
			}

		} else { // nhấn vào liên kết Tạo máy mới trên thanh Nav
			request.setAttribute("thongBaoLoi", "");
			RequestDispatcher rd = request.getRequestDispatcher("DKSuDungMay.jsp");
			rd.forward(request, response);
		}
	}

}
