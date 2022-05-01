package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.urbanhair.dao.PersonaDAO;
import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.ProductoDAO;
import co.urbanhair.dao.ProveedorDAO;
import co.urbanhair.entities.Empleado;
import co.urbanhair.entities.Producto;
import co.urbanhair.entities.Proveedor;
import co.urbanhair.entities.Rol;


@WebServlet("/ServletProductos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newProv;
	private GenericDao newProd;
	
	
    public ServletProductos() {
        super();
        this.newProv = new ProveedorDAO();
        this.newProd = new ProductoDAO();
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
		
		List<Proveedor> listaProve = newProv.list();
		request.setAttribute("listaProve", listaProve);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroProd.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String marca = request.getParameter("marca");
		float precio = Float.parseFloat(request.getParameter("precio"));
		String imgURL = request.getParameter("imgURL");
		String cantidad = request.getParameter("cantidad");
		
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		Proveedor  proveedor = (Proveedor) newProv.find(idPro);
		
		Producto producto = new Producto(nombre, descripcion, marca, precio, imgURL, cantidad, proveedor);
		
		newProd.insert(producto);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idProducto = Integer.parseInt(request.getParameter("idProducto"));

		Producto producto = (Producto) newProd.find(idProducto);
		
		List<Proveedor> listaProve = newProv.list();
		request.setAttribute("listaProve", listaProve);

		request.setAttribute("producto", producto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroProd.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idProducto = Integer.parseInt(request.getParameter("idProducto"));

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String marca = request.getParameter("marca");
		float precio = Float.parseFloat(request.getParameter("precio"));
		String imgURL = request.getParameter("imgURL");
		String cantidad = request.getParameter("cantidad");
		
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		Proveedor  proveedor = (Proveedor) newProv.find(idPro);
		
		
		Producto producto = new Producto(nombre, descripcion, marca, precio, imgURL, cantidad, proveedor);
		producto.setIdProducto(idProducto);

		newProd.update(producto);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idProducto = Integer.parseInt(request.getParameter("idProducto"));

		Producto producto = (Producto) newProd.find(idProducto);
        
		newProd.delete(producto);
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Producto> listaProducto = newProd.list();
		request.setAttribute("listaProducto", listaProducto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admProd.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
