/**
 *@author TuanBTD
 *@version version
 */

package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection getMyConnect() {
		Connection conn = null;
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=InternetDB;user=sa;password=sa";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, "sa", "sa");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}