/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.utils.ConnectionDB;

public class SuDungDichVuDAO {
	
	public static void taoDKSuDungDichVu(String maKH, String maDV, String ngaySD, String gioSD, int soLuong) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "INSERT INTO SuDungDichVu(MaKH, MaDV, NgaySuDung, GioSuDung, SoLuong) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, maDV);
			ps.setString(3, ngaySD);
			ps.setString(4, gioSD);
			ps.setInt(5, soLuong);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
