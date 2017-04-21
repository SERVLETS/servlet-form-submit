package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OnlineApplicationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		Enumeration<String> parametrNames = req.getParameterNames();

		while (parametrNames.hasMoreElements()) {
			String parameterName = parametrNames.nextElement();

			if ("subjects".equals(parameterName)) {
				String paramValueArr[] = req.getParameterValues(parameterName);

				String vals = String.join(",", paramValueArr);

				out.println("<b>" + parameterName + "</b>--" + vals + "<br/>");
				continue;

			}

			String paramValue = req.getParameter(parameterName);

			out.println("<b>" + parameterName + "</b>--" + paramValue + "<br/>");
		}
		
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss.S a zzz");
		
		out.println("<b>Form submitted at: </b>"+ft.format(new Date()));

	}

}
