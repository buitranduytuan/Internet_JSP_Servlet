package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.MayBO;

/**
 * Servlet implementation class TaoMayMoiServlet
 */
@WebServlet("/TaoMayMoiServlet")
public class TaoMayMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaoMayMoiServlet() {
		super();
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
		
		
		if("submitTaoMay".equals(request.getParameter("submit"))) { //nhan vao nut submit o trang taomay.jsp
			String maMay = request.getParameter("maMay");
			if(MayBO.kiemTraTonTaiMaMay(maMay)) {
				request.setAttribute("error", "Mã máy đã tồn tại");
				RequestDispatcher rd = request.getRequestDispatcher("Taomay.jsp");
				rd.forward(request, response);
			}
			String viTri = request.getParameter("viTri");
			String trangThai = request.getParameter("trangThai");
			MayBO.taoMayMoi(maMay, viTri, trangThai);
			response.sendRedirect("DanhSachMayServlet");

		} else {  // nhấn vào liên kết Tạo máy mới trên thanh Nav
			request.setAttribute("error", "");
			RequestDispatcher rd = request.getRequestDispatcher("Taomay.jsp");
			rd.forward(request, response);
		}
	}

}
