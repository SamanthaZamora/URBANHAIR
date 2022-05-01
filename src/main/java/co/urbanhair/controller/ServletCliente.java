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
import co.urbanhair.dao.PersonaDAO;
import co.urbanhair.dao.RolDAO;
import co.urbanhair.dao.TipoDocumentoDAO;
import co.urbanhair.entities.Empleado;
import co.urbanhair.entities.Persona;
import co.urbanhair.entities.Rol;
import co.urbanhair.entities.TipoDocumento;
import co.urbanhair.entities.TipoEmpleado;


@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GenericDao newCli;
	private GenericDao newRol;
	private GenericDao newTipoDoc;
	
	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;
	
       
    
    public ServletCliente() {
        super();
		this.newCli = new PersonaDAO();
		this.newRol = new RolDAO();
		this.newTipoDoc = new TipoDocumentoDAO();
		
		sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			ex.printStackTrace();
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
		
		//response.sendRedirect(request.getContextPath()+"/html/login.jsp");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login_servlet?rol=0");
		dispatcher.forward(request, response);
	}

	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String nombre = request.getParameter("nombre");
		String noDocumento = request.getParameter("noDocumento");
		String genero = request.getParameter("genero");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");

		Date dateI = sdf.parse(request.getParameter("fechaNacimiento"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaNacimiento = Timestamp.valueOf(strI);
		
		/*TIPOS PARA LAS LISTAS*/
		int idTipoDocumento = Integer.parseInt(request.getParameter("idTipoD"));
		TipoDocumento tipodocu = (TipoDocumento) newTipoDoc.find(idTipoDocumento);
		
		//int idR = Integer.parseInt(request.getParameter("idR"));
		int idR=2;
		Rol  rol = (Rol) newRol.find(idR);
		

		Persona persona = new Persona(nombre, noDocumento, fechaNacimiento, genero,  telefono,  email, contrasena, tipodocu, rol);
		
		newCli.insert(persona);
		this.showNewForm(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idPersona = Integer.parseInt(request.getParameter("idPersona"));

		Persona persona = (Persona) newCli.find(idPersona);

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);
		
		List<TipoDocumento> listaDocumento = newTipoDoc.list();
		request.setAttribute("listaDocumento", listaDocumento);

		request.setAttribute("persona", persona);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/usuariodatosformu.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idPersona = Integer.parseInt(request.getParameter("idPersona"));

		String nombre = request.getParameter("nombre");
		String noDocumento = request.getParameter("noDocumento");
		String genero = request.getParameter("genero");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");

		Date dateI = sdf.parse(request.getParameter("fechaNacimiento"));
		String strI = sdfTime.format(dateI);
		Timestamp fechaNacimiento = Timestamp.valueOf(strI);
		
		/*TIPOS PARA LAS LISTAS*/
		int idTipoDocumento = Integer.parseInt(request.getParameter("idTipoD"));
		TipoDocumento tipodocu = (TipoDocumento) newTipoDoc.find(idTipoDocumento);
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);

		Persona persona = new Persona(nombre, noDocumento, fechaNacimiento, genero,  telefono,  email, contrasena, tipodocu, rol);
		persona.setIdPersona(idPersona);

		newCli.update(persona);
		response.sendRedirect(request.getContextPath() + "/html/usuariodatos.jsp");
		//this.list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Persona> listaPersona = newCli.list();
		request.setAttribute("listaPersona", listaPersona);
        Object o=request.getAttribute("admin");
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admCli.jsp");
		dispatcher.forward(request, response);
       
		//response.sendRedirect(request.getContextPath()+"ServletCliente?action=list");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
