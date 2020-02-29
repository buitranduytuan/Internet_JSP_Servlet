/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.BO;

import model.DAO.AccountDAO;

public class AccountBO {
	public static boolean checkLogin(String userName, String password) {
		return AccountDAO.checkLogin(userName, password);
	}
}
