package jp.co.internous.tourtike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.tourtike.dto.GetGoodsListDTO;

/**
 * GetGoodsListDAO
 * ゲットグッズリストダオ
 * @author 佐藤裕也
 * @since2015/03/06
 * @version 1.0
 */
public class GetGoodsListDAO {

	List<GetGoodsListDTO> itemList = new ArrayList<GetGoodsListDTO>();

	private Connection con;
	public boolean res;

	/**
	 * 実行メソッド
	 * @return res 実行結果
	 */
	public boolean select() throws Exception {
		res = false;
		con = DBconnector.getConnection();

		try {
			String sql = "SELECT * FROM ticket ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				res = true;

				GetGoodsListDTO dto = new GetGoodsListDTO();

				dto.setStock(rs.getInt(4));
				if (dto.getStock() > 0) {
					dto.setTicket_id(rs.getInt(1));
					dto.setTicket_name(rs.getString(2));
					NumberFormat nfNum = NumberFormat.getCurrencyInstance();
					int s = rs.getInt(3);
					dto.setPrice(nfNum.format(s));
				} else if (dto.getStock() == 0) {
					dto.setTicket_id(rs.getInt(1));
					dto.setTicket_name("申し訳ございません。本プランは予約可能数をオーバーしました。");
				}
				itemList.add(dto);
			}

		} catch (Exception e) {

		}
		return res;
	}

	/**
	 * 商品一覧取得メソッド
	 * @return itemlist 商品一覧
	 */
	public List<GetGoodsListDTO> getItemlist() {
		return itemList;
	}

}
