package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.tourtike.dto.GetCartDTO;

/**
 * GetCartDAO
 * ゲットカートダオ
 * @author 林美希
 * @since 2015/03/13
 * @version 1.0
 */
public class GetCartDAO {

	List<GetCartDTO> cartList = new ArrayList<GetCartDTO>();
	private Connection con;
	public boolean result;

	/**
	 * 実行メソッド
	 * @return result 実行結果
	 */
	public boolean select(String mac_address, String user_ip, int token)
			throws Exception {
		result = false;

		try {
			con = DBconnector.getConnection();
			String sql = "SELECT * FROM cart where user_ip=? AND mac_address=? AND token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_ip);
			ps.setString(2, mac_address);
			ps.setInt(3, token);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
				GetCartDTO dto = new GetCartDTO();
				dto.setUser_ip(rs.getString(1));
				dto.setMac_address(rs.getString(2));
				dto.setUser_id(rs.getString(3));
				dto.setTicket_id(rs.getInt(4));
				dto.setTicket_name(rs.getString(5));
				dto.setTicket_count(rs.getInt(6));
				dto.setTotal_amount(rs.getInt(7));
				cartList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	/**
	 * カート情報取得メソッド
	 * @return cartlist カート情報
	 */
	public List<GetCartDTO> getcartList() {
		return cartList;
	}
}
