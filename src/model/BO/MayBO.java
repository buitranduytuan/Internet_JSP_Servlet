/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import java.util.ArrayList;

import model.DAO.MayDAO;
import model.bean.May;

public class MayBO {
	public static void taoMayMoi(String maMay, String viTri, String trangThai) {
		MayDAO.taoMayMoi(maMay, viTri, trangThai);
	}
	
	public static ArrayList<May> getDanhSachMay(){
		return MayDAO.getDanhSachMay();
	}
	
	public static void suaThongTinMay(String maMay, String trangThai, String viTri) {
		MayDAO.suaThongTinMay(maMay, trangThai, viTri);
	}
	
	public static May getThongTinMay(String maMay) {
		return MayDAO.getThongTinMay(maMay);
	}
	
	public static void xoaThongTinMay(String maMay) {
		MayDAO.xoaThongTinMay(maMay);
	}
	
	public static ArrayList<String> getListMaMay(){
		return MayDAO.getListMaMay();
	}
	
	public static boolean kiemTraTonTaiMaMay(String maMay) {
		return MayDAO.kiemTraTonTaiMaMay(maMay);
	}
	
	public static ArrayList<String> getListMaMayDangRanh(){
		return MayDAO.getListMaMayDangRanh();
	}
	
	public static boolean kiemTraMaMayRanh(String maMay) {
		return MayDAO.kiemTraMaMayRanh(maMay);
	}
}
