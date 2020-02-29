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

/**
 * Servlet implementation class TaoDVMoiServlet
 */
@WebServlet("/TaoDVMoiServlet")
public class TaoDVMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaoDVMoiServlet() {
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
				
		if("submitTaoDV".equals(request.getParameter("submit"))) { //nhan vao nut submit o trang TaoDichVu.jsp
			String maDV = request.getParameter("maDV");
			if(DichVuBO.kiemTraTonTaiMaDV(maDV)) {
				request.setAttribute("error", "Mã Dịch Vụ đã tồn tại");
				RequestDispatcher rd = request.getRequestDispatcher("TaoDichVu.jsp");
				rd.forward(request, response);
			}
			String tenDV = request.getParameter("tenDV");
			int donGia = Integer.valueOf(request.getParameter("donGia"));
			String donViTinh = request.getParameter("donViTinh");
			DichVuBO.taoMoiDV(maDV, tenDV, donViTinh, donGia);
			response.sendRedirect("DanhSachDVServlet");
		} else {  // nhấn vào liên kết Tạo máy mới trên thanh Nav
			RequestDispatcher rd = request.getRequestDispatcher("TaoDichVu.jsp");
			rd.forward(request, response);
		}
	}

}
