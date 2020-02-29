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
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DichVu;
import model.utils.ConnectionDB;

public class DichVuDAO {
	public static void taoMoiDV(String maDV, String tenDV, String donViTinh, int donGia) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "INSERT INTO DichVu(MaDV, TenDV, DonViTinh, DonGia) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maDV);
			ps.setString(2, tenDV);
			ps.setString(3, donViTinh);
			ps.setInt(4, donGia);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<DichVu> getDanhSachDV(){
		ArrayList<DichVu> listDSDV = new ArrayList<DichVu>();
		DichVu dv;
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT * FROM DichVu";
		try {
			Statement statement = conn.createStatement();	
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maDV = rs.getString("MaDV");
				String tenDV = rs.getString("TenDV");
				String donViTinh = rs.getString("DonViTinh");
				int donGia = rs.getInt("DonGia");
				dv = new DichVu(maDV, tenDV, donViTinh, donGia);
				listDSDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listDSDV;
	}
	
	public static void suaThongTinDV(String maDV, String tenDV, String donViTinh, int donGia) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="UPDATE DichVu SET TenDV = ? , DonViTinh = ?, DonGia = ? WHERE MaDV = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tenDV);
			ps.setString(2, donViTinh);
			ps.setInt(3, donGia);
			ps.setString(4, maDV);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DichVu getThongTinDV(String maDV) {
		DichVu dv = new DichVu();
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="SELECT * FROM DichVu WHERE MaDV = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maDV);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dv.setMaDV(maDV);
				dv.setTenDV(rs.getString("TenDV"));
				dv.setDonViTinh(rs.getString("DonViTinh"));
				dv.setDonGia(rs.getInt("DonGia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dv;
	}
	
	public static void xoaThongTinDV(String maDV) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="DELETE FROM DichVu WHERE MaDV = ?";
		String sql2 ="DELETE FROM SuDungDichVu WHERE MaDV = ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maDV);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, maDV);
			ps2.executeUpdate();
			conn.commit();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getListMaDV(){
		ArrayList<String> listMaDV = new ArrayList<String>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT MaDV FROM DichVu";
		try {
			Statement statement = conn.createStatement();	
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maDV = rs.getString("MaDV");
				listMaDV.add(maDV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMaDV;
	}
	
	public static boolean kiemTraTonTaiMaDV(String maDV) {
		boolean check = false;
		ArrayList<String> listMaDV = getListMaDV();
		for(String ma: listMaDV) {
			if(maDV.equals(ma))
				check = true;
		}
		return check;
	}
}
