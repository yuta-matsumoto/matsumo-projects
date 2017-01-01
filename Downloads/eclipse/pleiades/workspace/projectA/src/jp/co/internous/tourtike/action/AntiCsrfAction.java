package jp.co.internous.tourtike.action;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.tourtike.dao.DeleteCartTableDAO;
import jp.co.internous.tourtike.dao.GetGoodsListDAO;
import jp.co.internous.tourtike.dto.GetGoodsListDTO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * AntiCsrfAction
 * アンチシーエスアールエフアクション
 * @author 佐藤裕也
 * @since 2015/03/19
 * @version 1.0
 */
public class AntiCsrfAction extends ActionSupport implements SessionAware{

	public List<GetGoodsListDTO> itemList = new ArrayList<GetGoodsListDTO>();
	public String result = ERROR;
	public String csrfMsg;
	public Map<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() throws Exception {
		csrfMsg="不正な画面遷移が検出されました。もう一度購入手続きをやり直してください。";

		GetGoodsListDAO dao = new GetGoodsListDAO();
		dao.select();
		itemList.addAll(dao.getItemlist());

		DeleteCartTableDAO dao2 = new DeleteCartTableDAO();

		dao2.delete2(getMacAddr(), getIP());

		result = SUCCESS;

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
	 * @return sessionMap セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * メッセージ取得メソッド
	 * @return csrfMsg メッセージ
	 */
	public String getCsrfMsg() {
		return csrfMsg;
	}
}
