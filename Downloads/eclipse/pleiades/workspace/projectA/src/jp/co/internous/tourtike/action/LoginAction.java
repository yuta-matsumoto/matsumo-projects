package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.GetCartDAO;
import jp.co.internous.tourtike.dao.LoginDAO;
import jp.co.internous.tourtike.dto.GetCartDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginAction
 * ログインアクション
 * @author 松本雄太
 * @since 2015/03/13
 * @version 1.0
 */
public class LoginAction extends ActionSupport implements SessionAware {

	public String user_name;
	public String user_id;
	public String user_pass;
	public String result = ERROR;
	public Map<String, Object> sessionMap;
	public String errorMsg;
	public List<GetCartDTO> payOffList = new ArrayList<GetCartDTO>();
	private int total_yen;
	private int total_ticket;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() throws Exception {
		boolean check = false;
		boolean check2 = false;
		try {
			LoginDAO dao = new LoginDAO();
			if (dao.select(user_id, user_pass)) {
				sessionMap.put("userName", dao.DBuserName);
				sessionMap.put("userId", dao.DBuserID);
				sessionMap.put("userPass", dao.DBuserPass);
				check = true;
			} else {
				result = "notmatch";
				errorMsg = "パスワードもしくは名前が違います";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (check&&sessionMap.containsKey("token")) {
			GetCartDAO dao2 = new GetCartDAO();
			check2 = dao2.select(getMacAddr(), getIP(),(int) sessionMap.get("token"));
			payOffList.addAll(dao2.getcartList());
			for (int i = 0; i < payOffList.size(); i++) {
				total_yen += payOffList.get(i).getTotal_amount();
				total_ticket += payOffList.get(i).getTicket_count();
			}
		}

		if (check2) {
			result = SUCCESS;
		}
		return result;

	}

	/**
	 * MACアドレス取得メソッド
	 * @return s MACアドレス
	 * @throws SocketException
	 */
	public String getMacAddr() throws SocketException {
		String s = null;
		Enumeration<NetworkInterface> nics = NetworkInterface
				.getNetworkInterfaces();
		while (nics.hasMoreElements()) {
			NetworkInterface nic = nics.nextElement();
			s = "";
			byte[] hardwareAddress = nic.getHardwareAddress();
			if (hardwareAddress != null) {
				for (byte b : hardwareAddress) {
					s += String.format("%02X ", b);
				}
			}
			if (s != "") {
				break;
			}
		}
		return s;
	}

	/**
	 * IP情報取得メソッド
	 * @return IP IP情報
	 */
	public String getIP() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		return ip;
	}

	/**
	 * ユーザー名登録メソッド
	 * @param user_name ユーザー名
	 */
	public String setUserName(String user_name) {
		return this.user_name = user_name;
	}

	/**
	 * ユーザーID登録メソッド
	 * @param user_id ユーザーID
	 */
	public String setUserID(String user_id) {
		return this.user_id = user_id;
	}

	/**
	 * ユーザーパスワード登録メソッド
	 * @param user_pass ユーザーパスワード
	 */
	public void setUserPass(String user_pass) {
		this.user_pass = user_pass;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap セッション情報
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * 合計金額注文メソッド
	 * @return total_yen 合計金額
	 */
	public int getTotal_yen() {
		return total_yen;
	}

	/**
	 * 合計注文枚数取得メソッド
	 * @return total_ticket 合計注文枚数
	 */
	public int getTotal_ticket() {
		return total_ticket;
	}


	/**
	 * メッセージ情報取得メソッド
	 * @return errorMsg メッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
}
