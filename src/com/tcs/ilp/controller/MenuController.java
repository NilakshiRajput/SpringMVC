package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.service.MenuService;


@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public MenuController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String action = request.getParameter("source");
		RequestDispatcher rd=null;
		out.print(action);
	
		MenuService sc = new MenuService();
		
		if (action.equals("viemenu")) {
			
			
			
			
			
			ArrayList<Menu> menulist = new ArrayList<Menu>();
			try {
				menulist = sc.viewAll();
				out.print(menulist);
				
				if( menulist!=null ||menulist.size()>0)
				{
					System.out.println(menulist);
					request.setAttribute("menulist", menulist);
					rd=request.getRequestDispatcher("viewall.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
				
			
				
					
				
					
				
			 
			

		}
		
		if (action.equals("delete")) {
			
			out.print("id is"+request.getParameter("id"));
			
			try {
				sc.deleteByID(request.getParameter("id"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
	}

		

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
