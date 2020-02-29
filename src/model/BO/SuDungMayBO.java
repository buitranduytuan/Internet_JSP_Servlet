/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import model.DAO.SuDungMayDAO;

public class SuDungMayBO {
	public static void taoDKSuDungMay(String maKH, String maMay, String ngayBDSuDung, String gioBDSuDung, int thoiGianSD) {
		SuDungMayDAO.taoDKSuDungMay(maKH, maMay, ngayBDSuDung, gioBDSuDung, thoiGianSD);
	}
	
}
