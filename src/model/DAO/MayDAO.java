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

import model.bean.May;
import model.utils.ConnectionDB;

public class MayDAO {
	public static void taoMayMoi(String maMay, String viTri, String trangThai) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql = String.format("INSERT INTO May(MaMay, ViTri, TrangThai) VALUES ('%s',N'%s', N'%s')", maMay, viTri, trangThai);
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<May> getDanhSachMay(){
		ArrayList<May> listDSMay = new ArrayList<May>();
		May may;
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT * FROM May";
		try {
			Statement statement = conn.createStatement();	
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maMay = rs.getString("MaMay");
				String viTri = rs.getString("ViTri");
				String trangThai = rs.getString("TrangThai");
				may = new May(maMay, viTri, trangThai);
				listDSMay.add(may);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listDSMay;
	}
	
	public static void suaThongTinMay(String maMay, String trangThai, String viTri) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="UPDATE May SET TrangThai = ? , ViTri = ? WHERE MaMay = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, trangThai);
			ps.setString(2, viTri);
			ps.setString(3, maMay);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static May getThongTinMay(String maMay) {
		May may = new May();
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="SELECT * FROM May WHERE MaMay = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMay);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				may.setMaMay(maMay);
				may.setTrangThai(rs.getString("TrangThai"));
				may.setViTri(rs.getString("ViTri"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return may;
	}
	
	public static void xoaThongTinMay(String maMay) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="DELETE FROM May WHERE MaMay = ?";
		String sql2 ="DELETE FROM SuDungMay WHERE MaMay = ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMay);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, maMay);
			ps2.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getListMaMay(){
		ArrayList<String> listMaMay = new ArrayList<String>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT MaMay FROM May";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maMay = rs.getString("MaMay");
				listMaMay.add(maMay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listMaMay;
	}
	
	public static boolean kiemTraTonTaiMaMay(String maMay) {
		boolean check = false;
		ArrayList<String> listMaMay = getListMaMay();
		for(String ma: listMaMay) {
			if(maMay.equals(ma))
				check = true;
		}
		return check;
	}
	
	public static boolean kiemTraMaMayRanh(String maMay) {
		boolean check = false;
		ArrayList<String> listMaMayDR = getListMaMayDangRanh();
		for(String ma: listMaMayDR) {
			if(maMay.equals(ma))
				check = true;
		}
		return check;
	}
	
	public static ArrayList<String> getListMaMayDangRanh(){
		ArrayList<String> listMaMayDR = new ArrayList<String>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT MaMay FROM May WHERE TrangThai = N'Đang Rảnh'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maMay = rs.getString("MaMay");
				listMaMayDR.add(maMay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listMaMayDR;
	}
}
