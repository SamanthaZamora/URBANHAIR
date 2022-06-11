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
<title>UrbanHair - Administración</title>

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

		<!-- FORM -->
		<main class="registro">
			<div class="encabezado">
				<c:if test="${producto != null}">
					<form action="ServletProductos?action=update" method="post">
				</c:if>

				<c:if test="${producto == null}">
					<form action="ServletProductos?action=insert" method="post">
				</c:if>

				<caption>
					<h1>
						<c:if test="${producto == null}"> Agregar producto </c:if>
						<c:if test="${producto != null}"> Editar producto </c:if>
					</h1>
				</caption>

				<c:if test="${producto != null}">
					<input type="hidden" name="idProducto"
						value="<c:out value='${producto.idProducto}' />" />
				</c:if>

				<div class="row">

					<div class="col-12  col-sm-12 col-md-6 col-lg-6">
						<div class="formulario__grupo">
							<label for="nombre" class="formulario__label">Nombre del
								producto</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="nombre"
									placeholder="Nombre del producto"
									pattern="[a-zA-ZÀ-ÿ- \s]+" required="" 
									minlength="6" maxlength="35"
									value="<c:out value='${producto.nombre}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
		
						<div class="formulario__grupo">
							<label for="cantidad" class="formulario__label">Descripción
								del Producto</label>
							<div class="formulario__grupo-input">
								<div class="form-floating ">
									<input class="form-control" name="descripcion"
										placeholder="Descripción del producto"
										pattern="[a-zA-ZÀ-ÿ- ]+" required 
										minlength="6" maxlength="40"
										style="height: 90px"> <c:out value='${producto.descripcion}' /></input>
									<i class="formulario__validacion-estado fas fa-times-circle"></i>
								</div>
							</div>
						</div>
		
						<div class="formulario__grupo" id="grupo__nombre">
							<label for="nombre" class="formulario__label">Marca</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="marca"
									placeholder="Marca del producto"
									pattern="[a-zA-ZÀ-ÿ- \s]+" required="" 
									minlength="6" maxlength="20"
									value="<c:out value='${producto.marca}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
		
						<div class="formulario__grupo" id="grupo__nombre">
							<label for="nombre" class="formulario__label">Precio</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="precio"
									placeholder="Precio por unidad"
									pattern="[0-9-.]+" required="" 
									minlength="3" maxlength="9"
									value="<c:out value='${producto.precio}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
					</div>

					<div class="col-12  col-sm-12 col-md-6 col-lg-6">
						<div class="formulario__grupo">
							<label for="cantidad" class="formulario__label">Imagen </label>
							<div class="formulario__grupo-input">
								<div class="form-floating ">
									<input class="form-control" name="imgURL" type="url"
										style="height: 70px" required>
										<c:out value='${producto.imgURL}' /></input>
								</div>
							</div>
						</div>
		
		
						<div class="formulario__grupo" id="grupo__nombre">
							<label for="nombre" class="formulario__label">Cantidad
								disponible</label>
							<div class="formulario__grupo-input">
								<input type="text" class="formulario__input" name="cantidad"
									placeholder="Cantidad existente"
									pattern="[0-9]+" required="" 
									minlength="1" maxlength="10"
									value="<c:out value='${producto.cantidad}' />"> <i
									class="formulario__validacion-estado fas fa-times-circle"></i>
							</div>
						</div>
		
		
						<div class="formulario__grupo">
							<label for="nombre" class="formulario__label">Proveedor </label> <select
								class="form-select" aria-label=".form-select-sm example"
								name="idPro">
								<option disabled>Proveedor del producto</option>
								<c:forEach var="proveedor" items="${listaProve}">
									<option value="${proveedor.idProveedor}">${proveedor.razonSocial}</option>
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

	<script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()
  </script>

</body>
	</html>
</c:if>
<c:if test="${admin==null}">
	<%
        response.sendRedirect("login.jsp");
    %>
</c:if>