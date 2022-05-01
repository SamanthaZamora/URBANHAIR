<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ cliente != null }">
	<!DOCTYPE html>
	<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Urban Hair</title>
<meta name="desciption" content="Urban Hair">
<link rel="preconnect" href="https://fonts.gstatic.com">
<!--Prefetch-->
<link rel="prefetch" href="/html/nosotros.html" as="document">

<!--Preload-->
<link rel="preload" href="css/normalize.css" as="style">
<link rel="stylesheet" href="css/normalize.css">

<link rel="preload"
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@1&family=PT+Sans:wght@400;700&display=swap"
	crossorigin="crossorigin" as="font">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@1&family=PT+Sans:wght@400;700&display=swap"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<!-- DataTable -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="preload" href="../css/style.css" as="style">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/menuusuario.css">
<link rel="stylesheet" href="../css/footer.css">




</head>
<body>
	<header class="header-usuario header-decoracion ">
		<div class="contenedor">
			<div class="barra  " id="navbarSupportedContent">
				<a class="logo" href="../index.jsp">
					<h1 class="logo__nombre no-margin centrar-texto">
						Urban<span class="logo__bold">Hair</span>
					</h1>
				</a>
				<nav class="navegacion">
					<a href="nosotros.jsp" class="navegacion__enlaces">Nosotros</a> <a
						href="servicios.jsp" class="navegacion__enlaces">Servicios</a> <a
						href="productos.jsp" class="navegacion__enlaces">Productos</a> <a
						href="contactanos.jsp" class="navegacion__enlaces">Contacto</a>

					<li class="dropdown noponer" style="list-style-type: none;"><a
						href="#" class="dropdown-toggle navegacion__enlaces"
						data-toggle="dropdown"> <c:out value="${cliente.nombre}" /> </a>
						<ul class="dropdown-menu navegacion-usuario" style=" font-size: 16px; color: black">
								<li><a class="dropdown-item navegacion-usuario" 
									href="usuariodatos.jsp">Mi cuenta</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="usuariocitas.jsp">Citas</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="usuariosprom.jsp">Promociones</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="<%=request.getContextPath()%>/Close" method="post">Salir</a></li>
							</ul></li>

					<svg xmlns="http://www.w3.org/2000/svg" style="color: #fff"
						width="50" height="50" fill="currentColor"
						class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                            <path fill-rule="evenodd"
							d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                            </svg>
					</ul>
				</nav>
			</div>
		</div>
	</header>


	<div class="container-fluid usuario-datos">
             <div class="row">
              <!--perfil -->
              <div class="col-md-3 col-lg-3 verticalLine">
                <div class="d-flex flex-column flex-shrink-0 p-3 bg-light colum-datos">
                  <!-- img grande de usuario -->
                  <svg xmlns="http://www.w3.org/2000/svg" style="color: #B39FB4"
                  width="200" height="200" fill="currentColor"
                  
                  class="bi bi-person-circle" viewBox="0 0 16 16">
                                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                                  <path fill-rule="evenodd"
                    d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                                  </svg>
                  <br>
                  <h4><c:out value="${cliente.nombre}" /></h4>
                  <hr>
                  <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                      <a href="usuariodatos.jsp" class="nav-link link-dark" aria-current="page">
                        <svg class="bi me-2 selector" width="16" height="16">
                          <use xlink:href="#home" />
                        </svg>
                        <strong color="gray"> Mis datos personales </strong></a>
                    </li>
                    <li>
                      <a href="usuariocitas.jsp" class="nav-link link-dark">
                        <svg class="bi me-2" width="16" height="16">
                          <use xlink:href="#speedometer2" />
                        </svg>
                        <strong> Citas agendadas</strong> </a>
                    </li>
                    <li>
                      <a href="usuariosprom.jsp" class="nav-link link-dark">
                        <svg class="bi me-2 " width="16" height="16">
                          <use xlink:href="#table" />
                        </svg>
                        <strong > Promociones </strong> </a>
                    </li>

                  </ul>
                </div>
              </div>
			<!-- end perfil -->

			<div class="col-md-3 col-lg-9 " style="height:350px">
				<div class="titulo">
					<br>
					<h1>Agenda tu cita</h1>
					<hr>
				</div>
				<form class="formulario" action="../CitaServlet" method="post" style="text-align : center">
				<h4 style ="text-align : center">Sr o Sra: <c:out value="${cliente.nombre}" /> </h4>
				<h5 style ="text-align : center">*Seleccione el dï¿½a, la hora y el servicio que desea.*</h5> 
					<div class="row">
						<div class="col-12 col-sm-6 col-md-6 col-lg-12"
							style="padding-top: 0.5rem;">
							<p>Seleccione el servicio:</p>
							<jsp:useBean id="s" class="co.urbanhair.dao.ServicioDAO">
							</jsp:useBean>
							<c:set var="l" scope="session" value="${s.list()}">
							</c:set>
							<select name="servicio"
								style="background-color: rgb(214, 205, 205); width: 30rem;">
								<option value="0">-</option>

								<c:forEach var="i" items="${l}">
									<option value="${i.idServicio}"
										style="background-color: rgb(241, 233, 233);">${i.nombre}</option>
								</c:forEach>
							</select>
						</div>


						<div class="col-12 col-sm-6 col-md-6 col-lg-12"
							style="padding-left: 5rem;">
							<p style="">Seleccione fecha y Hora:</p>
							<input name="fecha" type="datetime-local" 
								style="background-color: rgb(214, 205, 205); width: 30rem; margin-right: 3rem">
						</div>
						<div>
							<input class="boton boton-contacto btn-registro w-sm-100 "
								type="submit" value="Confirmar"   style="margin-right: 20rem"
								href="<%=request.getContextPath()%>/CitaServlet">
							<!-- <button type="submit"> Submit Form</button> -->
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<footer class="footer header-decoracion" style="margin-top: 45px">
		<div class="container-fluid">

			<div class="row">

				<div class="col-12 col-sm-4 col-md-4 col-lg-4  logo "
					style="margin-top: 3rem;">
					<h1 class="logo_nombre no-margin centrar-texto">
						Urban<span class="logo_bold">Hair</span>
					</h1>
					<img src="../img/logoingsistemas.png" alt="Logo ing sistemas"
						height="180rem" style="margin-left: 14rem;">
				</div>

				<div class="col-12  col-sm-4 col-md-4 col-lg-4 horario">
					<h4 style="color: #fff !important">HORARIOS DE ATENCIÓN</h4>
					<br>
					<p>Lunes a Viernes</p>
					<p>7:30 AM a 6:00 PM</p>
					<p>Sábado</p>
					<p>7:30 AM a 5:00 PM</p>
				</div>

				<div class="col-12  col-sm-4 col-md-4 col-lg-4 footer-contacto">
					<h4 style="color: #fff !important">CONTACTO</h4>
					<br>
					<P>Calle 17 #4 - 56 local 2 La Cabrera</P>
					<p>San José de Cúcuta - Colombia</p>
					<p>urbanhair@gmail.com</p>
					<p>+57 3165987411</p>
				</div>

			</div>
		</div>
	</footer>




	<script src="js/modernizr.js"></script>

</body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/modernizr.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
	integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
	</html>
</c:if>
<c:if test="${cliente==null}">
	<%
	response.sendRedirect("login.jsp");
	%>
</c:if>