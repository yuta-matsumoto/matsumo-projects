package jp.co.internous.tourtike.dto;

/**
 * CartAddDTO
 * カートアドディーティーオー
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class CartAddDTO {
	public int ticket_id;
	public String ticket_name;
	public int price;
	public int ticket_count;
	public int total_amount;
	public int stock;

	/**
	 * 在庫数取得メソッド
	 * @return stock 在庫数
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 在庫登録メソッド
	 * @param stock 在庫数
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 商品番号登録メソッド
	 * @return ticket_id 商品番号
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * 商品番号登録メソッド
	 * @param ticket_id 商品番号
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * 商品名取得メソッド
	 * @return ticket_name 商品名
	 */
	public String getTicket_name() {
		return ticket_name;
	}

	/**
	 * 商品名登録メソッド
	 * @param ticket_name 商品名
	 */
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	/**
	 * 商品価格取得メソッド
	 * @return price 価格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 商品価格登録メソッド
	 * @param price 商品価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 商品注文数取得メソッド
	 * @return ticket_count 商品注文数
	 */
	public int getTicket_count() {
		return ticket_count;
	}

	/**
	 * 商品注文数登録メソッド
	 * @param ticket_count 商品注文数
	 */
	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}

	/**
	 * 合計価格取得メソッド
	 * @return total_amount 合計価格
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * 合計価格登録メソッド
	 * @param total_amount 合計価格
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

}
