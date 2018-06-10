<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,
    modelo.entidades.Jugador,
    java.text.DecimalFormat"
    
    %>
<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag sommbra">
		<div class="tituloPag"><span class="textocab">Plantillas</span></div>
		<div class="subPag"><span class="textocab">Selecciona un equipo para ver sus jugadores</span></div>
	</div>
	<div id='idBanderas' class="divContenedor sombra">
		<a href="Controlador?op=toPlantillas&seleccion=Alemania"><img src='Resources/images/banderas/alemania.png' alt="Alemania" title="Alemania" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Arabia Saudí"><img src='Resources/images/banderas/arabia-saudi.png' alt="Arabia Saudí" title="Arabia Saudí" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Argentina"><img src='Resources/images/banderas/argentina.png' alt="Argentina" title="Argentina" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Australia"><img src='Resources/images/banderas/australia.png' alt="Australia" title="Australia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Bélgica"><img src='Resources/images/banderas/belgica.png' alt="Belgica" title="Belgica" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Brasil"><img src='Resources/images/banderas/brasil.png' alt="Brasil" title="Brasil" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Colombia"><img src='Resources/images/banderas/colombia.png' alt="Colombia" title="Colombia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Corea del Sur"><img src='Resources/images/banderas/corea-del-sur.png' alt="Corea del Sur" title="Corea del Sur" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Costa Rica"><img src='Resources/images/banderas/costa-rica.png' alt="Costa Rica" title="Costa Rica" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Croacia"><img src='Resources/images/banderas/croacia.png' alt="Croacia" title="Croacia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Dinamarca"><img src='Resources/images/banderas/dinamarca.png' alt="Dinamarca" title="Dinamarca" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Egipto"><img src='Resources/images/banderas/egipto.png' alt="Egipto" title="Egipto" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=España"><img src='Resources/images/banderas/espana.png' alt="España" title="España" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Francia"><img src='Resources/images/banderas/francia.png' alt="Francia" title="Francia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Inglaterra"><img src='Resources/images/banderas/inglaterra.png' alt="Inglaterra" title="Inglaterra" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Irán"><img src='Resources/images/banderas/iran.png' alt="Irán" title="Irán" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Islandia"><img src='Resources/images/banderas/islandia.png' alt="Islandia" title="Islandia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Japón"><img src='Resources/images/banderas/japon.png' alt="Japón" title="Japón" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Marruecos"><img src='Resources/images/banderas/marruecos.png' alt="Marruecos" title="Marruecos" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=México"><img src='Resources/images/banderas/mexico.png' alt="México" title="México" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Nigeria"><img src='Resources/images/banderas/nigeria.png' alt="Nigeria" title="Nigeria" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Panamá"><img src='Resources/images/banderas/panama.png' alt="Panamá" title="Panamá" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Perú"><img src='Resources/images/banderas/peru.png' alt="Perú" title="Perú" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Polonia"><img src='Resources/images/banderas/polonia.png' alt="Polonia" title="Polonia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Portugal"><img src='Resources/images/banderas/portugal.png' alt="Portugal" title="Portugal" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Rusia"><img src='Resources/images/banderas/rusia.png' alt="Rusia" title="Rusia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Senegal"><img src='Resources/images/banderas/senegal.png' alt="Senegal" title="Senegal" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Serbia"><img src='Resources/images/banderas/serbia.png' alt="Serbia" title="Serbia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Suecia"><img src='Resources/images/banderas/suecia.png' alt="Suecia" title="Suecia" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Suiza"><img src='Resources/images/banderas/suiza.png' alt="Suiza" title="Suiza" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Túnez"><img src='Resources/images/banderas/tunez.png' alt="Túnez" title="Túnez" class='banderas'></a>
		<a href="Controlador?op=toPlantillas&seleccion=Uruguay"><img src='Resources/images/banderas/uruguay.png' alt="Uruaguay" title="Uruaguay" class='banderas'></a>
	</div>
	<% 
	
	if (request.getAttribute("jugadores")!= null )
	{
	%>
	<div id="plantillas" class="divContenedor sombra">
	<table id="tablaPlantilla" class="tablas">
	<caption class="titTablas"><%=request.getAttribute("seleccion")%></caption>
		<tr>
			<th colspan ="3">Nombre</th>
			<th>Puntos</th>
			<th>Valor</th>
			<th>Propietario</th>
		</tr>
		<%ArrayList<Jugador> jugadores=(ArrayList<Jugador>)request.getAttribute("jugadores");
		DecimalFormat nf = new DecimalFormat("#,###");
		for(Jugador j :jugadores){ %>
			<tr>
			<% String puesto = j.getPuesto();
			   int id_jugador = j.getId();%>
				<td class="colorPuesto <%= puesto %> "></td>
				<td class="tdImg"><img src="Resources/images/jugadores/<%=j.getId() %>.png" class="imgJugador"></td>
				<td><%=j.getNombre() %></td>
				<td class="tdCentrada"><%=j.getPuntos() %></td>
				<td class="tdCentrada"><%=nf.format((int)j.getPrecio()) %> &euro; </td>
				<td class="tdCentrada"><%=j.getEquipo().getNombre() %></td>
			</tr>
		
		<%} %>
	</table>
	</div>
	<% } %>
</div>
<jsp:include page="footer.jsp"></jsp:include>