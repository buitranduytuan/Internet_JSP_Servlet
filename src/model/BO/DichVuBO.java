/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import java.util.ArrayList;
import model.DAO.DichVuDAO;
import model.bean.DichVu;

public class DichVuBO {
	public static void taoMoiDV(String maDV, String tenDV, String donViTinh, int donGia) {
		DichVuDAO.taoMoiDV(maDV, tenDV, donViTinh, donGia);
	}
	
	public static ArrayList<DichVu> getDanhSachDV(){
		return DichVuDAO.getDanhSachDV();
	}
	
	public static void suaThongTinDV(String maDV, String tenDV, String donViTinh, int donGia) {
		DichVuDAO.suaThongTinDV(maDV, tenDV, donViTinh, donGia);
	}
	
	public static DichVu getThongTinDV(String maDV) {
		return DichVuDAO.getThongTinDV(maDV);
	}
	
	public static void xoaThongTinDV(String maDV) {
		DichVuDAO.xoaThongTinDV(maDV);
	}
	public static ArrayList<String> getListMaDV(){
		return DichVuDAO.getListMaDV();
	}
	
	public static boolean kiemTraTonTaiMaDV(String maDV) {
		return DichVuDAO.kiemTraTonTaiMaDV(maDV);
	}
}
