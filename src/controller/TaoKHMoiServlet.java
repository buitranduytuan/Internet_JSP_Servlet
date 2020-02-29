package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.KhachHangBO;

/**
 * Servlet implementation class TaoKHMoiServlet
 */
@WebServlet("/TaoKHMoiServlet")
public class TaoKHMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaoKHMoiServlet() {
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

		if("submitTaoKH".equals(request.getParameter("submit"))) { //nhan vao nut submit o trang TaoKH.jsp
			String maKH = request.getParameter("maKH");
			if(KhachHangBO.kiemTraTonTaiMaKH(maKH)) {
				request.setAttribute("error", "Mã Khách Hàng đã tồn tại");
				RequestDispatcher rd = request.getRequestDispatcher("TaoKH.jsp");
				rd.forward(request, response);
			}
			String tenKH = request.getParameter("tenKH");
			String diaChi = request.getParameter("diaChi");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			KhachHangBO.taoMoiKH(maKH, tenKH, diaChi, sdt, email);
			response.sendRedirect("DanhSachKHServlet");

		} else {  // nhấn vào liên kết Tạo Khách Hàng trên thanh Nav
			RequestDispatcher rd = request.getRequestDispatcher("TaoKH.jsp");
			rd.forward(request, response);
		}
	}

}
