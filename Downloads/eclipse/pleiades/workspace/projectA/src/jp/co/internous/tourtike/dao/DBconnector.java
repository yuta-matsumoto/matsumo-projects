package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBconnector
 * ディービーコネクター
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class DBconnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/tourticket";
	private static String user = "root";
	private static String pass = "mysql";

	/**
	 * 接続メソッド
	 * @return con jdbcドライバ
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}