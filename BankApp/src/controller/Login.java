package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;


public class Login extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			int cid=Integer.parseInt(request.getParameter("CID"));
			String pw=request.getParameter("PW");
			
			DAOModel dao=new DAOModel();
			dao.setCustid(cid);
			dao.setPassword(pw);
			
			boolean temp=dao.login();
			
			if(temp==false)
			{
				response.sendRedirect("/BankApp/invalid.jsp");
			}
			else
			{
				HttpSession hs=request.getSession(true);
				hs.setAttribute("accno", dao.getAccno());
				//System.out.println(dao.getAccno());
				hs.setAttribute("cname", dao.getCname());
				response.sendRedirect("/BankApp/proceed.jsp");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
