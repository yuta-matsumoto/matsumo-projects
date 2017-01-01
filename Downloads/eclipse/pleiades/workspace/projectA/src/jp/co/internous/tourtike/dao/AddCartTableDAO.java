package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AddCartTableDAO
 * アドカートテーブルダオ
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class AddCartTableDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public int rsCount;

	/**
	 * 実行メソッド
	 * @return resCount 実行結果
	 */
	public int insert(String user_ip, String mac_address, String user_id,
			int ticket_id, String ticket_name, int ticket_count,
			int total_amount, int token) throws SQLException {
		con = DBconnector.getConnection();

		String sql = "insert into cart(user_ip,mac_address,user_id,ticket_id,ticket_name,ticket_count,total_amount,token)values(?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user_ip);
			ps.setString(2, mac_address);
			ps.setString(3, user_id);
			ps.setInt(4, ticket_id);
			ps.setString(5, ticket_name);
			ps.setInt(6, ticket_count);
			ps.setInt(7, total_amount);
			ps.setInt(8, token);
			rsCount = ps.executeUpdate();

			if (rsCount != 1) {
				return rsCount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}
}