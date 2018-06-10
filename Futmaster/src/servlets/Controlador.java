package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="/inicio.jsp";
		
		if(op.equals("toPlantillas")){
			url="/Plantillas";
		}
		if(op.equals("toLogin")){
			url="/Login";
		}
		if(op.equals("toAlineacion")){
			url="/Alineacion";
		}
		if(op.equals("toClasificacion")){
			url="/Clasificacion";
		}
		if(op.equals("toLogOut")) {
			request.getSession().invalidate();
		}
		if(op.equals("toCalendario")) {
			url="/Calendario";
		}
		
		if(op.equals("toAdministracion")) {
			url="/Administracion";
		}
		
		if(op.equals("toPerfil")) {
			url="/Perfil";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
