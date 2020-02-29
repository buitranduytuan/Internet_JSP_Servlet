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

import model.BO.DichVuBO;
import model.BO.KhachHangBO;
import model.BO.SuDungDichVuBO;
import model.BO.ValidateBO;

/**
 * Servlet implementation class DKSDDichVuServlet
 */
@WebServlet("/DKSDDichVuServlet")
public class DKSDDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DKSDDichVuServlet() {
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
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			request.setAttribute("login", "Bạn phải đăng nhập trang Web trước khi sử dụng!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
				
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> listMaDV = DichVuBO.getListMaDV();
		ArrayList<String> listMaKH = KhachHangBO.getListMaKH();
		request.setAttribute("listMaDV", listMaDV);
		request.setAttribute("listMaKH", listMaKH);
		
		if ("sumitDKSDDV".equals(request.getParameter("submit"))) { // nhan vao nut submit o trang DKSuDungDV.jsp
			String maKH = request.getParameter("maKH");
			String maDV = request.getParameter("maDV");
			String ngaySD = request.getParameter("ngaySD");
			String gioSD = request.getParameter("gioSD");
			String numberSt = request.getParameter("soLuong");
			int soLuong = 0;
			if(ValidateBO.validateNumber(numberSt)== false) {
				request.setAttribute("errorNumber", "Hãy nhập một số");
				RequestDispatcher rd = request.getRequestDispatcher("DKSuDungDV.jsp");
				rd.forward(request, response);
			} else {
				soLuong = Integer.valueOf(numberSt);
			}
			
			if(ValidateBO.validateMaKH(maKH)==false) {
				request.setAttribute("thongBaoLoi", "Lỗi: Nhập mã Khách hàng không đúng định dạng.");
			}
			
			if(ValidateBO.validateMaDV(maDV)==false) {
				request.setAttribute("thongBaoLoi", "Lỗi: Nhập mã Dịch vụ không đúng định dạng.");
			}
			
			// kiem tra MaKH va MaDV co ton tai ko .Neu co thi insert DB - khong thi thong bao loi
			if (KhachHangBO.kiemTraTonTaiMaKH(maKH) && DichVuBO.kiemTraTonTaiMaDV(maDV)) {
				SuDungDichVuBO.taoDKSuDungDichVu(maKH, maDV, ngaySD, gioSD, soLuong);
				response.sendRedirect("ThongTinKhachHangSuDungMayVaDVServlet");
			} else {
				if (KhachHangBO.kiemTraTonTaiMaKH(maKH) == false && DichVuBO.kiemTraTonTaiMaDV(maDV) == true ) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Khách Hàng không tồn tại. Mời nhập lại.");
				} else 
					if (KhachHangBO.kiemTraTonTaiMaKH(maKH) == true && DichVuBO.kiemTraTonTaiMaDV(maDV) == false) {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Dịch Vụ không tồn tại. Mời nhập lại.");
				} else {
					request.setAttribute("thongBaoLoi", "Lỗi: Mã Khách Hàng và Dịch Vụ không tồn tại. Mời nhập lại.");
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("DKSuDungDV.jsp");
				rd.forward(request, response);
			}

		} else {// nhan vao lien ket Dang ky Su dung May tren thanh Nav
			request.setAttribute("thongBaoLoi", "");
			RequestDispatcher rd = request.getRequestDispatcher("DKSuDungDV.jsp");
			rd.forward(request, response);
		}
	}

}
