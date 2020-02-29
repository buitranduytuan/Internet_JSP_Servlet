/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import java.util.ArrayList;

import model.DAO.ThongTinKhachHangSuDungMayVaDVDAO;
import model.bean.ThongTinKhachHangSuDungMayVaDV;

public class ThongTinKhachHangSuDungMayVaDVBO {
	public static ArrayList<ThongTinKhachHangSuDungMayVaDV> getThongTinKHSuDung(){
		return ThongTinKhachHangSuDungMayVaDVDAO.getThongTinKHSuDung();
	}
}
