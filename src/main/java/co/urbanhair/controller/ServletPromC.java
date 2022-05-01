package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.PromocionesDAO;
import co.urbanhair.dao.RolDAO;
import co.urbanhair.entities.Promociones;

/**
 * Servlet implementation class ServletPromC
 */
@WebServlet("/ServletPromC")
public class ServletPromC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newRol;
	private GenericDao newPromo;
	
	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;
	
	
	
    public ServletPromC() {
        super();
        this.newPromo = new PromocionesDAO();
        this.newRol = new RolDAO();
        
        sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect(request.getContextPath() + "/html/nosotros.jsp");
		}
		System.out.println(action + " la accion");

		try {
			switch (action) {
			case "promo":
				list(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} 
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Promociones> listaPromo = newPromo.list();
		request.setAttribute("listaPromo", listaPromo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/usuariosprom.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
