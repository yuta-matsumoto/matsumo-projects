package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.tourtike.dto.CartAddDTO;

/**
 * RetrunTopDAO
 * リターントップダオ
 * @author 佐藤裕也
 * @since 2015/03/13
 * @version 1.0
 */
public class ReturnTopDAO {

	List<CartAddDTO> cartList = new ArrayList<CartAddDTO>();
	private Connection con;

	/**
	 * テンポラリーテーブル検索メソッド
	 * @return cartlist カートリスト情報
	 * @throws Exception
	 */
	public int select(String mac_address, String user_ip, int token) throws Exception {
		int rsCount = 0;
		con = DBconnector.getConnection();

		try {
			String sql = "SELECT * FROM cart where user_ip=? AND mac_address=? AND token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_ip);
			ps.setString(2, mac_address);
			ps.setInt(3, token);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rsCount++;
				CartAddDTO dto = new CartAddDTO();
				dto.setTicket_id(rs.getInt(4));
				dto.setTicket_name(rs.getString(5));
				dto.setPrice(rs.getInt(7) / rs.getInt(6));
				dto.setTicket_count(rs.getInt(6));
				dto.setTotal_amount(rs.getInt(7));
				cartList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}

	/**
	 * テンポラリーテーブル削除メソッド
	 * @return rscount 削除件数
	 * @throws SQLException
	 */
	public int delete(String mac_address, String user_ip) throws SQLException {
		int rsCount = 0;
		con = DBconnector.getConnection();

		String sql = "delete from cart where user_ip=? AND mac_address=?";

		try {
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_ip);
			ps2.setString(2, mac_address);
			rsCount = ps2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}

	/**
	 * カートリスト情報取得メソッド
	 * @return cartlist カートリスト情報
	 */
	public List<CartAddDTO> getCartlist() {
		return cartList;
	}
}