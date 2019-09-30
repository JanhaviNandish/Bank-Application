package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;


public class Balance extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			//to access from session
			HttpSession hs=request.getSession();
			int accno=(int)hs.getAttribute("accno");
			//set accno to dao
			DAOModel dao=new DAOModel();
			dao.setAccno(accno);

			boolean temp=dao.checkBalance();
			
			if(temp==true)
			{
				
				
				response.sendRedirect("/BankApp/balanceFailure.jsp");
			}
			else
			{
				hs.setAttribute("balance", dao.getBalance());
				response.sendRedirect("/BankApp/balanceSuccess.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
