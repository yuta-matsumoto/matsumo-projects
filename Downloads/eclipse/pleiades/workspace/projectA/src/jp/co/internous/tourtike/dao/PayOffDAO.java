package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.tourtike.dto.PayOffDTO;

/**
 * PeyOffDAO
 * ペイオフダオ
 * @author 林美希
 * @since 2015/03/13
 * @version 1.0
 */
public class PayOffDAO {

	PreparedStatement ps;
	public List<PayOffDTO> historyList = new ArrayList<PayOffDTO>();
	public List<PayOffDTO> cartList = new ArrayList<PayOffDTO>();

	private Connection con;
	public boolean result = false;

	/**
	 * 実行メソッド
	 * @return dto カート情報
	 */
	public boolean select(String mac_address, String user_ip, int token) throws Exception {

		con = DBconnector.getConnection();
		PayOffDTO dto = new PayOffDTO();
		try {
			String sql = "SELECT * FROM cart where user_ip=? AND mac_address=? AND token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_ip);
			ps.setString(2, mac_address);
			ps.setInt(3, token);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;

				dto.setUser_id(rs.getString(3));
				dto.setTicket_id(rs.getInt(4));
				dto.setTicket_count(rs.getInt(6));
				dto.setTotal_amount(rs.getInt(7));
				dto.setUser_ip(rs.getString(1));

				historyList.add(dto);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	/**
	 * 購入確定情報登録メソッド
	 * @return rscount 結果
	 * @throws Exception
	 */
	public int insert(String user_id, int ticket_id, int ticket_count,
			int total_amount, String user_ip) throws Exception {

		con = DBconnector.getConnection();

		String sql = "insert into history(user_id,ticket_id,ticket_count,total_amount,user_ip) value(?,?,?,?,?)";

		PreparedStatement ps2;
		ps2 = con.prepareStatement(sql);
		ps2.setString(1, user_id);
		ps2.setInt(2, ticket_id);
		ps2.setInt(3, ticket_count);
		ps2.setInt(4, total_amount);
		ps2.setString(5, user_ip);

		int rsCount = ps2.executeUpdate();

		if (con != null) {
			con.close();
		}
		return rsCount;
	}

	/**
	 * 購入確定アイテム情報取得メソッド
	 * @return historylist 購入確定アイテム情報
	 */
	public List<PayOffDTO> gethistorylist() {
		return historyList;
	}
}
