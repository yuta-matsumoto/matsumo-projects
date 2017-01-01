package jp.co.internous.tourtike.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteCartAction
 * デリートカートアクション
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class DeleteCartAction extends ActionSupport implements SessionAware {

	public String result = ERROR;
	public Map<String, Object> sessionMap;
	public String errorMsg;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() {
		sessionMap.remove("cartList");
		sessionMap.remove("total_yen");
		sessionMap.remove("total_ticket");
		result = SUCCESS;
		errorMsg="カートを空にしました。";
		return result;
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
	 * メッセージ取得メソッド
	 * @return errormsg メッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
}