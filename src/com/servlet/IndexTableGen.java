package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TableGen
 */
@WebServlet("/TableGen")
public class IndexTableGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexTableGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String row =request.getParameter("row");
		
		String colomn = request.getParameter("colomn");
		
		System.out.println("row ="+row);
		
		System.out.println("colomn ="+colomn);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("row", row);
		
		session.setAttribute("col", colomn);
		
		response.sendRedirect("IndexTableGen1.jsp?row="+row+"&&col="+colomn);
		
		
		
	}

}
