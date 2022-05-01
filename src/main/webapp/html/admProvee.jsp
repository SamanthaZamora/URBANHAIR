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
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap" rel="stylesheet">

    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

    <!-- DataTable -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
     <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">

     <!--Importar CSS y script del menÃº -->
     <link rel="stylesheet" href="css/table.css" />
     <link rel="stylesheet" href="css/menuAdmin.css" />
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

  <section class="home-section">
    <!-- BARRA AZUL -->
    <div class="barra">
      <img src="img/cerrar.png" width="40px" height="40px" style="float: right;">
    </div>

    <!-- TITULO CON IMG-->
    <div class="title">
      <img src="img/provee.png" width="70px" height="70px">
      <div class="titulo">
        <h1> Proveedores</h1>
      </div>
    
      <!-- BOTON -->
      <div class="boton boton-mas">
        <a type="button" class="btn btn-lg" href="<%=request.getContextPath()%>/ServletProveedor?action=new">+</a>
      </div>
    </div>

    <!-- TABLA -->
    <div class="table-responsive table-style">
      <table id="example" class="table table-bordered table-striped table-hover">
        <thead class="table-secondary">
          <tr>
            <th class="enc" scope="col">Id</th>
            <th class="enc" scope="col">Razón Social</th>
            <th class="enc" scope="col">Email</th>
            <th class="enc" scope="col">Representante</th>
            <th class="enc" scope="col">Dirección</th>
            <th class="enc" scope="col">Teléfono</th>
            <th class="enc" scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
      		<c:forEach var="proveedor" items="${listaProveedor}">
				<tr>
					<th class="enc" scope="row"><c:out value="${proveedor.idProveedor}" /></th>
					<td><c:out value="${proveedor.razonSocial}" /></td>
					<td><c:out value="${proveedor.email}" /></td>
					<td><c:out value="${proveedor.representanteLegal}" /></td>
					<td><c:out value="${proveedor.direccion}" /></td>
					<td><c:out value="${proveedor.telefono}" /></td>
					<td>
						<div class="icons-acciones">
							<a href="<%=request.getContextPath()%>/ServletProveedor?action=edit&idProveedor=${proveedor.idProveedor}"><i class="fas fa-edit"></i></a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="ServletProveedor?action=delete&idProveedor=${proveedor.idProveedor}"><i class="fas fa-trash-alt"></i></a>
						</div> 
					</td>
				</tr>
			</c:forEach>    
        </tbody>
      </table>     
    </div>   
  </section>


  <script src="js/menuAdministrador.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
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