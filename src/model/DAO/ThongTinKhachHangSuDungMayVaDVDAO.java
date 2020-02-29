/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ThongTinKhachHangSuDungMayVaDV;
import model.utils.ConnectionDB;

public class ThongTinKhachHangSuDungMayVaDVDAO {
	public static String kiemTraNull(String val) {
		if(val!=null)
			return val;
		return "";
	};
	
	
	public static String subStringThoiGian(String thoiGian) {
		String val = "";
		if(thoiGian.equals("")==false)
			val = thoiGian.substring(0, 8);
		return val;
	}
	
	public static ArrayList<ThongTinKhachHangSuDungMayVaDV> getThongTinKHSuDung() {
		ArrayList<ThongTinKhachHangSuDungMayVaDV> listThongTin = new ArrayList<ThongTinKhachHangSuDungMayVaDV>();
		Connection conn = ConnectionDB.getMyConnect();
		/*
		 * Mã KH, Tên KH, Mã máy, Vị trí, Trạng thái, Ngày bắt đầu sử dụng máy, Giờ bắt
		 * đầu sử dụng máy, Thời gian sử dụng máy, Mã dịch vụ, Ngày sử dụng dịch vụ, Giờ sử dụng dịch vụ, Số lượng, Tổng tiền.
		 */
		String sql = "SELECT KH.MaKH, TenKH, May.MaMay, ViTri, TrangThai, NgayBDSuDung, GioBDSuDung, ThoiGianSuDung, DichVu.MaDV, NgaySuDung, GioSuDung, SoLuong, " + 
				"(SELECT SUM(SoLuong*DonGia) FROM KhachHang KH1 INNER JOIN SuDungDichVu SDDV ON KH1.MaKH = SDDV.MaKH " + 
				"INNER JOIN DichVu ON SDDV.MaDV = DichVu.MaDV WHERE KH1.MaKH = KH.MaKH GROUP BY KH1.MaKH) AS TongTien " + 
				"FROM (KhachHang KH " + 
				"LEFT JOIN (SuDungMay INNER JOIN May ON SuDungMay.MaMay = may.MaMay) ON KH.MaKH = SuDungMay.MaKH) " + 
				"LEFT JOIN (SuDungDichVu SDDV INNER JOIN DichVu ON SDDV.MaDV = DichVu.MaDV) ON KH.MaKH = SDDV.MaKH " + 
				"WHERE ThoiGianSuDung IS NOT NULL OR SoLuong IS NOT NULL";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThongTinKhachHangSuDungMayVaDV thongTin = new ThongTinKhachHangSuDungMayVaDV();
				thongTin.setMaKH(rs.getString("MaKH"));
				thongTin.setTenKH(rs.getString("TenKH"));
				thongTin.setMaMay(kiemTraNull(rs.getString("MaMay")));
				thongTin.setViTri(kiemTraNull(rs.getString("ViTri")));
				thongTin.setTrangThai(kiemTraNull(rs.getString("TrangThai")));
				thongTin.setNgayBDSDMay(kiemTraNull(rs.getString("NgayBDSuDung")));
				thongTin.setGioBDSDMay(kiemTraNull(rs.getString("GioBDSuDung")));
				thongTin.setThoiGianSDMay(kiemTraNull(rs.getString("ThoiGianSuDung")));
				thongTin.setMaDV(kiemTraNull(rs.getString("MaDV")));
				thongTin.setNgaySD(kiemTraNull(rs.getString("NgaySuDung")));
				thongTin.setGioSD(kiemTraNull(rs.getString("GioSuDung")));
				thongTin.setSoLuong(Integer.valueOf(rs.getInt("SoLuong")));
				thongTin.setTongTien(Integer.valueOf(rs.getInt("TongTien")));
				listThongTin.add(thongTin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThongTin;
	}
}
