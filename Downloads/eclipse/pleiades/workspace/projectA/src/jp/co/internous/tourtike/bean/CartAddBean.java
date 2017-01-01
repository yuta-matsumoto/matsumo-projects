package jp.co.internous.tourtike.bean;

/**
 * CartAddBean
 * カートアドビーン
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class CartAddBean {

	public int ticket_id;
	int ticket_count;
	public int total_amount;

	/**
	 * 商品番号取得メソッド
	 * @return ticket_id 商品番号
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * 商品注文数取得メソッド
	 * @return ticket_count 商品注文数
	 */
	public int getTicket_count() {
		return ticket_count;
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
	 * @param ticket_count
	 */
	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}

	/**
	 * 商品合計金額取得メソッド
	 * @return total_amount
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * 商品合計金額登録メソッド
	 * @param total_amount
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
}
