package jp.co.internous.tourtike.dto;

/**
 * GetGoodsListDTO
 * ゲッドグッズリストディーティーオー
 * @author 佐藤裕也
 * @since 2015/03/06
 * @version 1.0
 */
public class GetGoodsListDTO {

	public int ticket_id;
	public String ticket_name;
	public String price;
	public int stock;

	/**
	 * 商品番号取得メソッド
	 * @return ticket_id 商品番号
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * 商品名取得メソッド
	 * @return ticket_name 商品名
	 */
	public String getTicket_name() {
		return ticket_name;
	}

	/**
	 * 商品価格取得メソッド
	 * @return price 商品価格
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 在庫数取得メソッド
	 * @return stock 在庫数
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 商品番号登録メソッド
	 * @param ticket_id 商品番号
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * 商品名登録メソッド
	 * @param ticket_name 商品名
	 */
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	/**
	 * 商品価格登録メソッド
	 * @param price 商品価格
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 商品在庫数登録メソッド
	 * @param stock 商品在庫数
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
