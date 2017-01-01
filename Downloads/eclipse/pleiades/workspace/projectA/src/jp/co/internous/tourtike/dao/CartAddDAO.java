package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.tourtike.bean.CartAddBean;
import jp.co.internous.tourtike.dto.CartAddDTO;
import jp.co.internous.tourtike.dto.GetGoodsListDTO;

/**
 * CartAddDAO
 * カートアドダオ
 * @author 佐藤裕也
 * @since 2015/03/13
 * @version 1.0
 */
public class CartAddDAO {
	List<CartAddDTO> itemList = new ArrayList<CartAddDTO>();
	private Connection con;
	public boolean result;
	public int stockChek;
	List<GetGoodsListDTO> listSize = new ArrayList<GetGoodsListDTO>();
	public int listSizeNum;
	public String ticket_name;

	/**
	 * 実行メソッド
	 * @return result 実行結果
	 */
	public boolean select(CartAddBean bean) throws Exception {
		result = false;
		con = DBconnector.getConnection();

		try {
			String sql = "select * from ticket where ticket_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bean.getTicket_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
				CartAddDTO dto = new CartAddDTO();
				dto.setTicket_id(rs.getInt(1));
				dto.setTicket_name(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setTicket_count(bean.getTicket_count());
				dto.setTotal_amount(rs.getInt(3) * bean.getTicket_count());
				stockChek = rs.getInt(4);
				ticket_name = dto.getTicket_name();
				itemList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 商品数取得メソッド
	 * @return listSize 商品数
	 */
	public int getListSize() throws Exception {
		if (!listSize.isEmpty()) {
			listSize.clear();
		}
		con = DBconnector.getConnection();
		String sql = "SELECT * FROM ticket ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			GetGoodsListDTO dto2 = new GetGoodsListDTO();
			dto2.setTicket_id(rs.getInt(1));
			listSize.add(dto2);
		}
		listSizeNum = listSize.size();
		return listSizeNum;
	}

	/**
	 * カート登録メソッド
	 * @param itemList カート情報
	 */
	public void setItemlist(List<CartAddDTO> itemlist) {
		this.itemList = itemlist;
	}

	/**
	 * カート情報取得メソッド
	 * @return itemList カート情報
	 */
	public List<CartAddDTO> getItemlist() {
		return itemList;
	}

	/**
	 * 在庫数取得メソッド
	 * @return stockChek 在庫数
	 */
	public int getStockChek() {
		return stockChek;
	}

	/**
	 * 商品名取得メソッド
	 * @return ticket_name 商品名
	 */
	public String getTicket_name() {
		return ticket_name;
	}
}
