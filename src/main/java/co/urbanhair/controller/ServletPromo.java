package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import co.urbanhair.entities.Rol;


@WebServlet("/ServletPromo")
public class ServletPromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newRol;
	private GenericDao newPromo;
	
	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;
	
	
	
    public ServletPromo() {
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
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroPromo.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String imgURL = request.getParameter("imgURL");
		float precio = Float.parseFloat( request.getParameter("precio"));
		
		Date dateI = sdf.parse(request.getParameter("fechaInicio"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaInicio = Timestamp.valueOf(strI);
		
		Date dateF = sdf.parse(request.getParameter("fechaFin"));
		String strF = sdfTime.format(dateF);
		Timestamp fechaFin = Timestamp.valueOf(strF);
		
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		Promociones promociones = new Promociones(nombre, descripcion, imgURL, fechaInicio, fechaFin, precio, rol);

		newPromo.insert(promociones);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idPromo = Integer.parseInt(request.getParameter("idPromo"));

		Promociones promociones = (Promociones) newPromo.find(idPromo);

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);

		request.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroPromo.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idPromo = Integer.parseInt(request.getParameter("idPromo"));

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String imgURL = request.getParameter("imgURL");
		float precio = Float.parseFloat( request.getParameter("precio"));
		
		Date dateI = sdf.parse(request.getParameter("fechaInicio"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaInicio = Timestamp.valueOf(strI);
		
		Date dateF = sdf.parse(request.getParameter("fechaFin"));
		String strF = sdfTime.format(dateF);
		Timestamp fechaFin = Timestamp.valueOf(strF);

		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		Promociones promociones = new Promociones(nombre, descripcion, imgURL, fechaInicio, fechaFin, precio, rol);
		promociones.setIdPromo(idPromo);

		newPromo.update(promociones);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idPromo = Integer.parseInt(request.getParameter("idPromo"));

		Promociones promociones = (Promociones) newPromo.find(idPromo);

		newPromo.delete(promociones);
		this.list(request, response);
	}


	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Promociones> listaPromo = newPromo.list();
		request.setAttribute("listaPromo", listaPromo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admPromo.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
