<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${cliente != null}">
	<%
	response.sendRedirect("usuariodatos.jsp");
	%>
</c:if>
<c:if test="${admin != null}">
	<%
	response.sendRedirect(request.getContextPath()+"/ServletInfo?action=list");
	%>
</c:if>
<c:if test="${cliente == null && admin == null}">
	<!DOCTYPE html>
	<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Urban Hair</title>
<meta name="desciption" content="PÃ¡gina web de blog de cafÃ©">

<!--Preload-->
<link rel="preload" href="../css/normalize.css" as="style">
<link rel="stylesheet" href="../css/normalize.css">
<link rel="stylesheet" href="../css/footer.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@1&family=PT+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<!-- Fuente de google: Open Sans - Regular 400 -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap"
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




</head>
<body>
<c:if test="${mensaje!= null}"> <div class="alert-login"> <div> 
<span class="alert-login-close">X</span><span class="alert-login-message">${mensaje}</span></div> </div> </c:if>

	<header class="header-nosotros header-decoracion">
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
						href="contactanos.jsp" class="navegacion__enlaces">Contacto</a> <a
						href="login.jsp" class="navegacion__enlaces " >Login</a>
				</nav>
			</div>
		</div>

	</header>

	<!-- CONTENIDO PRINCIPAL -->

	<div class=" contacto-principal contenido-regitro ">

		<div class=" nosotros-colum-2">

			<form class="formulario " action="../login_servlet"
				method="post" ">
				<fieldset>
					<legend>Login</legend>

					<div class="campo">
						<label for="tipodocumento">Tipo de Usuario</label> <select
							class="input-text" name="rol"  required>
							<option value="0">Selecciona el tipo de usuario</option>
							<option value="1">Administrador</option>
							<option selected value="2">Cliente</option>
						</select>
					</div>

					<div class="campo">
						<label for="email">Correo electronico</label> <input name="email"
							class="input-text" type="email"
							placeholder="Digita tu correo electronico" required>
					</div>

					<div class="campo">
						<label for="contrasena">Clave</label> <input name="contrasena"
							class="input-text" type="password" placeholder="Digita tu clave"
							required>
					</div>

					<div class="login-p ">
						<input class="boton boton-contacto btn-login " type="submit"
							value="Login"> <a href="../html/registro.jsp"><p class="no"> Registrate.</p></a>
					</div>
				</fieldset>
			</form>
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
					<h4 style="color: #fff !important">HORARIOS DE ATENCION</h4>
					<br>
					<p>Lunes a Viernes</p>
					<p>7:30 AM a 6:00 PM</p>
					<p>Sabado</p>
					<p>7:30 AM a 5:00 PM</p>
				</div>

				<div class="col-12  col-sm-4 col-md-4 col-lg-4 footer-contacto">
					<h4 style="color: #fff !important">CONTACTO</h4>
					<br>
					<P>Calle 17 #4 - 56 local 2 La Cabrera</P>
					<p>San Jose de Cucuta - Colombia</p>
					<p>urbanhair@gmail.com</p>
					<p>+57 3165987411</p>
				</div>

			</div>
		</div>
	</footer>



	<script src="js/modernizr.js"></script>
<script type="text/javascript" src='../js/mensaje.js'></script>
<script type="text/javascript">
alertlogin();
</script>
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