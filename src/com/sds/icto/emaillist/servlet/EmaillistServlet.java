package com.sds.icto.emaillist.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.action.IndexAction;
import com.sds.icto.action.InsertAction;
import com.sds.icto.action.MainAction;
import com.sds.icto.web.Action;

@WebServlet("/email")
public class EmaillistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmaillistServlet() {
		super();
	}
	

	
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		
		String action = request.getParameter("action");
		
		if("selectAllList".equals(action)){
			Action a = new IndexAction();	
			a.execute(request, response);
		}else if("insert".equals(action)){
			Action a = new InsertAction();	
			a.execute(request, response);
		}else {
			Action a = new MainAction();	
			a.execute(request, response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		try {
			execute(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
