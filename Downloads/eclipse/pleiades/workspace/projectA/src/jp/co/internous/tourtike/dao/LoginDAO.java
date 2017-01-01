package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.internous.tourtike.dto.LoginDTO;

/**
 * LoginDAO
 * ログインダオ
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class LoginDAO {

	Connection con;
	public String DBuserName;
	public String DBuserID;
	public String DBuserPass;
	boolean result;

	/**
	 * 実行メソッド
	 * @return result 実行結果
	 */
	public boolean select(String user_id, String user_pass)throws Exception{
		result = false;
		con=DBconnector.getConnection();

		try{
			String sql = "select * from user_info where user_id=? AND user_pass=?";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1, user_id);
			ps2.setString(2, user_pass);
			ResultSet rs =ps2.executeQuery();
			while(rs.next()){
				result=true;
				LoginDTO dto = new LoginDTO();
				dto.setUserID(rs.getString(2));
				DBuserID=dto.getUserID();
				dto.setUserPass(rs.getString(3));
				DBuserPass=dto.getUserPass();
				dto.setUserName(rs.getString(4));
				DBuserName=dto.getUserName();
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
