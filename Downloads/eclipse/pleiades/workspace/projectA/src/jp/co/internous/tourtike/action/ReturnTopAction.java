package jp.co.internous.tourtike.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ReturnTopAction
 * @author 岩井晋太郎
 * @since 2015/03/13
 * @version 1.0
 */
public class ReturnTopAction extends ActionSupport implements SessionAware{

	public Map<String,Object>sessionMap;
	public String result;

	/**
	 * 実行メソッド
	 * @return result 実行結果
	 */
	public String execute(){
		result=SUCCESS;
		return result;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public Map<String,Object>getSession(){
		return sessionMap;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap セッション情報
	 */
	public void setSession(Map<String,Object>sessionMap){
		this.sessionMap=sessionMap;
	}
}