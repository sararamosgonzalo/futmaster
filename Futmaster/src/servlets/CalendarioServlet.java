package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.daos.PartidoDao;
import modelo.daos.interfaces.PartidoDaoInterfaz;
import modelo.entidades.Partido;

/**
 * Servlet implementation class ClasificacionServlet
 */
@WebServlet("/Calendario")
public class CalendarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PartidoDaoInterfaz pDao = new PartidoDao();
		
		request.setAttribute("jornada1", pDao.getByJornada(1));
		request.setAttribute("jornada2", pDao.getByJornada(2));
		request.setAttribute("jornada3", pDao.getByJornada(3));
		RequestDispatcher rd=request.getRequestDispatcher("/calendario.jsp");
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
