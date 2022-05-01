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
import co.urbanhair.dao.RolDAO;
import co.urbanhair.dao.GenericDao;
import co.urbanhair.dao.InformacionempresarialDAO;
import co.urbanhair.entities.Empleado;
import co.urbanhair.entities.InformacionEmpresarial;
import co.urbanhair.entities.Rol;
import co.urbanhair.entities.TipoDocumento;
import co.urbanhair.entities.TipoEmpleado;


@WebServlet("/ServletInfo")
public class ServletInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private GenericDao newRol;
	private GenericDao newInfo;
	
    public ServletInfo() {
        super();
        this.newRol = new RolDAO();
        this.newInfo = new InformacionempresarialDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect(request.getContextPath() + "html/nosotros.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroInfo.jsp");
		dispatcher.forward(request, response);
	}

	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String mision = request.getParameter("mision");
		String telefono = request.getParameter("telefono");
		String vision = request.getParameter("vision");
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		InformacionEmpresarial info = new InformacionEmpresarial(direccion, email, mision, telefono, vision, rol );
		
		newInfo.insert(info);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idInfo = Integer.parseInt(request.getParameter("idInfo"));

		InformacionEmpresarial info = (InformacionEmpresarial) newInfo.find(idInfo);

		List<Rol> listaRol = newRol.list();
		request.setAttribute("listaRol", listaRol);

		request.setAttribute("info", info);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		int idInfo = Integer.parseInt(request.getParameter("idInfo"));

		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String mision = request.getParameter("mision");
		String telefono = request.getParameter("telefono");
		String vision = request.getParameter("vision");
		
		int idR = Integer.parseInt(request.getParameter("idR"));
		Rol  rol = (Rol) newRol.find(idR);
		
		InformacionEmpresarial info = new InformacionEmpresarial(direccion, email, mision, telefono, vision, rol );
		info.setIdInfo(idInfo);

		newInfo.update(info);
		this.list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int idInfo = Integer.parseInt(request.getParameter("idInfo"));

		InformacionEmpresarial info  = (InformacionEmpresarial) newInfo.find(idInfo);
        
		newInfo.delete(info);
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<InformacionEmpresarial> listaInfo = newInfo.list();
		request.setAttribute("listaInfo", listaInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admInfo.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
