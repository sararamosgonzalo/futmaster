package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion.GestionEquipo;
import modelo.daos.EquipoDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.entidades.Equipo;

/**
 * Servlet implementation class ClasificacionServlet
 */
@WebServlet("/Clasificacion")
public class ClasificacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasificacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EquipoDaoInterfaz equiDao = new EquipoDao();
		
		request.setAttribute("clasificacion", equiDao.getClasificacionEquipos());
		RequestDispatcher rd=request.getRequestDispatcher("/clasificacion.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
