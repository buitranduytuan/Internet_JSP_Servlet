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
import model.DAO.DichVuDAO;
import model.bean.DichVu;
import model.bean.KhachHang;
import model.bean.May;

/**
 * Servlet implementation class XoaThongTinServlet
 */
@WebServlet("/XoaThongTinServlet")
public class XoaThongTinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaThongTinServlet() {
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
		request.setCharacterEncoding("UTF-8");
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			request.setAttribute("login", "Bạn phải đăng nhập trước khi sử dụng trang Web!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
		String maMay = request.getParameter("maMay");
		May may = MayBO.getThongTinMay(maMay);
		String maDV = request.getParameter("maDV");
		DichVu dichVu = DichVuDAO.getThongTinDV(maDV);
		String maKH = request.getParameter("maKH");
		KhachHang khachHang = KhachHangBO.getThongTinKH(maKH);
		String chucNang = request.getParameter("chucNang");
		
		// nhấn nút Xác nhận Xóa Thông Tin Máy từ trang Delete.jsp
		if(chucNang.equals("submitXoaMay")) { 
			MayBO.xoaThongTinMay(maMay);
			response.sendRedirect("DanhSachMayServlet");
		}
		// chuyển đến trang Xóa thông tin từ trang DanhSachMay.jsp
		if(chucNang.equals("xoaMay")) { 
			request.setAttribute("xoaTT", "xoaTTMay");
			request.setAttribute("MayXoaTT", may);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Delete.jsp");
			dispatcher.forward(request, response);
		}
		// nhấn nút Xác nhận xoa Thông Tin Dịch Vụ từ trang Delete.jsp
		if(chucNang.equals("submitXoaDV")) {
			DichVuBO.xoaThongTinDV(maDV);
			response.sendRedirect("DanhSachDVServlet");
		}
		// chuyển đến trang Xóa thông tin từ trang DanhSachDichVu.jsp
		if(chucNang.equals("xoaDV")) {
			request.setAttribute("xoaTT", "xoaTTDV");
			request.setAttribute("DVXoaTT", dichVu);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Delete.jsp");
			dispatcher.forward(request, response);
		}
		// nhấn nút Xác nhận xóa Thông Tin Khách Hàng từ trang Delete.jsp
		if(chucNang.equals("submitXoaKH")) {
			KhachHangBO.xoaThongTinKH(maKH);
			response.sendRedirect("DanhSachKHServlet");
		}
		// chuyển đến trang Xóa thông tin từ trang DanhSachKH.jsp
		if(chucNang.equals("xoaKH")) {
			request.setAttribute("xoaTT", "xoaTTKH");
			request.setAttribute("KHXoaTT", khachHang);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Delete.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
