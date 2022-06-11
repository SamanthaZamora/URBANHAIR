<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ admin != null }">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>UrbanHair - Administraciï¿½n</title>

<!-- Fuente de google: Open Sans - Regular 400 -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap"
	rel="stylesheet">

<!-- Boxicons CDN Link -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- DataTable -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">

<!--Importar CSS y script del menÃº -->
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/menuAdmin.css" />
<link rel="stylesheet" href="css/formulario.css" />
</head>
<body>

	<!-- NAV GRIS -->
	 <div class="sidebar"> 
      <div class="logo-details">
        <i class="fas fa-tire icon"></i>
        <!-- Espacio entre mensaje Bienvenido-->
        <div class="logo_name">Urban<strong>Hair</strong> </div>
        <i class='bx bx-menu' id="btn"></i>
      </div>
    
      <ul class="nav-list">
        <li>
          <div class="image-admin">
            <div class="container-img">
              <img src="img/login_icon.png" alt="Administrador">
            </div>
            <div class="container-name">
              <p><span class="links_name">Administrador</span></p>
            </div>
          </div>
        </li>
    
        <li>
          <a href="<%=request.getContextPath()%>/ServletInfo?action=list">
            <i class="fas fa-folder-open"></i>
            <span class="links_name">Información Empresarial</span>
          </a>
          <span class="tooltip">Información Empresarial</span>
        </li>
         <li>
          <a href="<%=request.getContextPath()%>/ServletCliente?action=list">
            <i class="fas fa-user-check"></i>
            <span class="links_name">Clientes</span>
          </a>
          <span class="tooltip">Clientes</span>
        </li>
        <li>
        <li>
          <a href="<%=request.getContextPath()%>/ServletEmpleado?action=list">
            <i class="fas fa-user-lock"></i>
            <span class="links_name">Empleados</span>
          </a>
          <span class="tooltip">Empleados</span>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/ServletProductos?action=list">
            <i class="fas fa-shopping-cart"></i>
            <span class="links_name">Productos</span>
          </a>
          <span class="tooltip">Productos</span>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/ServletProveedor?action=list"">
            <i class="fas fa-user-cog"></i>
            <span class="links_name">Proveedores</span>
          </a>
          <span class="tooltip">Proveedores</span>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/ServletServicio?action=list">
            <i class="fas fa-hand-holding-usd"></i>
            <span class="links_name">Servicios</span>
          </a>
          <span class="tooltip">Servicios</span>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/ServletPromo?action=list">
            <i class="fas fa-tags"></i>
            <span class="links_name">Promociones y Paquetes</span>
          </a>
          <span class="tooltip">Promociones y Paquetes</span>
        </li>
		<li class="profile" >
			<a href="<%=request.getContextPath()%>/Close" method="post"> 
				<i class='bx bx-log-out'></i>
					<span class="links_name">Salir</span>
			</a>
		</li>
		</ul>
    </div>

	<section class="home-section ">
		<!-- BARRA AZUL -->
		<div class="barra sticky-top">
			<img src="img/cerrar.png" width="40px" height="40px"
				style="float: right;">
		</div>


		<main class="registro">
			<div class="encabezado">
				<c:if test="${proveedor != null}">
					<form class="formulario" action="ServletProveedor?action=update" method="post">
				</c:if>

				<c:if test="${proveedor == null}">
					<form class="formulario" action="ServletProveedor?action=insert" method="post">
				</c:if>

				<caption>
					<h1>
						<c:if test="${proveedor == null}"> Agregar proveedor </c:if>
						<c:if test="${proveedor != null}"> Editar proveedor </c:if>
					</h1>
				</caption>

				<c:if test="${proveedor != null}">
					<input type="hidden" name="idProveedor"
						value="<c:out value='${proveedor.idProveedor}' />" />
				</c:if>
				<br>

				<div class="row">
					<div class="col-12  col-sm-12 col-md-6 col-lg-6">

						<div class="formulario__grupo" >
							<label for="nombre" class="formulario__label">Razón Social </label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="razonSocial"
									placeholder="Nombre de la empresa"
									pattern="[a-zA-ZÀ-ÿ- \s]+" required
									minlength="6" maxlength="35"
									value="<c:out value='${proveedor.razonSocial}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
						
						<div class="formulario__grupo" >
							<label for="nombre" class="formulario__label">Correo de la empresa</label>
							<div class="formulario__grupo-input">
								<input type="email" class="formulario__input" name="email"
									placeholder="example23@correo.com" required
									value="<c:out value='${proveedor.email}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
						
						<div class="formulario__grupo" >
							<label for="nombre" class="formulario__label">Representante de la empresa</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="representanteLegal"
									placeholder="Persona de contacto"
									pattern="[a-zA-ZÀ-ÿ- \s]+" required
									minlength="6" maxlength="35"
									value="<c:out value='${proveedor.representanteLegal}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>

					</div>

					<div class="col-12  col-sm-12 col-md-6 col-lg-6">
						
						<div class="formulario__grupo">
							<label for="nombre" class="formulario__label">Dirección</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="direccion"
									placeholder="Dirección de la empresa"
									pattern="[a-zA-ZÀ-ÿ- -0-9-#--\s]+" required
									minlength="6" maxlength="35"									
									value="<c:out value='${proveedor.direccion}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
						
						
						<div class="formulario__grupo">
							<label for="nombre" class="formulario__label">Teléfono</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="telefono"
									placeholder="Teléfono de la empresa"
									pattern="[0-9]+" required minlength="10" maxlength="10"
									value="<c:out value='${proveedor.telefono}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
		
						
						<div class="formulario__grupo" >
							<label for="nombre" class="formulario__label">Tipo de rol </label> 
							<select class="form-select" aria-label=".form-select-sm example" name="idR">
								<option disabled>Tipo de rol</option>
								<c:forEach var="tiporol" items="${listaRol}">
									<option value="${tiporol.idRol}">${tiporol.rol}</option>
								</c:forEach>
							</select>
						</div>

					</div>
				</div>

				<br>

				<div class="formulario__grupo formulario__grupo-btn-enviar">
					<button type="submit" class="formulario__btn">Continuar</button>
					<p class="formulario__mensaje-exito" id="formulario__mensaje-exito">Formulario
						enviado exitosamente!</p>
				</div>

			</form>
		</main>

	</section>


	<script src="js/menuAdministrador.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


	<script>
    $(document).ready(function () {
      $('#example').DataTable({

        "language": {
          "lengthMenu": "Mostrar_MENU_registros",
          "zeroRecords": "No se encontraron resultados",
          "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
          "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
          "infoFiltered": "(Filtrado de un total de _MAX_ registros)",
          "sSearch": "Buscar:",
          "oPaginate": {
            "sFirst": "Primero",
            "sLast": "Ãšltimo",
            "sNext": "Siguiente",
            "sPrevious": "Anterior"
          },
          "sProcessing": "Procesando...",
        }

      }
      );
    });
  </script>

</body>
</html>
</c:if>
<c:if test="${admin==null}">
    <%
        response.sendRedirect("login.jsp");
    %>
</c:if>