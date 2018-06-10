package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.daos.JugadorDao;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Jugador;

/**
 * Servlet implementation class MercadoServlet
 */
@WebServlet("/Mercado")
public class MercadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cambiarTransferibles = request.getParameter("cambiarTransferibles");
		JugadorDaoInterfaz jugadordao =  new JugadorDao();
		
			
		
		//Si viene del boton cambiar los transferibles
		if(cambiarTransferibles.equals("si")) { 
			//Hacemos la modificacion en bbdd para borrar los transferibleas actuales:
			jugadordao.eliminarTransferibles();
			//recuperamops todos los ids de los jugadores cuyo equipo es futmondo:
			List<Integer> listaIds = jugadordao.getIdsJugadoresByEquipo(11);
			//Elijo al azar 20 y cargo la listarandon:
			List<Integer> listaRandon = new ArrayList<Integer>();
			Random r = new Random();
			while (listaRandon.size()<20) {
				int valorDado = r.nextInt(524);
				if(listaIds.contains(valorDado) && !listaRandon.contains(valorDado)) {
					listaRandon.add(valorDado);
				}
			}
			//le paso los ids generdos aleatoriamente para que me cambie los transferibles:
			jugadordao.changeJugadoresEnVenta(listaRandon);
	
		}
		
		ArrayList<Jugador> lista = (ArrayList<Jugador>) jugadordao.getJugadoresEnVenta();
		request.setAttribute("jugadoresEnVenta", lista);
		
		RequestDispatcher rd=request.getRequestDispatcher("/mercado.jsp");
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
