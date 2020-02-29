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
import java.util.ArrayList;

import model.bean.Account;
import model.utils.ConnectionDB;

public class AccountDAO {
	public static ArrayList<Account> getListAccount() {
		ArrayList<Account> listAccount = new ArrayList<Account>();
		Connection conn = ConnectionDB.getMyConnect();
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setUserName(rs.getString("UserName"));
				account.setPassword(rs.getString("Password"));
				listAccount.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAccount;
	}

	public static boolean checkLogin(String userName, String password) {
		boolean check = false;
		ArrayList<Account> listAccount = getListAccount();
		for (Account account : listAccount) {
			if (userName.equals(account.getUserName()) && password.equals(account.getPassword())) {
				check = true;
			}
		}
		return check;
	}
}
