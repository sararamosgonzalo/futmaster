package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestion.GestionEquipo;
import gestion.GestionUsuario;
import modelo.daos.EquipoDao;
import modelo.daos.JugadorDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Equipo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("correo");
		String pass = request.getParameter("psw");
		String url = "/inicio.jsp";
		
		JugadorDaoInterfaz jugadoresDao = new JugadorDao();
		EquipoDaoInterfaz equiDao = new EquipoDao();

		GestionUsuario gu = new GestionUsuario();
		
		//comprobamos que exista el usuario
		Integer id= gu.usuarioCorrecto(correo, pass);
		HttpSession sesion = request.getSession();
		
		//Si existe requperamos el equipo y vamos a administracion.jsp:
		if (id!=null)
		{
			List<Equipo> equipos = equiDao.getAll();
			for(Equipo e : equipos) {
				e.setJugadores(jugadoresDao.getByPorEquipo(e.getId()));
			}
			request.setAttribute("equipos", equipos);
			url = "/administracion.jsp";
			Equipo equipo;
			//Recuperamos el equipo del usuario con su id 
			equipo = equiDao.getEquipoByUsuario(id);
			//Recuperamos la lista de jugadores  para meterla en el equipo:
			equipo.setJugadores(jugadoresDao.getByPorEquipo(equipo.getId()));
			
			sesion.setAttribute("id",id);
			sesion.setAttribute("equipo",equipo);
			request.setAttribute("plantilla",equipo.getJugadores());
					
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
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
