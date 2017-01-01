package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * DeleteCartTableDAO
 * デリートカートテーブルダオ
 * @author 松本雄太
 * @since 2015/03/13
 * @version 1.0
 */
public class DeleteCartTableDAO {
	Connection con;
	boolean result;

	/**
	 * カートテーブル情報削除メソッド1
	 * @return rsCount 削除件数
	 * @throws Exception
	 */
	public int delete(String mac_address, String user_ip, int token)
			throws Exception {
		con = DBconnector.getConnection();
		int rsCount = 0;
		try {
			String sql = "DELETE FROM cart where user_ip=? AND mac_address=? AND token=?";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_ip);
			ps2.setString(2, mac_address);
			ps2.setInt(3, token);
			rsCount = ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}

	/**
	 * カートテーブル情報削除メソッド2
	 * @return rsCount 削除件数
	 * @throws Exception
	 */
	public int delete2(String mac_address, String user_ip)
			throws Exception {
		con = DBconnector.getConnection();
		int rsCount = 0;
		try {
			String sql = "DELETE FROM cart where user_ip=? AND mac_address=?";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_ip);
			ps2.setString(2, mac_address);
			rsCount = ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}

	/**
	 * カートテーブル情報更新メソッド
	 * @return rsCount 更新件数
	 * @throws Exception
	 */
	public int update(int update_id, int update_number) throws Exception {
		con = DBconnector.getConnection();
		int rsCount = 0;
		try {
			String sql = "update ticket set stock = stock - ? where ticket_id=?";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setInt(1, update_number);
			ps2.setInt(2, update_id);
			rsCount = ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}
}