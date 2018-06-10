<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import= "java.util.List,
    modelo.entidades.Equipo,
    java.text.DecimalFormat,
    gestion.GestionEquipo,
    modelo.entidades.Jugador"%>
    
<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
	
	List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
	DecimalFormat nf = new DecimalFormat("#,###");
	GestionEquipo ge = new GestionEquipo();
	List<Jugador> plantilla = (List<Jugador>) request.getAttribute("plantilla");
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag sombra">
		<div class="tituloPag"><span class="textocab">Administración</span></div>
		<div class="subPag"><span class="textocab">Equipos que compiten en la liga Futmaster Mundial Rusia 2018</span></div>
	</div>
	<table class="tablas" id="tablaAdmin">
		<caption class="titTablas">Equipos</caption>
		<tr>
			<th>Equipo / Manager</th>
			<th>Puntos / Valor Equipo</th>
			<th>Ver plantilla</th>
		</tr>
		<% for(Equipo e: equipos) {
			String valor = nf.format(ge.getValorequipo(e));
			%>
		<tr>
			<td><p><strong><%=e.getNombre() %></strong></p><span><%=e.get_usuario().getNombre() %></span></td>
			<td><p><%=e.getPuntos() %></p><span class ="textoVerde"><%=valor%> &euro;</span></td>
			<td><a href="Controlador?op=toAdministracion&id=<%=e.getId()%>"><button class="verPlantilla" onclick="verPlantilla">Plantilla</button></a></td>
		</tr>
		<%} %>
	</table>
	<table class="tablaAlineacion">
		<caption class="titTablas">Plantilla</caption>
		<%for(Jugador j :plantilla){ %>
		<tr>
			<% String puesto = j.getPuesto();
			   int id_jugador = j.getId();
			   String bandera = j.getSeleccion().toLowerCase();
			   bandera =bandera.replace("ñ","n"); 
			   bandera = bandera.replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u");
			   bandera = bandera.replace(" ","-");
			   %>
				<td class="colorPuesto <%= puesto %> "></td>
				<td class="tdImg"><img src="Resources/images/jugadores/<%=j.getId() %>.png" class="imgJugador"></td>
				<td><p><%=j.getNombre() %></p><p class="<%= puesto %>Al pequeAl"><%= puesto %></p></td>
				<td><img src="Resources/images/banderas/<%=bandera%>.png" title="<%=j.getSeleccion()%>" class="banderas"></td>
				<td><p><%=j.getPuntos() %></p><p class="textoVerde pequeAl"><%=nf.format((int)j.getPrecio()) %> &euro;</p></td>
			</tr>
		
		<%} %>
	</table>
</div>

<jsp:include page="footer.jsp"></jsp:include>