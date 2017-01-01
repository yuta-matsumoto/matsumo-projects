package jp.co.internous.tourtike.action;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.LoginDAO;
import jp.co.internous.tourtike.dao.NewUserDAO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * NewUserAction
 * ニューユーザーアクション
 * @author 半田晃邦
 * @since 2015/03/06
 * @version 1.0
 */
public class NewUserAction extends ActionSupport implements SessionAware {

	public String last_name;
	public String first_name;
	public String postal1;
	public String postal2;
	public String addr1;
	public String addr2;
	public String addr3;
	public String user_mail;
	public String gender;
	public String start_year;
	public String start_month;
	public String start_day;
	public String user_id;
	public String user_pass;
	public String user_pass2;

	public int count;
	public int count2;

	public String action = ERROR;
	public String msg = null;
	public String msg2 = null;
	public String msg3 = null;

	SessionMap<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String zipcode = postal1 + postal2;
		if (start_month.length() == 1) {
			start_month = "0" + start_month;
		}
		if (start_day.length() == 1) {
			start_day = "0" + start_day;
		}
		String birthday = start_year + start_month + start_day;

		int i = Integer.parseInt(birthday);

		Calendar cal1 = Calendar.getInstance();

		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH) + 1;
		int day = cal1.get(Calendar.DATE);

		String s1 = String.valueOf(year);
		String s2 = String.valueOf(month);
		String s3 = String.valueOf(day);

		if (s2.length() == 1) {
			s2 = "0" + s2;
		}
		if (s3.length() == 1) {
			s3 = "0" + s3;
		}

		String birthday2 = s1 + s2 + s3;

		int i2 = Integer.parseInt(birthday2);

		String ipaddr = getIP();
		NewUserDAO dao = new NewUserDAO();
		boolean daoCheck = dao.select(user_id);
		if (user_pass.equals(user_pass2)) {
			if (daoCheck && i2 >= i) {
				count = dao.insert(user_id, user_pass, last_name, first_name,
						user_mail, gender, birthday, ipaddr);
				if (count > 0) {
					count2 = dao.insert2(user_id, zipcode, addr1, addr2, addr3);
				}
				try {
					LoginDAO dao2 = new LoginDAO();
					if (dao2.select(user_id, user_pass)) {
						action = SUCCESS;
						sessionMap.put("userName", dao2.DBuserName);
						sessionMap.put("userId", dao2.DBuserID);
						sessionMap.put("userPass", dao2.DBuserPass);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (i >= i2 && !daoCheck) {
				msg = "※ログインIDが既に登録されています。";
				msg3 = "受精卵です。";
			} else if (i >= i2) {
				msg3 = "受精卵です。";
			} else if (!daoCheck) {
				msg = "※ログインIDが既に登録されています。";
			}
		} else {
			msg2 = "※パスワードと確認用パスワードが不一致です。";
		}
		return action;
	}

	/**
	 * IPアドレス取得メソッド
	 * @return ip IPアドレス
	 */
	public String getIP() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		return ip;
	}

	/**
	 * メッセージ取得メソッド
	 * @return msg メッセージ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * メッセージ取得メソッド2
	 * @return msg メッセージ2
	 */
	public String getMsg2() {
		return msg2;
	}

	/**
	 * メッセージ取得メソッド3
	 * @return msg メッセージ3
	 */
	public String getMsg3() {
		return msg3;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * ラストネーム登録メソッド
	 * @param last_name ラストネーム
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * ファーストネーム登録メソッド
	 * @param first_name ファーストネーム
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * 郵便番号上三桁登録メソッド
	 * @param postal1 郵便番号上三桁
	 */
	public void setPostal1(String postal1) {
		this.postal1 = postal1;
	}

	/**
	 * 郵便番号下四桁登録メソッド
	 * @param postal2 郵便番号下四桁
	 */
	public void setPostal2(String postal2) {
		this.postal2 = postal2;
	}

	/**
	 * 都道府県名登録メソッド
	 * @param addr1 都道府県名
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
	 * 市区町村名登録メソッド
	 * @param addr2 市区町村名
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	/**
	 * 番地登録メソッド
	 * @param addr3 番地
	 */
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	/**
	 * ユーザーメールアドレス登録メソッド
	 * @param user_mail ユーザーメールアドレス
	 */
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	/**
	 * ユーザー性別情報登録メソッド
	 * @param gender ユーザー性別
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * ユーザー誕生西暦登録メソッド
	 * @param start_year ユーザー誕生西暦
	 */
	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}

	/**
	 * ユーザー誕生月登録メソッド
	 * @param start_month ユーザー誕生月
	 */
	public void setStart_month(String start_month) {
		this.start_month = start_month;
	}

	/**
	 * ユーザー誕生日登録メソッド
	 * @param start_day ユーザー誕生日
	 */
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	/**
	 * ユーザーID登録メソッド
	 * @param user_id ユーザーID
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * ユーザーパスワード登録メソッド
	 * @param user_pass ユーザーパスワード
	 */
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	/**
	 * 比較用ユーザーパスワード登録メソッド
	 * @param user_pass2 比較用ユーザーパスワード
	 */
	public void setUser_pass2(String user_pass2) {
		this.user_pass2 = user_pass2;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = (SessionMap<String, Object>) sessionMap;
	}

}
