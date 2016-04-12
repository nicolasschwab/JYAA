<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JRuteros</title>
<%@ include file="head.jsp"%>
</head>
<body>
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand aLogo" href="#"><div class="logo"></div></a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav"> 
			<li><a href="#">¿Qué es?</a></li>
			<li><a href="#">¿Cómo funciona?</a></li>
		</ul>	
	</div>
</div>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active" style="background-image:url('resources/img/bike-3.jpg'); background-repeat:no-repeat ;">
    </div>
    <div class="item" style="background-image:url('resources/img/bike-1.jpg') ; background-repeat:no-repeat;">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="container">
	<div class="form-login">
		<form class="form-signin" action="login" method="post">
			<fieldset class="login">
			<legend>Inicia Sesión</legend>
			<div class="form-group row">
				<div class="col-md-4"><label>Usuario</label></div>				
				<div class="col-md-8"><input type="text" name="username"></div>
			</div>
			<div class="form-group row">
				<div class="col-md-4"><label>Contraseña</label></div>
				<div class="col-md-8"><input type="password" name="password"></div>
			</div>
			<div class="form-group floatLeft">
				<input type="submit" value="Iniciar Sesión">
			</div>
			<a href="registrarUsuario" class="registrate">Registrate!</a>
			</fieldset>
		</form>		
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>