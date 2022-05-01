package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Close")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
  
    public LogoutServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.setAttribute("admin", null);
		session.setAttribute("cliente", null);
		response.sendRedirect(request.getContextPath()+"/html/login.jsp");
	}
    

}
