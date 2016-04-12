<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JRuteros | Administrador</title>

<!-- jQuery y sus css -->
<link
	href="${pageContext.request.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>

<!-- Bootstrap CSS -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/fronted.css"
	rel="stylesheet">

<!-- Bootstrap JS -->
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- Dual List Box, o Select multiple -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-duallistbox/dist/jquery.bootstrap-duallistbox.min.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap-duallistbox/src/bootstrap-duallistbox.css">

</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"
				role="button" aria-haspopup="true" aria-expanded="false"> <img
				class="img-perfil" src="#" alt="Foto Perfil"><span
				class="caret"></span>
			</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#"><span class="fa fa-user" aria-hidden="true">
					</span>Administrador</a></li>
				<li><a href="listarUsuarios"><span class="fa fa-road"
						aria-hidden="true"> </span>Usuarios</a></li>
				<li><a href="listarActividades"><span class="fa fa-road"
						aria-hidden="true"> </span>Actividades</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout" class="salir">Salir</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container">

		<form role="form" type="post">
			<div class="form-group">
				<label for="ejemplo_email_1">Nombre</label> <input type="email"
					class="form-control" placeholder="Nombre de la nueva actividad">
			</div>
			<div class="form-group">
				<label for="ejemplo_password_1">Rutas</label> <select multiple
					name="rutas" id="rutas" class="form-control">
					<option value="">Ruta 1</option>
					<option value="">Ruta 2</option>
					<option value="">Ruta 3</option>
					<option value="">Ruta 4</option>
				</select>
			</div>
			<button type="button" class="btn btn-default">Enviar</button>
		</form>

	</div>


	<footer class="footer">
	<div class="container">
		<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</div>
	</footer>
	<script type="text/javascript">
		var dual1 = $("#rutas").bootstrapDualListbox();
	</script>
</body>
</html>