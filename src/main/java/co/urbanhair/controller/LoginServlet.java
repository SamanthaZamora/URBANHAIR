package co.urbanhair.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.urbanhair.dao.PersonaDAO;
import co.urbanhair.entities.Persona;


@WebServlet("/login_servlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private PersonaDAO user;


	public LoginServlet() {
		super();
		user = new PersonaDAO();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();
		session.setAttribute("mensaje", null);

		int rol = Integer.parseInt(request.getParameter("rol"));
		String username = request.getParameter("email");
		String password = request.getParameter("contrasena");

		if (rol == 0) {
			session.setAttribute("mensaje", "No ha seleccionado ningun rol");
			response.sendRedirect(request.getContextPath() + "/html/login.jsp");
			// processRequest(request, response);

		} else {

			Persona c = user.findByField("email", username);

			if (c != null) {
				System.out.println(c.getContrasena() + " --- " + password);
				if (!c.getContrasena().equals(password)) {
					// System.out.println("No existe");
					session.setAttribute("mensaje", "Contraseña equivocada");
					response.sendRedirect(request.getContextPath() + "/html/login.jsp");
					return;
				} else {
					if (c.getRol().getIdRol() == rol) {
						switch (rol) {
						case 1:
							session.setAttribute("admin", c);
							response.sendRedirect(request.getContextPath() + "/ServletInfo?action=list");
							break;
						case 2:
							session.setAttribute("cliente", c);
							response.sendRedirect(request.getContextPath() + "/html/usuariodatos.jsp");
							break;
						}
					} else {
						session.setAttribute("mensaje", "Rol equivocado");
						response.sendRedirect(request.getContextPath() + "/html/login.jsp");
					}

				}

			} else {
				// System.out.print("No existe e");
				session.setAttribute("mensaje", "No existe ningun usuario con ese correo");
				// request.getRequestDispatcher("./html/login.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/html/login.jsp");
				return;
			}

			//System.out.println(username + " -> " + password + " --> " + rol);
		}

	}

}
