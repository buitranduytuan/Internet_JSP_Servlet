/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import model.DAO.SuDungDichVuDAO;

public class SuDungDichVuBO {
	public static void taoDKSuDungDichVu(String maKH, String maDV, String ngaySD, String gioSD, int soLuong) {
		SuDungDichVuDAO.taoDKSuDungDichVu(maKH, maDV, ngaySD, gioSD, soLuong);
	}
}
