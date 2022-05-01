<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Urban Hair</title>
<meta name="desciption" content="PÃ¡gina web de blog de cafÃ©">
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
	<header class="header-servicios header-decoracion">
		<div class="contenedor">
			<div class="barra">
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
					<c:if test="${ cliente != null }">
						<li class="dropdown noponer" style="list-style-type: none;"><a
							href="#" class="dropdown-toggle navegacion__enlaces"
							data-toggle="dropdown"> <c:out value="${cliente.nombre}" /></a>
							<ul class="dropdown-menu navegacion-usuario">
								<li><a class="dropdown-item navegacion-usuario"
									href="usuariodatos.jsp">Mi cuenta</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="usuariocitas.jsp">Citas</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="usuariosprom.jsp">Promociones</a></li>
								<li><a class="dropdown-item navegacion-usuario"
									href="<%=request.getContextPath()%>/Close" method="post">Salir</a></li>
							</ul></li>
					</c:if>
					<c:if test="${ cliente == null }">
						<a href="login.jsp" class="navegacion__enlaces">Login</a>
					</c:if>
					<c:if test="${ cliente != null }">
						<svg xmlns="http://www.w3.org/2000/svg" style="color: #fff"
							width="50" height="50" fill="currentColor"
							class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                            <path fill-rule="evenodd"
								d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                            </svg>
					</c:if>
				</nav>
			</div>
		</div>
		<div class="header__texto">
			<h2 class="no-margin">Nuestros Servicios</h2>
			<p class="no-margin">Aprender de los expertos con los mejores
				cortes y peinados</p>
		</div>
	</header>



	<!--  NUESTROS SERVICIOS -->

	<div class=" text-center header__texto ">
		<h2 style="color: black !important;">Nuestros Servicios</h2>
		<hr>

		<jsp:useBean id="servicio" class="co.urbanhair.dao.ServicioDAO">
		</jsp:useBean>

		<c:set var="s" scope="session" value="${servicio.list()}">
		</c:set>



		<div class="row row-serv">
			<c:forEach var="w" items="${s}">
				<div class="col-12 col-sm-6 col-md-6 col-lg-4 ">
					<div class="card mb-3 fijo">
						<img src="${w.imgURL}" class="card-img-top" width="100"
							height="300">
						<div class="card-body" style="height: 200px">
							<h3 class="card-title" style="color: black">${w.nombre}</h3>
							<p class="card-text" style="color: black">${w.descripcion}</p>
							<p class="card-text">
								<small class="text-muted">Pregunta por nuestros precios</small>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>


	<div class=" text-center header__texto ">
		<h2 style="color: black !important;">Registrate en nuestro
			aplicativo web</h2>
		<br>
		<div class="card bg-dark text-white">
			<img src="../img/peluser.jpg" class="card-img">
			<div class="card-img-overlay">
				<p class="card-text">Solo los usuarios logueados pueden hacer
					el agendamiento de un servicio de forma virtual, conocer los
					precios de nuestros productos y servicios y además enterarse de
					las promociones exclusivas que solo son reveladas para ellos.</p>
			</div>
		</div>

	</div>


	<footer class="footer header-decoracion">
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