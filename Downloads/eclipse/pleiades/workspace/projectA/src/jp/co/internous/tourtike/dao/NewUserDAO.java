package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * NewUserDAO
 * ニューユーザーダオ
 * @author 半田晃邦
 * @since 2015/03/06
 * @version 1.0
 */
public class NewUserDAO {

	Connection con = null;

	public boolean select(String user_id) throws SQLException {
		boolean result = true;
		int check = 0;
		con = DBconnector.getConnection();
		try {
			String sql = "select * from user_info where user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				check++;
			}
			if (check > 0) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}

	/**
	 * 新規会員基本情報登録メソッド
	 * @return recount 登録件数
	 */
	public int insert(String user_id, String user_pass, String last_name,
			String first_name, String user_mail, String gender, String birthday,
			String user_ip) throws Exception {
		con = DBconnector.getConnection();
		int rsCount = 0;
		try {
			String sql = "insert into user_info(user_id,user_pass,last_name,first_name,user_mail,gender,birthday,user_ip,register_date) value(?,?,?,?,?,?,?,?,now())";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_id);
			ps2.setString(2, user_pass);
			ps2.setString(3, last_name);
			ps2.setString(4, first_name);
			ps2.setString(5, user_mail);
			ps2.setString(6, gender);
			ps2.setString(7, birthday);
			ps2.setString(8, user_ip);

			rsCount = ps2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount;
	}

	/**
	 * 新規会員住所情報登録メソッド
	 * @return recount 登録件数
	 */
	public int insert2(String user_id, String zipcode, String addr1,
			String addr2, String addr3) throws Exception {
		con = DBconnector.getConnection();

		int rsCount2 = 0;
		try {
			String sql = "insert into user_address(user_id,zipcode,prefecture,citytown,house_number) value(?,?,?,?,?)";

			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_id);
			ps2.setString(2, zipcode);
			ps2.setString(3, addr1);
			ps2.setString(4, addr2);
			ps2.setString(5, addr3);

			rsCount2 = ps2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return rsCount2;
	}
}