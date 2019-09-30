package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		try
		{
			String pw=request.getParameter("PW");
			String npw=request.getParameter("NPW");
			HttpSession hs=request.getSession();
			int accno=(int) hs.getAttribute("accno");
			
			DAOModel dao=new DAOModel();
			dao.setAccno(accno);
			dao.setPassword(pw);
			
			boolean temp=dao.changePassword(npw);
			
			if(temp==true)
			{
				response.sendRedirect("/BankApp/successPassword.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/failurePassword.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
