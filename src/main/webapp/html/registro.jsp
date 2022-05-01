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
<link rel="stylesheet" href="../css/footer.css">



</head>
<body>
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
						href="login.jsp" class="navegacion__enlaces">Login</a>
				</nav>
			</div>
		</div>

	</header>

	<!-- CONTENIDO PRINCIPAL -->

	<div class=" contacto-principal contenido-regitro ">



		<div class=" nosotros-colum-2">

			<fieldset>				
				<c:if test="${cliente == null}">
					<form class="formulario" action="../ServletCliente?action=insert" method="post">
				</c:if>

				<caption>
					<h1 style = "text-align : center">
						<c:if test="${cliente == null}"> Registrate aquí </c:if>
					</h1>
				</caption>

				<c:if test="${cliente != null}">
					<input type="hidden" name="idCliente"
						value="<c:out value='${cliente.idCliente}' />" />
				</c:if>
					<div class="contenedor-campos">

						<div class="campo">
							<label >Nombre Completo</label> <input name="nombre"
								class="input-text" type="text" placeholder="Tu Nombre"
								value="<c:out value='${cliente.nombre}' />" required>
						</div>


						<div class="campo">
							<label >Fecha de Nacimiento</label> <input
								name="fechaNacimiento" class="input-text" type="date"
								placeholder="Ingresa tu fecha de nacimiento" required>
						</div>

					<div class="formulario__grupo campo">
						<label for="nombre" class="formulario__label">Tipo deDocumento </label>
							<jsp:useBean id="tipoDoc" class="co.urbanhair.dao.TipoDocumentoDAO"></jsp:useBean>
							<c:set var="tipos" scope="session" value="${tipoDoc.list()}"></c:set>
							<select class=" input-text"
							aria-label=".form-select-sm example" name="idTipoD">
							<option selected>Tipo de documento</option>
							<c:forEach var="tipodocumento" items="${tipos}">
								<option value="${tipodocumento.idTipo}">${tipodocumento.tipoDocumento}</option>
							</c:forEach>
						</select>
					</div>

					<div class="campo">
							<label >No. Documento</label> <input
								name="noDocumento" class="input-text" type="text"
								placeholder="Digita tu número de documento"
								value="<c:out value='${cliente.noDocumento}' />" required>
						</div>

						<div class="campo">
							<label>Género</label> 
							<select
								class="input-text" name="genero">
								<option value="<c:out value='${cliente.genero}' />">Género
									al que perteneces</option>
								<option value="femenino"">Femenino</option>
								<option value="masculino"">Masculino</option>
							</select>
						</div>

						<div class="campo">
							<label >Teléfono</label> <input name="telefono"
								class="input-text" type="text" placeholder="Digita tu teléfono"
								value="<c:out value='${cliente.telefono}' />" required>
						</div>

						<div class="campo">
							<label >Correo electronico</label> <input name="email"
								class="input-text" type="email"
								placeholder="Digita tu correo electronico"
								value="<c:out value='${cliente.email}' />" required>
						</div>

						<div class="campo">
							<label >Contraseña</label> <input
								name="contrasena" class="input-text" type="password"
								placeholder="Digita tu contraseña"
								value="<c:out value='${cliente.contrasena}' />" required>
						</div>

						<div class="campo">
							<label >Tipo de usuario</label> <input
								type="text" name="idPersona" class="input-text"
								value="<c:out value='${cliente.idPersona}' />"
								placeholder="Cliente" readonly />
						</div>

					</div>
					<!-- Este es el contenedor de los campos -->
					<div>
						<input class="boton boton-contacto btn-registro w-sm-100"
							type="submit" value="Confirmar">
					</div>
				</fieldset>
			</form>
		</div>
	</div>


	<footer  class="footer header-decoracion" >
		<div class="container-fluid">
		
		  <div class="row" > 
	
			<div class="col-12 col-sm-4 col-md-4 col-lg-4  logo " style="margin-top: 3rem;">
				<h1 class="logo_nombre no-margin centrar-texto">Urban<span class="logo_bold">Hair</span></h1>
				<img src="../img/logoingsistemas.png" alt="Logo ing sistemas"  height="180rem" style="margin-left: 14rem;">
			</div>
	
			<div class="col-12  col-sm-4 col-md-4 col-lg-4 horario" >
			  <h4 style="color: #fff !important" >HORARIOS DE ATENCIÓ“N</h4> <br>
			  <p>Lunes a Viernes</p>
			  <p>7:30 AM a 6:00 PM</p>
			  <p>Sábado</p>
			  <p>7:30 AM a 5:00 PM</p>
			</div>
  
			<div class="col-12  col-sm-4 col-md-4 col-lg-4 footer-contacto" >
			  <h4 style="color: #fff !important"> CONTACTO </h4> <br>
			  <P>Calle 17 #4 - 56 local 2  La Cabrera </P>
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