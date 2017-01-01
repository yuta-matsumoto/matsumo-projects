package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.ReturnTopDAO;
import jp.co.internous.tourtike.dto.CartAddDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ReturnTopDeleteCartAction
 * リターントップデリートカートアクション
 * @author 佐藤裕也
 * @since 2015/03/13
 * @version 1.0
 */
public class ReturnTopDeleteCartAction extends ActionSupport implements
		SessionAware {

	private String result = ERROR;
	private Map<String, Object> sessionMap;
	List<CartAddDTO> cartList = new ArrayList<CartAddDTO>();

	/**
	 * 実行メソッド
	 * @return 結果
	 */
	public String execute() {
		int daoCheck = 0;
		ReturnTopDAO dao = new ReturnTopDAO();

		try {
			daoCheck = dao.select(getMacAddr(), getIP(),
					(int) sessionMap.get("token"));

			if (daoCheck > 0) {
				cartList.addAll(dao.getCartlist());
				sessionMap.put("cartList", cartList);
				dao.delete(getMacAddr(), getIP());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		result = SUCCESS;
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
	 * @return ip IPアドレス
	 */
	public String getIP() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		return ip;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}