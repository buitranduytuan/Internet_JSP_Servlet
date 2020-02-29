package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.AccountBO;

/**
 * Servlet implementation class DangNhapServlet
 */
//@WebServlet(urlPatterns = { "/DangNhapServlet", "/xxx" })
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
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
		HttpSession session = request.getSession();
		
		// Đăng nhập rồi thì không cần đến trang đăng nhập nữa
		if(session.getAttribute("userName")!=null) {
			response.sendRedirect("DanhSachMayServlet");
			return;
		}
		
		if("submitLogin".equals(request.getParameter("submitLG"))) { //nhan vao nut submit o trang Login.jsp
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			if(AccountBO.checkLogin(userName, password)){
				session.setAttribute("userName", userName);
				response.sendRedirect("DanhSachMayServlet");
			} else {
				request.setAttribute("error", "Đăng nhập không thành công. Tên đăng nhập hoặc mật khẩu không đúng.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

		} else {  // chưa đăng nhập mà chuyển đến các trang khác thì phải quay về để đăng nhập trước
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
