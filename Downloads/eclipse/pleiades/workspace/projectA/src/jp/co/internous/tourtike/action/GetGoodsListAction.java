package jp.co.internous.tourtike.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.internous.tourtike.dao.GetGoodsListDAO;
import jp.co.internous.tourtike.dto.GetGoodsListDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GetGoodsListAction
 * ゲットグッズリストアクション
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class GetGoodsListAction extends ActionSupport implements SessionAware {

	public List<GetGoodsListDTO> itemList = new ArrayList<GetGoodsListDTO>();
	public String result = ERROR;
	public Map<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	public String execute() throws Exception {
		GetGoodsListDAO dao = new GetGoodsListDAO();
		dao.select();
		itemList.addAll(dao.getItemlist());
		result = SUCCESS;
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 * @return sessionMap セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
