package jp.co.internous.tourtike.dto;

/**
 * GetCartDTO
 * ゲットカートディーティーオー
 * @author 林美希
 * @since 2015/03/13
 * @version 1.0
 */
public class GetCartDTO {
	public String user_ip;
	public String mac_address;
	public String user_id;
	public int ticket_id;
	public String ticket_name;
	public int ticket_count;
	public int total_amount;

	/**
	 * チケット名取得メソッド
	 * @return ticket_name チケット名
	 */
	public String getTicket_name() {
		return ticket_name;
	}
	/**
	 * チケット名登録メソッド
	 * @return ticket_name チケット名
	 */
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	/**
	 * ユーザーIP取得メソッド
	 * @return user_ip ユーザーIP
	 */
	public String getUser_ip() {
		return user_ip;
	}

	/**
	 * ユーザーIP登録メソッド
	 * @param user_ip ユーザーIP
	 */
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	/**
	 * MACアドレス取得メソッド
	 * @return mac_address MACアドレス
	 */
	public String getMac_address() {
		return mac_address;
	}

	/**
	 * Macアドレス登録メソッド
	 * @param mac_address Macアドレス
	 */
	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	/**
	 * ユーザーID取得メソッド
	 * @return user_id ユーザーID
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーID登録メソッド
	 * @param user_id ユーザーId
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * チケットID取得メソッド
	 * @return ticket_id チケットID
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * チケットID登録メソッド
	 * @param ticket_id チケットID
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * 注文数取得メソッド
	 * @return ticket_count 注文数
	 */
	public int getTicket_count() {
		return ticket_count;
	}

	/**
	 * 注文数登録メソッド
	 * @param ticket_count ユーザーIP
	 */
	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}

	/**
	 * 合計金額取得メソッド
	 * @return total_amount 合計金額
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * 合計金額登録メソッド
	 * @param total_amount 合計金額
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

}
