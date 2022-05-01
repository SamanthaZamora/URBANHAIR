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

import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.ProveedorDAO;
import co.urbanhair.dao.RolDAO;
import co.urbanhair.entities.Proveedor;
import co.urbanhair.entities.Rol;

@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GenericDao newProveedor;
	private GenericDao newRol;

	
	public ServletProveedor() {
		super();
		this.newProveedor = new ProveedorDAO();
		this.newRol = new RolDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		System.out.println(action);

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
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroProvee.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		String razonSocial = request.getParameter("razonSocial");
		String email = request.getParameter("email");
		String representanteLegal = request.getParameter("representanteLegal");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");

		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		Proveedor proveedor = new Proveedor(razonSocial, email, representanteLegal, direccion, telefono, rol);

		newProveedor.insert(proveedor);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

		Proveedor proveedor = (Proveedor) newProveedor.find(idProveedor);

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);

		request.setAttribute("proveedor", proveedor);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroProvee.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

		String razonSocial = request.getParameter("razonSocial");
		String email = request.getParameter("email");
		String representanteLegal = request.getParameter("representanteLegal");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");

		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		Proveedor proveedor = new Proveedor(razonSocial, email, representanteLegal, direccion, telefono, rol);
		proveedor.setIdProveedor(idProveedor);

		newProveedor.update(proveedor);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

		Proveedor proveedor = (Proveedor) newProveedor.find(idProveedor);

		newProveedor.delete(proveedor);
		this.list(request, response);
	}


	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Proveedor> listaProveedor = newProveedor.list();
		request.setAttribute("listaProveedor", listaProveedor);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admProvee.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
