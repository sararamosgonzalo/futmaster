package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.daos.JugadorDao;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Jugador;

/**
 * Servlet implementation class SeleccionesServlet
 */
@WebServlet("/Plantillas")
public class PlantillasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JugadorDaoInterfaz jugadordao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantillasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		jugadordao = new JugadorDao();
		String selec = request.getParameter("seleccion");
		
		
		ArrayList<Jugador> lista = (ArrayList<Jugador>) jugadordao.getByPorSeleccion(selec);
	
		request.setAttribute("jugadores", lista);
		request.setAttribute("seleccion", selec);
		RequestDispatcher rd=request.getRequestDispatcher("/plantillas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
