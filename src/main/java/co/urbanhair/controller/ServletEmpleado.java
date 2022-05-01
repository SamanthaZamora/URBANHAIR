package co.urbanhair.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.urbanhair.dao.EmpleadoDAO;
import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.RolDAO;
import co.urbanhair.dao.TipoDocumentoDAO;
import co.urbanhair.dao.TipoEmpleadoDAO;
import co.urbanhair.entities.Empleado;
import co.urbanhair.entities.Rol;
import co.urbanhair.entities.TipoDocumento;
import co.urbanhair.entities.TipoEmpleado;



@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {

	private static final long serialVersionUID = 1L;


	private GenericDao newEmp;
	private GenericDao newRol;
	private GenericDao newTipoDoc;
	private GenericDao newTipoEmp;
	

	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;

	public ServletEmpleado() {
		super();
		this.newEmp = new EmpleadoDAO();
		this.newRol = new RolDAO();
		this.newTipoDoc = new TipoDocumentoDAO();
		this.newTipoEmp = new TipoEmpleadoDAO();

		sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect(request.getContextPath() + "../html/nosotros.jsp");
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

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);
		
		List<TipoDocumento> listaDocumento = newTipoDoc.list();
		request.setAttribute("listaDocumento", listaDocumento);
		
		List<TipoEmpleado> listaTipoEm = newTipoEmp.list();
		request.setAttribute("listaTipoEm", listaTipoEm);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroEmp.jsp");
		dispatcher.forward(request, response);
	}

	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String nombre = request.getParameter("nombre");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");

		Date dateI = sdf.parse(request.getParameter("fechaNacimiento"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaNacimiento = Timestamp.valueOf(strI);
		
		/*TIPOS PARA LAS LISTAS*/
		/*int idTipoEmpleado = Integer.parseInt(request.getParameter("idTipoEmp"));
		TipoEmpleado tipoemp = (TipoEmpleado) newTipoEmp.find(idTipoEmpleado);*/
		TipoEmpleado tipoemp = (TipoEmpleado) newTipoEmp.find(Integer.parseInt(request.getParameter("idTipoE")));

		int idTipoDocumento = Integer.parseInt(request.getParameter("idTipoD"));
		TipoDocumento tipodocu = (TipoDocumento) newTipoDoc.find(idTipoDocumento);
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		

		Empleado empleado = new Empleado(nombre, documento, email, telefono, fechaNacimiento, tipoemp, rol, tipodocu );
		
		newEmp.insert(empleado);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

		Empleado empleado = (Empleado) newEmp.find(idEmpleado);

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);
		
		List<TipoDocumento> listaDocumento = newTipoDoc.list();
		request.setAttribute("listaDocumento", listaDocumento);
		
		List<TipoEmpleado> listaTipoEm = newTipoEmp.list();
		request.setAttribute("listaTipoEm", listaTipoEm);

		request.setAttribute("empleado", empleado);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroEmp.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

		String nombre = request.getParameter("nombre");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");

		Date dateI = sdf.parse(request.getParameter("fechaNacimiento"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaNacimiento = Timestamp.valueOf(strI);
		
		/*TIPOS PARA LAS LISTAS*/
		TipoEmpleado tipoemp = (TipoEmpleado) newTipoEmp.find(Integer.parseInt(request.getParameter("idTipoE")));

		int idTipoDocumento = Integer.parseInt(request.getParameter("idTipoD"));
		TipoDocumento tipodocu = (TipoDocumento) newTipoDoc.find(idTipoDocumento);
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);

		Empleado empleado = new Empleado(nombre, documento, email, telefono, fechaNacimiento, tipoemp, rol, tipodocu );
		empleado.setIdEmpleado(idEmpleado);

		newEmp.update(empleado);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

		Empleado empleado = (Empleado) newEmp.find(idEmpleado);
        
		newEmp.delete(empleado);
		this.list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Empleado> listaEmpleado = newEmp.list();
		request.setAttribute("listaEmpleado", listaEmpleado);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admEmp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
