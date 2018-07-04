package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.util.DatabaseUtil;

public class MenuDAO {

	public ArrayList<Menu> viewAll() throws SQLException {
		Connection con = DatabaseUtil.getConnection();
		ArrayList<Menu> menulist = new ArrayList<Menu>();
		PreparedStatement ps = con
				.prepareStatement("select * from menu_1256989");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Menu m = new Menu();
			m.setMenuId(rs.getString(1));
			m.setMenuName(rs.getString(2));
			m.setCategory(rs.getString(3));
			m.setType(rs.getString(4));
			m.setCost(rs.getDouble(5));
			m.setStatus(rs.getString(6));
			menulist.add(m);
		}
		con.close();
		return menulist;

	}

	public int deleteById(String id) throws SQLException {

		int status = 0;
		try {
			Connection con = DatabaseUtil.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from menu_1256989 where menuid=?");
			ps.setString(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

}
