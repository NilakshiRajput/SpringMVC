package com.tcs.ilp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.dao.MenuDAO;

public class MenuService {
	
	
	MenuDAO obj= new MenuDAO();

	public ArrayList<Menu> viewAll() throws SQLException {
		ArrayList<Menu> menulist= new ArrayList<Menu>();
		menulist=obj.viewAll();
		
		return menulist;
	}
	
	
	public int  deleteByID(String id) throws SQLException{
		obj.deleteById(id);
		return 1;
	}

}
