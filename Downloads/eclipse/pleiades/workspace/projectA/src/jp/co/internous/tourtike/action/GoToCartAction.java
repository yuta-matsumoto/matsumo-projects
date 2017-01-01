package jp.co.internous.tourtike.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.internous.tourtike.dto.CartAddDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToCartAction ゴートゥーカートアクション
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class GoToCartAction extends ActionSupport implements SessionAware {

	private String result;
	public Map<String, Object> sessionMap;
	public List<CartAddDTO> cartList = new ArrayList<CartAddDTO>();
	public int total_yen;
	public int total_ticket;
	public String errorMsg;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		result = ERROR;
		if (sessionMap.containsKey("cartList")) {
			cartList = (List<CartAddDTO>) sessionMap.get("cartList");

			for (int i = 0; i < cartList.size(); i++) {
				total_yen += cartList.get(i).getTotal_amount();
				total_ticket += cartList.get(i).getTicket_count();
			}
			sessionMap.put("total_yen", total_yen);
			sessionMap.put("total_ticket", total_ticket);
			result = SUCCESS;
		} else if (!sessionMap.containsKey("cartList")) {
			errorMsg = "カートが空です。";
		} else {
			errorMsg = "もう一度最初から操作をやり直して下さい。";
		}
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap
	 *            セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * メッセージ取得メソッド
	 * @return errorMsg メッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

}