package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;


public class Statement extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HttpSession hs=request.getSession();
			int accno=(int) hs.getAttribute("accno");
			
			DAOModel dao=new DAOModel();
			dao.setAccno(accno);
			
			ArrayList al=dao.getStatement();
			
			if(al==null)
			{
				response.sendRedirect("/BankApp/failureStatement.jsp");
			}
			else
			{
				hs.setAttribute("al", al);
				response.sendRedirect("/BankApp/successStatement.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
