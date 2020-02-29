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

import model.BO.ThongTinKhachHangSuDungMayVaDVBO;
import model.bean.ThongTinKhachHangSuDungMayVaDV;

/**
 * Servlet implementation class ThongTinKhachHangSuDungMayVaDVServlet
 */
@WebServlet("/ThongTinKhachHangSuDungMayVaDVServlet")
public class ThongTinKhachHangSuDungMayVaDVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinKhachHangSuDungMayVaDVServlet() {
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
		
		ArrayList<ThongTinKhachHangSuDungMayVaDV> listThongTin = ThongTinKhachHangSuDungMayVaDVBO.getThongTinKHSuDung();
		request.setAttribute("listThongTin", listThongTin);
		RequestDispatcher rd = request.getRequestDispatcher("LietKeToanBoThongTin.jsp");
		rd.forward(request, response);
	}
}
