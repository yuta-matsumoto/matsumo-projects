package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.GetCartDAO;
import jp.co.internous.tourtike.dto.GetCartDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToPayoffAction
 * ゴートゥーペイオフアクション
 * @author 松本雄太
 * @since 2015/03/05
 * @version 1.0
 */
public class GoToPayOffAction extends ActionSupport implements SessionAware {
	public String result = ERROR;
	public Map<String, Object> sessionMap;
	public List<GetCartDTO> payOffList = new ArrayList<GetCartDTO>();
	private int total_yen;
	private int total_ticket;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() {
		GetCartDAO dao = new GetCartDAO();
		boolean checkDao = false;
		try {
			checkDao = dao.select(getMacAddr(), getIP(), (int) sessionMap.get("token"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		payOffList.addAll(dao.getcartList());

		for (int i = 0; i < payOffList.size(); i++) {
			total_yen += payOffList.get(i).getTotal_amount();
			total_ticket += payOffList.get(i).getTicket_count();
		}

		if(checkDao){
			result = SUCCESS;
		}

		return result;
	}

	/**
	 * MACアドレス取得メゾット
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
	 * IPアドレス取得メソッド
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

}
