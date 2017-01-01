package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.DeleteCartTableDAO;
import jp.co.internous.tourtike.dao.PayOffDAO;
import jp.co.internous.tourtike.dto.PayOffDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * PayOffAction
 * ペイオフアクション
 * @author 林美希
 * @since 2015/03/13
 * @version 1.0
 */
public class PayOffAction extends ActionSupport implements SessionAware {
	public String result;
	public Map<String, Object> sessionMap;
	public List<PayOffDTO> historyList = new ArrayList<PayOffDTO>();
	public List<PayOffDTO> cartList = new ArrayList<PayOffDTO>();
	public String mac_addr = null;
	public String user_id;
	public int ticket_id;
	public int ticket_count;
	public int total_amount;
	public String user_ip;
	public String ip_addr;
	public Boolean isCheckId;
	public int count;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() throws SocketException {
		result = ERROR;
		int check = 0;
		Boolean selectCheck = false;

		PayOffDAO dao = new PayOffDAO();

		try {
			mac_addr = getMacAddr();
			ip_addr = getIP();
			selectCheck = dao.select(mac_addr, ip_addr,
					(int) sessionMap.get("token"));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		historyList.addAll(dao.gethistorylist());
		if (sessionMap.containsKey("userId")) {
			user_id = (String) sessionMap.get("userId");
		}
		if (selectCheck) {
			for (int i = 0; i < historyList.size(); i++) {
				ticket_id = historyList.get(i).getTicket_id();
				ticket_count = historyList.get(i).getTicket_count();
				total_amount = historyList.get(i).getTotal_amount();
				user_ip = historyList.get(i).getUser_ip();
				PayOffDAO dao2 = new PayOffDAO();
				try {
					check = dao2.insert(user_id, ticket_id, ticket_count,
							total_amount, user_ip);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		DeleteCartTableDAO dao2 = new DeleteCartTableDAO();
		try {

			if (check > 0) {
				result = SUCCESS;
				count = dao2.delete(mac_addr, user_ip,
						(int) sessionMap.get("token"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			for (int i = 0; i < historyList.size(); i++) {
				try {
					dao2.update(historyList.get(i).ticket_id,
							historyList.get(i).ticket_count);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * MACアドレス取得メゾット
	 *
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
	 * @return ip IPアドレス
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
	 * @return sessionMap セッション情報
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
