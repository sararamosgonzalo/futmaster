<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import= "modelo.entidades.Equipo,
    modelo.entidades.Usuario"%>
<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
	
	Equipo equipo =(Equipo) request.getAttribute("equipo");
	Usuario usuario =(Usuario) request.getAttribute("usuario");
%>
<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag">
		<div class="tituloPag"><span class="textocab">Mi Perfil</span></div>
		<div class="subPag"><span class="textocab">Puedes modificar tus datos de perfil</span></div>
	</div>
	<div>
	<form id="formPerfil">
	<div>
		<label for="nameUsuario">Nombre</label>
		<input type="text" placeholder= <%=usuario.getNombre() %> name="nameUsuario">
	</div>
	<div>
		<label for="nameEquipo">Nombre del equipo</label>
		<input type="text" placeholder="<%=equipo.getNombre() %>" name="nameEquipo">
	</div>
		<button type="submit">Modificar</button>
		<button type="button" id="abandonar">Abandonar Campeonato</button>
		<p>*¡OJO! Abandonar el campeonato implica perder todos tus datos sobre este campeonato</p>
	</form>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>