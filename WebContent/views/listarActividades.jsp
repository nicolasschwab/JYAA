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
			<li><div>
					<a href="altaActividad" class="btn btn-primary">Crear actividad</a>
				</div></li>
		</ul>

		<div class="well well-lg" id="tablaHabilitada">


			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/bike-3.jpg">
					</div>
					<div class="col-md-6">
						<h3>Actividad 1</h3>
						<h4>Mountain bike - Ciclismo - Cicloturismo - Senderismo</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar"
								disabled="disabled" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/none.png">
					</div>
					<div class="col-md-6">
						<h3>Actividad 3</h3>
						<h4>- No se encontraron rutas asociadas -</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/bike-1.jpg">
					</div>
					<div class="col-md-6">
						<h3>Actividad 5</h3>
						<h4>Alpinismo - Motociclismo - Kayac</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar"
								disabled="disabled" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

		</div>


		<div class="well well-lg" style="display: none"
			id="tablaDeshabilitada">

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/none.png">
					</div>
					<div class="col-md-6">
						<h3>Actividad 2</h3>
						<h4>- No se encontraron rutas asociadas -</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar"
								disabled="disabled" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/bike-1.jpg">
					</div>
					<div class="col-md-6">
						<h3>Actividad 4</h3>
						<h4>Ciclismo - Senderismo - Kayac</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail col-md-3">
						<img alt="Actividad" src="resources/img/bike-3.jpg">
					</div>
					<div class="col-md-6">
						<h3>Actividad 6</h3>
						<h4>Alpinismo - Cicloturismo - Senderismo</h4>
					</div>
					<div class="col-md-2 btn-group-vertical">
						<div class="btn-group">
							<a href="altaActividad" class="btn btn-warning" role="button">Modificar</a>
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Deshabilitar" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-default" value="Eliminar"
								disabled="disabled" />
						</div>
						<div class="btn-group">
							<input type="button" class="btn btn-success" value="Detalle" />
						</div>

					</div>
				</div>
			</div>

		</div>

	</div>

	<footer class="footer">
	<div class="container">
		<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</div>
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