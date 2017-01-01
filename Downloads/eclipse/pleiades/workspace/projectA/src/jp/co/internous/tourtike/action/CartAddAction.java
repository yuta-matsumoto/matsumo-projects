package jp.co.internous.tourtike.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.internous.tourtike.bean.CartAddBean;
import jp.co.internous.tourtike.dao.CartAddDAO;
import jp.co.internous.tourtike.dto.CartAddDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * CartAddAction カートアドアクション
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class CartAddAction extends ActionSupport implements SessionAware {
	public String ticket_idStr;
	public String ticket_countStr;
	private int total_amount;
	public Map<String, Object> sessionMap;
	List<CartAddDTO> cartList = new ArrayList<CartAddDTO>();
	public String result;
	public String stockCheckMsg;
	CartAddDAO dao = new CartAddDAO();
	public String errorMessage;
	public String addItemName;
	int ticket_id;
	int ticket_count;

	/**
	 * 実行メソッド
	 * @return result 結果
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		result = ERROR;
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(ticket_idStr);
        Matcher m2 = p.matcher(ticket_countStr);
		try {
			if (!ticket_idStr.isEmpty() && !ticket_countStr.isEmpty()&&m.find()&&m2.find()) {
				ticket_id = Integer.parseInt(ticket_idStr);
				ticket_count = Integer.parseInt(ticket_countStr);
			}else{
				errorMessage = "半角整数で、商品番号と枚数をご指定ください。";
				return result;
			}
		} catch (NumberFormatException e) {
			errorMessage = "半角整数で、商品番号と枚数をご指定ください。";
			return result;
		} catch (Exception e) {
			errorMessage = "もう一度最初から操作をやり直して下さい。";
			e.printStackTrace();
			return result;
		}
		if (ticket_id > 0 && ticket_count > 0
				&& ticket_id <= dao.getListSize()) {
			CartAddBean bean = new CartAddBean();
			bean.setTicket_id(ticket_id);
			bean.setTicket_count(ticket_count);
			bean.setTotal_amount(total_amount);
			CartAddDAO dao = new CartAddDAO();
			Boolean daores = dao.select(bean);
			if (daores && dao.getStockChek() > 0) {
				result = SUCCESS;
				if (sessionMap.containsKey("cartList")) {
					cartList = (List<CartAddDTO>) sessionMap.get("cartList");
				}
				cartList.addAll(dao.getItemlist());
				for (int i = 0; i < cartList.size(); i++) {
					for (int j = i + 1; j < cartList.size(); j++) {
						if (cartList.get(i).getTicket_id() == cartList.get(j)
								.getTicket_id()) {
							cartList.get(j)
									.setTicket_count(
											cartList.get(j).getTicket_count()
													+ cartList.get(i)
															.getTicket_count());
							cartList.get(j)
									.setTotal_amount(
											cartList.get(j).getTotal_amount()
													+ cartList.get(i)
															.getTotal_amount());
							cartList.remove(i);
						}
					}
				}
				addItemName = dao.getTicket_name()+"をカートに保存しました。";
				sessionMap.put("cartList", cartList);

			} else if (dao.getStockChek() == 0) {
				stockCheckMsg = "申し訳ございませんが、お客様の選択したツアーは予約可能数をオーバーしました。その他のツアーを是非ご検討下さいませ。";
			}
		} else if (ticket_id >= dao.getListSize()) {
			System.out.println(dao.getListSize());
			errorMessage = "チケット番号は1～" + dao.getListSize() + "までの間でご入力下さい。";
		} else if (ticket_id == 0 && ticket_count == 0) {
			errorMessage = "チケット番号と枚数をご入力ください。";
		} else if (ticket_id == 0) {
			errorMessage = "チケット番号をご入力ください。";
		} else if (ticket_count == 0) {
			errorMessage = "ご購入されるチケットの枚数をご入力ください。";
		} else {
			errorMessage = "もう一度最初から操作をやり直して下さい。";
		}
		return result;
	}

	/**
	 * 商品番号取得メソッド
	 * @return ticket_id 商品番号
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * 商品番号文字列取得メソッド
	 * @return ticket_idstr 商品番号文字列
	 */
	public String getTicket_idstr() {
		return ticket_idStr;
	}

	/**
	 * 商品番号文字列登録メソッド
	 * @param ticket_idstr 商品番号文字列
	 */
	public void setTicket_idstr(String ticket_idstr) {
		this.ticket_idStr = ticket_idstr;
	}

	/**
	 * 商品注文数取得メソッド
	 * @return ticket_count 商品注文数
	 */
	public int getTicket_count() {
		return ticket_count;
	}

	/**
	 * 商品合計金額取得メソッド
	 * @return tota_amount 商品合計金額
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * セッション情報取得メソッド
	 * @return sessionMap セッション情報
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * カートリスト取得メソッド
	 * @return cartlist カートリスト
	 */
	public List<CartAddDTO> getCartlist() {
		return cartList;
	}

	/**
	 * 商品番号登録メソッド
	 * @param ticket_id 商品番号
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * 商品注文数登録メソッド
	 * @param ticket_count 商品注文数
	 */
	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}

	/**
	 * 商品合計注文金額登録メソッド
	 * @param total_amount 商品合計金額
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * カートリスト登録メソッド
	 * @param cartlist カートリスト
	 */
	public void setCartlist(List<CartAddDTO> cartlist) {
		this.cartList = cartlist;
	}

	/**
	 * セッション情報登録メソッド
	 * @param sessionMap セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * エラーメッセージ取得情報
	 * @param errorMessage エラーメッセージ
	 */
	public String getErrorMsg() {
		return errorMessage;
	}

	/**
	 * メッセージ取得メソッド
	 * @param errorMessage メッセージ情報
	 */
	public String getAddItemName() {
		return addItemName;
	}


}
