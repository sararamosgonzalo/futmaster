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
import modelo.daos.JugadorDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Equipo;

/**
 * Servlet implementation class AlineacionServlet
 */
@WebServlet("/Alineacion")
public class AlineacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlineacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String es_form = request.getParameter("formAlineacion");
		Equipo equipo = (Equipo) request.getSession().getAttribute("equipo");
				
		EquipoDaoInterfaz equiDao = new EquipoDao();
		JugadorDaoInterfaz jugadoresDao = new JugadorDao();
		
		
		if(es_form.equals("si")) { 
			//Hacemos la modificacion en bbdd para borrar la alineacion antigua:
			jugadoresDao.eliminarAlineacion(equipo.getId());
			//recuperamos los jugadores recuperados del checkçbox
			String[] alineados = request.getParameterValues("alineado");
			//Si ha seleccionado mas de 11 error y vuelve a la pagina
			if (alineados ==null || alineados.length != 11) {
				request.setAttribute("alineacionCorrecta", "false");
			}else {
				//Hacemos la modificacion en bbdd para añadir la nueva alineacion:
				jugadoresDao.crearAlineacion(alineados);
				//Recuperamos el equipo del usuario de la bbdd ya actualizado			
				Integer id = (Integer) request.getSession().getAttribute("id");
				equipo = equiDao.getEquipoByUsuario(id);
				//Y le añadimos la lista de jugadores:
				equipo.setJugadores(jugadoresDao.getByPorEquipo(equipo.getId()));
				request.setAttribute("alineacionCorrecta", "true");
			}
			
		}
		request.setAttribute("alineacion", jugadoresDao.getAlineadosByEquipo(equipo.getId()) );
		request.setAttribute("plantilla",equipo.getJugadores());
		RequestDispatcher rd=request.getRequestDispatcher("/alineacion.jsp");
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
