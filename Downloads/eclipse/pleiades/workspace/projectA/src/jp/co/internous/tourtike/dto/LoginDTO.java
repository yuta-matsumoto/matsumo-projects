package jp.co.internous.tourtike.dto;
/**
 * LoginDTO
 * ログインディーティーオー
 * @author 林美希
 * @since 2015/03/13
 *@version 1.0
 */
public class LoginDTO {

	public String user_name;
	public String user_id;
	public String user_pass;

	/**
	 * user_name登録メソッド
	 * @return user_name ユーザー名
	 */
	public void setUserName(String user_name){
		this.user_name=user_name;
	}

	/**
	 * user_name取得メソッド
	 * @return user_name ユーザー名
	 */
	public String getUserName(){
		return user_name;
	}

	/**
	 * user_id登録メソッド
	 * @return user_id ユーザーID
	 */
	public void setUserID(String user_id){
		this.user_id=user_id;
	}

	/**
	 * user_id取得メソッド
	 * @return user_id ユーザーID
	 */
	public String getUserID(){
		return user_id;
	}

	/**
	 * user_pass登録メソッド
	 * @return user_pass ユーザーパス
	 */
	public void setUserPass(String user_pass){
		this.user_pass=user_pass;
	}

	/**
	 * user_pass取得メソッド
	 * @return user_pass ユーザーパス
	 */
	public String getUserPass(){
		return user_pass;
	}
}
