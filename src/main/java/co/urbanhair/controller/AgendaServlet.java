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

import co.urbanhair.dao.AtencionDAO;
import co.urbanhair.dao.CitaDAO;
import co.urbanhair.dao.GenericDao;
import co.urbanhair.entities.AtencionServicio;
import co.urbanhair.entities.Cita;
import co.urbanhair.entities.Persona;
import co.urbanhair.entities.Rol;
import co.urbanhair.entities.TipoDocumento;

/**
 * Servlet implementation class AgendaServlet
 */
@WebServlet("/AgendaServlet")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GenericDao newAge;

	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaServlet() {
		super();
		newAge= new AtencionDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			list(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<AtencionServicio> listaCita = newAge.list();
		request.setAttribute("agenda", listaCita);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/admAgenda.jsp");
		dispatcher.forward(request, response);
		// response.sendRedirect(request.getContextPath()+"ServletCliente?action=list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
