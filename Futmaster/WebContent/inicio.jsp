<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/estilos.css">
<link rel="shortcut icon" href="Resources/images/logos/futmaster.png">
<title>Futmaster</title>

<script type="text/javascript">
	function abrirForm() {
		document.getElementById("pop-up").classList.remove("formOculto");
		document.getElementById("pop-up").classList.add("formVisto");
	}
	
	function cerrarForm() {
		document.getElementById("pop-up").classList.remove("formVisto");
		document.getElementById("pop-up").classList.add("formOculto");
	}
</script>
</head>
<header id="main-header" class="sombra">
	<img src="Resources/images/logos/futmaster.png" id="logoFut">
	<div id="botones">
		<button name="jugar" class="boton" onclick="abrirForm()">Jugar</button>
		<button name="registrar" class="boton">Registráte</button>
		<button name="infoJuego" class="boton">Cómo jugar</b0tton>
	</div>
	<div id="pop-up" class="formOculto sombra">
		<form action="Controlador" method="get" >
		<input type="hidden" name="op" value="toLogin">
			<div class="imgForm">
				<img src="Resources/images/logos/avatar.png" id="avatar">
			</div>
			<div class="containerForm">
      			<label for="correo"><b>Usuario</b></label>
      			<input type="text" placeholder="usuario@ejemplo.com" name="correo" required pattern ="^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$">

      			<label for="psw"><b>Contraseña</b></label>
      			<input type="password" placeholder="*****" name="psw" required>
      				
      			<button type="submit">Jugar</button>
      		</div>
      		<div class="containerForm">
      			<button type="button" id="formCancelar" onclick="cerrarForm()">Cancelar</button>
    		</div>
		</form>
	</div>
</header>
<body id="principal">
<div class="slider">
	<ul>
		<li>
  <img src="http://dominicushoeve.com/wp-content/uploads/ktz/latest-high-resolution-wallpaper-1920x1080-70558-pictures-high-resolution-wallpaper-30whtvl34j4r12m8b0c1sa.jpg" alt="">
 		</li>
		<li>
  <img src="http://youghaltennisclub.ie/wp-content/uploads/2014/06/Tennis-Wallpaper-High-Definition-700x300.jpg" alt="">
		</li>
		<li>
  <img src="http://welltechnically.com/wp-content/uploads/2013/08/android-wallpapers-700x300.jpg" alt="">
		</li>
		<li>
  <img src="http://welltechnically.com/wp-content/uploads/2013/09/android-widescreen-wallpaper-14165-hd-wallpapers-700x300.jpg" alt="">
		</li>
	</ul>
</div>

<div class="modosIndex">
	<h1>Campeonatos Personalizados</h1>
	<div>
		<img src="Resources/images/logos/futbol2.png" class="logosCampeonatos">
		<h2>Campeonatos clásicos</h2>
		<p>El fantasy de toda la vida. Ideal para grandes ligas. Confecciona tu equipo desde alineación según tu presupuesto en cada jornada y compite por ser el mejor del campeonato</p>
	</div>
	<div>
		<img src="Resources/images/logos/equipo2.png" class="logosCampeonatos">
		<h2>Campeonatos sociales</h2>
		<p>El modo favorito para pequeñas ligas de amigos. Compite con hasta 25 rivales, crea tu campeonato fichando jugadores únicos en el mercado y alinea tu equipo desde alineación</p>
	</div>
</div>
<div class="modosIndex"><h1>Compite en las mejores Ligas</h1></div>
<div id="ligasIndex">
	<div>
		<img src="Resources/images/banderas/ligaEspana.png" class="ligasIndexImg">
		<h2>Primera División Española</h2>
	</div>
	<div>
		<img src="Resources/images/banderas/ligaEspana2.png" class="ligasIndexImg">
		<h2>Segunda División Española</h2>
	</div>
	<div>
		<img src="Resources/images/banderas/premierleague.png" class="ligasIndexImg">
		<h2>Liga Inglesa</h2>
	</div>
	<div>
		<img src="Resources/images/banderas/ligaItalia.png" class="ligasIndexImg">
		<h2>Liga Italiana</h2>
	</div>
	<div>
		<img src="Resources/images/banderas/ligaArgentina.png" class="ligasIndexImg">
		<h2>Liga Argentina</h2>
	</div>
	<div>
		<img src="Resources/images/banderas/champions.png" class="ligasIndexImg">
		<h2>Liga de Campeones</h2>
	</div>
</div>
<div class="modosIndex">
	<h1>!La App de Fútbol más completa del mercado!</h1>
	<p><strong>!Amplias configuraciones!</strong> Desde las más básicas, hasta crear tu campeonato completo. Futmaster se adapta a las necesidades de cada usuario</p>
	<hr>
	<p>Ligas oficiales con clubs de 1ª y 2ª y grandes webs ligadas al fútbol. Únete <strong>gratis</strong> y gana <strong>premios</strong></p>
	<hr>
	<p>Configura tu campeonato con <strong>cláusulas</strong> y roba jugadores a tus rivales</p>
	<hr>
	<p>Activa el <strong>modo entrenador</strong> y haz cambios con la jornada en curso</p>
	<hr>
	<p><strong>!Jugadores multiposición!</strong> Actívalo y haz uso de los jugadores polivalentes.</p>
	<hr>
	<p>Disfruta de las <strong>puntuaciones en directo </strong>de tus jugadores con la calidad de <strong>Opta sports</strong></p>
	<hr>
	<p>4 modos de puntuación diferentes a elegir en tu campeonato.</p>
</div>
<div>
<img src="Resources/images/estadio.jpg" id="imgFin" class="sombra">
</div>
<jsp:include page="footer.jsp"></jsp:include>