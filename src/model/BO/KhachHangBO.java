/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import java.util.ArrayList;

import model.DAO.KhachHangDAO;
import model.bean.KhachHang;

public class KhachHangBO {
	public static void taoMoiKH(String maKH, String tenKH, String diaChi, String sdt, String email) {
		KhachHangDAO.taoMoiKH(maKH, tenKH, diaChi, sdt, email);
	}
	
	public static ArrayList<KhachHang> getDanhSachKH(){
		return KhachHangDAO.getDanhSachKH();
	}
	
	public static void suaThongTinKH(String maKH, String tenKH, String diaChi, String sdt, String email) {
		KhachHangDAO.suaThongTinKH(maKH, tenKH, diaChi, sdt, email);
	}
	
	public static KhachHang getThongTinKH(String maKH) {
		return KhachHangDAO.getThongTinKH(maKH);
	}
	
	public static void xoaThongTinKH(String maKH) {
		KhachHangDAO.xoaThongTinKH(maKH);
	}
	
	public static ArrayList<String> getListMaKH(){
		return KhachHangDAO.getListMaKH();
	}
	
	public static boolean kiemTraTonTaiMaKH(String maKH) {
		return KhachHangDAO.kiemTraTonTaiMaKH(maKH);
	}
}
