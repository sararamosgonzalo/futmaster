<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,
    modelo.entidades.Jugador,
    modelo.entidades.Equipo,
    java.text.DecimalFormat"
    %>

<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
	ArrayList<Jugador> plantilla = (ArrayList<Jugador>) request.getAttribute("plantilla");
	ArrayList<Jugador> alineacion = (ArrayList<Jugador>) request.getAttribute("alineacion");
	Equipo equipo = (Equipo) session.getAttribute("equipo");
	String imagenDefault = "Resources/images/perfil.png";
	DecimalFormat nf = new DecimalFormat("#,###");
	Jugador portero = new Jugador();
	ArrayList<Jugador> delanteros = new ArrayList<Jugador>();
	ArrayList<Jugador> defensas = new ArrayList<Jugador>(); 
	ArrayList<Jugador> medios = new ArrayList<Jugador>(); 
	
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag sombra">
		<div class="tituloPag"><span class="textocab">Alineación</span></div>
		<div class="subPag">
			<%if (request.getAttribute("alineacionCorrecta")!= null && (request.getAttribute("alineacionCorrecta").equals("false"))){ %>
				<span class="negativo textocab">
					La alineación debe ser de 11 Jugadores
				</span>
			<%} else { %>
				<span class="textocab">
					Completa la alineación de la jornada con los jugadores de tu equipo
				</span>
			<%}%>
		</div>
	</div>
	<div id="divAlineacion">
	<img id="campoAlineacion" src="Resources/images/campo.png">
	<% for(Jugador a : alineacion) {
		if(a.getPuesto().equals("portero")) {
			portero = a;
		}else if(a.getPuesto().equals("delantero")) {
			delanteros.add(a);
		}else if(a.getPuesto().equals("defensa")) {
			defensas.add(a);
		}else if(a.getPuesto().equals("medio")) {
			medios.add(a);
		}
		}%>
		
		<%if(delanteros.size()>0) { %>
		<div id="delantero1" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=delanteros.get(0).getId()%>.png">
			<p class="rotuloAlineacion delantero"><%=delanteros.get(0).getNombre() %></p>
		</div>
		<div id="delantero2" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=delanteros.get(1).getId()%>.png">
			<p class="rotuloAlineacion delantero"><%=delanteros.get(1).getNombre() %></p>
		</div>
		<div id="medio1" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=medios.get(0).getId()%>.png">
			<p class="rotuloAlineacion medio"><%=medios.get(0).getNombre() %></p>
		</div>
		<div id="medio2" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=medios.get(1).getId()%>.png">
			<p class="rotuloAlineacion medio"><%=medios.get(1).getNombre() %></p>
		</div>
		<div id="medio3" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=medios.get(2).getId()%>.png">
			<p class="rotuloAlineacion medio"><%=medios.get(2).getNombre() %></p>
		</div>
		<div id="medio4" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=medios.get(3).getId()%>.png">
			<p class="rotuloAlineacion medio"><%=medios.get(3).getNombre() %></p>
		</div>
		<div id="defensa1" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=defensas.get(0).getId()%>.png">
			<p class="rotuloAlineacion defensa"><%=defensas.get(0).getNombre() %></p>
		</div>
		<div id="defensa2" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=defensas.get(1).getId()%>.png">
			<p class="rotuloAlineacion defensa"><%=defensas.get(1).getNombre() %></p>
		</div>
		<div id="defensa3" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=defensas.get(2).getId()%>.png">
			<p class="rotuloAlineacion defensa"><%=defensas.get(2).getNombre() %></p>
		</div>
		<div id="defensa4" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=defensas.get(3).getId()%>.png">
			<p class="rotuloAlineacion defensa"><%=defensas.get(3).getNombre() %></p>
		</div>
		<div id="portero" class="jugadoresAlineacion">
			<img class="imgAlineacion" src="Resources/images/jugadores/<%=portero.getId()%>.png">
			<p class="rotuloAlineacion portero"><%=portero.getNombre() %></p>
		</div>
	<%}else { 
		for(int i=1; i<3; i++) {%>
		<div id="delantero<%=i %>" class="jugadoresAlineacion">
			<img class="imgAlineacion" src=<%=imagenDefault%>>
			<p class="rotuloAlineacion delantero"></p>
		</div>
		<%} 
		for(int i=1; i<5;i++) {%>
		<div id="medio<%=i %>" class="jugadoresAlineacion">
			<img class="imgAlineacion" src=<%=imagenDefault%>>
			<p class="rotuloAlineacion medio"></p>
		</div>
		<%} 
		for(int i=1; i<5;i++) {%>
		<div id="defensa<%=i %>" class="jugadoresAlineacion">
			<img class="imgAlineacion" src=<%=imagenDefault%>>
			<p class="rotuloAlineacion defensa"></p>
		</div>
	<%} %>
		<div id="portero" class="jugadoresAlineacion">
			<img class="imgAlineacion" src=<%=imagenDefault%>>
			<p class="rotuloAlineacion portero"></p>
		</div>
	<%} %>
	</div>
	<div id="plantillaEquipo">
	<form action="Controlador" method="post">
	<input type="hidden" name="op" value="toAlineacion">
	<input type="hidden" name="formAlineacion" value="si">
		<table class="tablaAlineacion">
			<caption class="titTablas"><%=equipo.getNombre()%></caption>
			<%for(Jugador j :plantilla){ %>
			<tr>
			<% String puesto = j.getPuesto();
			   int id_jugador = j.getId();
			   String bandera = j.getSeleccion().toLowerCase();
			   bandera =bandera.replace("ñ","n"); 
			   bandera = bandera.replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u");
			   bandera = bandera.replace(" ","-");
			   //String imgAlt = "Resources/images/banderas/"+bandera+"-alt.png";
			   %>
				<td class="colorPuesto <%= puesto %> "></td>
				<td class="tdImg"><img src="Resources/images/jugadores/<%=j.getId() %>.png" class="imgJugador"></td>
				<td><p><%=j.getNombre() %></p><p class="<%= puesto %>Al pequeAl"><%= puesto %></p></td>
				<td><img src="Resources/images/banderas/<%=bandera%>.png" title="<%=j.getSeleccion()%>" class="banderas"></td>
				<td><p><%=j.getPuntos() %></p><p class="textoVerde pequeAl"><%=nf.format((int)j.getPrecio()) %> &euro;</p></td>
				<td><input type="checkbox" id="checkAlineado" name="alineado" value="<%=j.getId() %>"></td>
			</tr>
		
		<%} %>
		<tr><td colspan="6"><button type="submit" id="botonAlinear" class="sombra">Alinear</button></td></tr>
		</table>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>