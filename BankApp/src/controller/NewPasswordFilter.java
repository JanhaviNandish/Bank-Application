package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class NewPasswordFilter
 */
public class NewPasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NewPasswordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		String pwd=request.getParameter("PWD");
		String cpwd=request.getParameter("CPWD");
		
		if(pwd.equals(cpwd)==true)
		{
			chain.doFilter(request, response);
		}
		
		else
		{
			((HttpServletResponse) response).sendRedirect("/BankApp/errorNewPassword.jsp");
		}
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
