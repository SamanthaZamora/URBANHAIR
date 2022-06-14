package co.urbanhair.controller;

import co.urbanhair.dao.AtencionDAO;
import co.urbanhair.dao.CitaDAO;
import co.urbanhair.dao.EmpleadoDAO;
import co.urbanhair.dao.ServicioDAO;
import co.urbanhair.entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class CitaServlet
 */
@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CitaDAO cita;
	private AtencionDAO ate;

	private SimpleDateFormat formatf;
	private SimpleDateFormat formath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CitaServlet() {
		super();
		cita = new CitaDAO();
		ate = new  AtencionDAO ();
		formatf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		formath = new SimpleDateFormat("HH:mm:ss");
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect(request.getContextPath() + "/html/nosotros.jsp");
		}
		// System.out.println(action + " la accion");

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
					// update(request, response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			insert(request, response);

		} catch (Exception e) {

		}

		return;
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cita> listaProve = cita.list();
		request.setAttribute("listaCitas", listaProve);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/usuariocitas.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException, ParseException {

		String fecha = request.getParameter("fecha");
		int emp = Integer.parseInt(request.getParameter("empleado"));
		int serv = Integer.parseInt(request.getParameter("servicio"));


		// response.sendRedirect(request.getContextPath() + "/html/usuarioagendar.jsp");
		try {
			System.out.println();
			Date fe = formatf.parse(fecha);

			String time = fe.getHours() + ":" + fe.getMinutes() + ":" + fe.getSeconds();
			if (fe.getHours() < 8 || fe.getHours() > 18) {
				request.setAttribute("errorDeHorario", "Horario invalido");
				response.sendRedirect(request.getContextPath() + "/html/usuarioagendar.jsp");
				return;
			}

			HttpSession session = request.getSession();
			Persona persona = (Persona) session.getAttribute("cliente");
			AtencionDAO ate = new AtencionDAO();
			EmpleadoDAO empl = new EmpleadoDAO();
			ServicioDAO se = new ServicioDAO();
			Servicio servicial = se.find(serv);
			Empleado v = empl.find(emp);
			System.out.println(v.toString() + " - empleado ");

			Cita cita2 = new Cita(fe, time, persona, servicial);
			AtencionServicio as =
					new AtencionServicio(fe, time, servicial.getPrecio(), cita2, servicial, persona,v);
			cita.insert(cita2);
			ate.insert(as);
			response.sendRedirect(request.getContextPath() + "/html/usuariocitas.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idc = request.getParameter("idCita");
		int idCita = Integer.parseInt(idc);

		Cita ci = (Cita) cita.find(idCita);

		List<Cita> lista = cita.list();
		request.setAttribute("listaCita", lista);

		request.setAttribute("producto", ci);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/registroProd.jsp");
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Cita c = (Cita) cita.find(id);
		AtencionServicio aten=   ate.findByField("cita", c);
		ate.delete(aten);
		cita.delete(c);
		this.list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		List<Cita> listaProducto = cita.list();
		request.setAttribute("listaCita", listaProducto);

		response.sendRedirect(request.getContextPath() + "/html/usuariocitas.jsp");
	}
}
