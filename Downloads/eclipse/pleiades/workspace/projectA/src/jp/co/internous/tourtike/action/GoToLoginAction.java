package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.AddCartTableDAO;
import jp.co.internous.tourtike.dao.DeleteCartTableDAO;
import jp.co.internous.tourtike.dao.GetCartDAO;
import jp.co.internous.tourtike.dao.LoginDAO;
import jp.co.internous.tourtike.dto.CartAddDTO;
import jp.co.internous.tourtike.dto.GetCartDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToLoginAction
 * ゴートゥーログインアクション
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class GoToLoginAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	public String result;
	public Map<String, Object> sessionMap;
	public List<CartAddDTO> cartList = new ArrayList<CartAddDTO>();
	public List<GetCartDTO> payOffList = new ArrayList<GetCartDTO>();
	public String user_ip;
	public String mac_address;
	public String user_id;
	public String user_pass;
	public int ticket_id;
	public String ticket_name;
	public int ticket_count;
	public int total_amount;
	private int total_yen;
	private int total_ticket;
	private String errorMsg;
	HttpServletRequest request;
	private int token;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	@SuppressWarnings("unchecked")
	public String execute() {
		boolean check = false;
		int insertCheck = 0;

		if (sessionMap.containsKey("cartList")) {
			cartList = (List<CartAddDTO>) sessionMap.get("cartList");
			AddCartTableDAO dao = new AddCartTableDAO();

			Random r = new Random();
			token = r.nextInt(10000);
			sessionMap.put("token", token);

			for (int i = 0; i < cartList.size(); i++) {
				user_ip = getIP();
				try {
					mac_address = getMacAddr();
				} catch (SocketException e) {
					e.printStackTrace();
				}
				if (sessionMap.containsKey("userId")) {
					user_id = (String) sessionMap.get("userId");
				}
				ticket_id = cartList.get(i).getTicket_id();
				ticket_name = cartList.get(i).getTicket_name();
				ticket_count = cartList.get(i).getTicket_count();
				total_amount = cartList.get(i).getTotal_amount();
				try {
					insertCheck = dao.insert(user_ip, mac_address, user_id,
							ticket_id, ticket_name, ticket_count, total_amount,
							token);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (insertCheck > 0) {
				sessionMap.remove("cartList");
				sessionMap.remove("total_yen");
				sessionMap.remove("total_ticket");
				result = SUCCESS;
			}
			if (sessionMap.containsKey("userId")
					&& sessionMap.containsKey("userPass")) {
				try {
					LoginDAO dao2 = new LoginDAO();
					check = dao2.select((String) sessionMap.get("userId"),
							(String) sessionMap.get("userPass"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (check) {
					GetCartDAO dao3 = new GetCartDAO();
					try {
						dao3.select(getMacAddr(), getIP(),
								(int) sessionMap.get("token"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					payOffList.addAll(dao3.getcartList());

					for (int i = 0; i < payOffList.size(); i++) {
						total_yen += payOffList.get(i).getTotal_amount();
						total_ticket += payOffList.get(i).getTicket_count();
					}
					result = "GoPayOff";
				}
			}
		} else {
			DeleteCartTableDAO dao2 = new DeleteCartTableDAO();
			try {
				dao2.delete2(getMacAddr(), getIP());
			} catch (Exception e) {
				e.printStackTrace();
			}
			errorMsg = "カートが空です。もう一度商品一覧画面から商品をお選び下さい。";
			result = ERROR;
		}
		return result;
	}

	/**
	 * MACアドレス取得メソッド
	 * @return s MACアドレス
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
	 * IPアドレス取得メゾット
	 * @return IP IPアドレス
	 */
	public String getIP() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		return ip;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public Map<String, Object> getSession() {
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
	 * リクエスト情報登録メソッド
	 * @param arg0 リクエスト情報
	 */
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
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
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * カート情報取得メソッド
	 * @return cartList
	 */
	public List<CartAddDTO> getCartlist() {
		return cartList;
	}

	/**
	 * 合計金額取得メソッド
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
	 * メッセージ取得メソッド
	 * @return errorMsg メッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
}