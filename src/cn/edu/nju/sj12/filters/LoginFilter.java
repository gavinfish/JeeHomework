package cn.edu.nju.sj12.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	String LOGIN_PAGE = "";
	protected FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String isLog = (String) request.getSession().getAttribute("isLog");
		if ((isLog != null) && ((isLog.equals("true")) || (isLog == "true"))) {
			chain.doFilter(req, resp);
			return;
		} else {
			response.sendRedirect(LOGIN_PAGE);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = config;
	}

}
