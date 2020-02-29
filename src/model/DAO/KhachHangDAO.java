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

import model.bean.KhachHang;
import model.utils.ConnectionDB;

public class KhachHangDAO {
	public static void taoMoiKH(String maKH, String tenKH, String diaChi, String sdt, String email) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "INSERT INTO KhachHang(MaKH, TenKH, DiaChi, SoDienThoai, Email) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, tenKH);
			ps.setString(3, diaChi);
			ps.setString(4, sdt);
			ps.setString(5, email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<KhachHang> getDanhSachKH(){
		ArrayList<KhachHang> listDSKH = new ArrayList<KhachHang>();
		KhachHang kh;
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT * FROM KhachHang";
		try {
			Statement statement = conn.createStatement();	
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maKH = rs.getString("MaKH");
				String tenKH = rs.getString("TenKH");
				String diaChi = rs.getString("DiaChi");
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				kh = new KhachHang(maKH, tenKH, diaChi, sdt, email);
				listDSKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listDSKH;
	}
	
	public static void suaThongTinKH(String maKH, String tenKH, String diaChi, String sdt, String email) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="UPDATE KhachHang SET TenKH = ? , DiaChi = ?, SoDienThoai = ?, Email = ? WHERE MaKH = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tenKH);
			ps.setString(2, diaChi);
			ps.setString(3, sdt);
			ps.setString(4, email);
			ps.setString(5, maKH);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static KhachHang getThongTinKH(String maKH) {
		KhachHang kh = new KhachHang();
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="SELECT * FROM KhachHang WHERE MaKH = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				kh.setMaKH(maKH);
				kh.setTenKH(rs.getString("TenKH"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSdt(rs.getString("SoDienThoai"));
				kh.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return kh;
	}
	
	public static void xoaThongTinKH(String maKH) {
		Connection conn = ConnectionDB.getMyConnect();
		String sql ="DELETE FROM KhachHang WHERE MaKH = ?";
		String sql2 ="DELETE FROM SuDungDichVu WHERE MaKH = ?";
		String sql3 ="DELETE FROM SuDungMay WHERE MaKH = ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, maKH);
			ps2.executeUpdate();
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setString(1, maKH);
			ps3.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getListMaKH(){
		ArrayList<String> listMaKH = new ArrayList<String>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT MaKH FROM KhachHang";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString("MaKH");
				listMaKH.add(maKH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMaKH;
	}
	public static ArrayList<String> searchListKH(String t){
		ArrayList<String> listMaKH = new ArrayList<String>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT * FROM KhachHang Where TenKH Like '%"+t+"%'OR MaKH Like '%"+t+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString("MaKH");
				listMaKH.add(maKH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMaKH;
	}
	public static boolean kiemTraTonTaiMaKH(String maKH) {
		boolean check = false;
		ArrayList<String> listMaKH = getListMaKH();
		for(String ma: listMaKH) {
			if(maKH.equals(ma))
				check = true;
		}
		return check;
	}
public static void main(String[] args) {
	System.out.println(searchListKH("05").size());
		/*
		 * ALTER TABLE table_name 
		 * ALTER COLUMN column_name datatype;
		 */
}
}
