package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;


public class Transfer extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			int tpac=Integer.parseInt(request.getParameter("TPAC"));
			int amt=Integer.parseInt(request.getParameter("AMT"));
			HttpSession hs=request.getSession();
			int accno=(int)hs.getAttribute("accno");
			
			DAOModel dao=new DAOModel();
			dao.setAccno(accno);
			boolean temp=dao.fundTransfer(amt);
			
			if(temp==true)
			{
				response.sendRedirect("/BankApp/successTransfer.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/failureTransfer.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}