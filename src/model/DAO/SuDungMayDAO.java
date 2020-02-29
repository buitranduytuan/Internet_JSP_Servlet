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

public class SuDungMayDAO {
	public static void taoDKSuDungMay(String maKH, String maMay, String ngayBDSuDung, String gioBDSuDung, int thoiGianSD) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "INSERT INTO SuDungMay(MaKH, MaMay, NgayBDSuDung, GioBDSuDung, ThoiGianSuDung) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, maMay);
			ps.setString(3, ngayBDSuDung);
			ps.setString(4, gioBDSuDung);
			ps.setInt(5, thoiGianSD);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
