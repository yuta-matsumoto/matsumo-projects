package jp.co.internous.tourtike.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LogOutAction ログアウトアクション
 * @author 小野田吉孝
 * @since 2015/03/05
 * @version 1.0
 */
public class LogOutAction extends ActionSupport implements SessionAware {
	public Map<String, Object> sessionMap;
	public String logOutMsg;

	public String execute() {
		String result = null;
		try {
			result = SUCCESS;
			sessionMap.clear();
			logOutMsg="ログアウトしました。";
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}


