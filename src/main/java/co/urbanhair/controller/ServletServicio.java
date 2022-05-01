package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.ServicioDAO;
import co.urbanhair.entities.Servicio;


@WebServlet("/ServletServicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newSer;
	
    public ServletServicio() {
        super();
        this.newSer = new ServicioDAO();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroServ.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String duracion = request.getParameter("duracion");
		String imgURL = request.getParameter("imgURL");
		float precio = Float.parseFloat(request.getParameter("precio"));


		Servicio servicio = new Servicio(nombre, descripcion, duracion, imgURL, precio);
		
		newSer.insert(servicio);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idServicio = Integer.parseInt(request.getParameter("idServicio"));

		Servicio servicio  = (Servicio) newSer.find(idServicio);

		request.setAttribute("servicio", servicio);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroServ.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idServicio = Integer.parseInt(request.getParameter("idServicio"));

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String duracion = request.getParameter("duracion");
		String imgURL = request.getParameter("imgURL");
		float precio = Float.parseFloat(request.getParameter("precio"));

		Servicio servicio = new Servicio(nombre, descripcion, duracion, imgURL, precio);
		servicio.setIdServicio(idServicio);

		newSer.update(servicio);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idServicio = Integer.parseInt(request.getParameter("idServicio"));

		Servicio servicio  = (Servicio) newSer.find(idServicio);
        
		newSer.delete(servicio);
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Servicio> listaServicio = newSer.list();
		request.setAttribute("listaServicio", listaServicio);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admServ.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
