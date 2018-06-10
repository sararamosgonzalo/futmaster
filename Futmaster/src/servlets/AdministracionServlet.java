package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.daos.EquipoDao;
import modelo.daos.JugadorDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Equipo;

/**
 * Servlet implementation class AlineacionServlet
 */
@WebServlet("/Administracion")
public class AdministracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EquipoDaoInterfaz equiDao = new EquipoDao();
		JugadorDaoInterfaz jugadoresDao = new JugadorDao();
		List<Equipo> equipos = equiDao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		for(Equipo e : equipos) {
			e.setJugadores(jugadoresDao.getByPorEquipo(e.getId()));
		}
		request.setAttribute("equipos", equipos);
		request.setAttribute("plantilla", jugadoresDao.getByPorEquipo(id));
		
		RequestDispatcher rd=request.getRequestDispatcher("/administracion.jsp");
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
