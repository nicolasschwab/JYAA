<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JRuteros | Administrador</title>


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


</head>
<body>


	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand aLogo" href="#"><div class="logo"></div></a>
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
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="#" class="dropdown-toggle" role="button"
					aria-haspopup="true" aria-expanded="false"> <img
						class="img-perfil" src="#" alt="Foto Perfil">
				</a></li>
				<li><a href="logout" class="salir">Salir</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container">

		<ul class="nav nav-tabs">
			<li class="active" id="liHab"><a href="#">Actividades
					Habilitadas</a></li>
			<li id="liDes"><a href="#">Actividades Deshabilitadas</a></li>
			<li class="nav navbar-nav navbar-right ">
				<form class="form-inline" action="login" method="post">

					<div class="form-group">
						<input type="text" name="username"
							placeholder="Nombre actividad nueva" class="form-control">
					</div>
					<div class="form-group">
						<label><input type="checkbox" name="habilitada">
							Habilitada</label>
					</div>
					<input class="btn btn-primary" type="button"
						value="Crear Actividad">

				</form>

			</li>
		</ul>

		<div class="well well-lg" id="tablaHabilitada">


			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Mountain Bike</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">

						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Deshabilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar" disabled="disabled" />
					</div>

				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Cicloturismo</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">

						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Deshabilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar"
							disabled="disabled" />
					</div>

				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Senderismo</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">

						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Deshabilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar" />
					</div>

				</div>
			</div>
		</div>
		
		

		<div class="well well-lg" style="display: none"
			id="tablaDeshabilitada">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Esquí</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Habilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar" />
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Kayac</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Habilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar" disabled="disabled"/>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-5">
						<h4>Motociclismo</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Habilitar" />
					</div>
					<div class="col-md-2 btn-group-vertical">
						<input type="button" class="btn btn-default" value="Eliminar" />
					</div>
				</div>
			</div>
		</div>


	</div>


	<footer class="footer">
	<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</footer>

	<script type="text/javascript">
		$("#liDes").click(function() {
			$("#liHab").removeClass("active");
			$("#tablaHabilitada").hide();
			$(this).addClass("active");
			$("#tablaDeshabilitada").show();
		});
		$("#liHab").click(function() {
			$("#liDes").removeClass("active");
			$("#tablaDeshabilitada").hide();
			$(this).addClass("active");
			$("#tablaHabilitada").show();
		});
	</script>

</body>
</html>