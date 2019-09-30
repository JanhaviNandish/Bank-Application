package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOModel;


public class NewPassword extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			String pwd=request.getParameter("PWD");
			String mail=request.getParameter("MAIL");
			
			DAOModel dao=new DAOModel();
			dao.setEmail(mail);
			dao.setPassword(pwd);
			
			boolean temp=dao.resetPassword();
			if(temp==true)
			{
				response.sendRedirect("/BankApp/successNewPassword.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/failureNewPassword.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
