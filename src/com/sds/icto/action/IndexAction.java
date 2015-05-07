package com.sds.icto.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.dao.EmailListDAO;
import com.sds.icto.vo.EmailListVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmailListDAO dao = new EmailListDAO();
		List<EmailListVO> list = dao.fetchList();
		

		System.out.println(list.size());
		request.setAttribute("list", list);
		WebUtil.forward("index.jsp", request, response);
	}

}
