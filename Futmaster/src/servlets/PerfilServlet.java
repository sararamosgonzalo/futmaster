package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.daos.UsuarioDao;
import modelo.daos.interfaces.UsuarioDaoInterfaz;
import modelo.entidades.Equipo;
import modelo.entidades.Usuario;

/**
 * Servlet implementation class AlineacionServlet
 */
@WebServlet("/Perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Equipo equipo = (Equipo) request.getSession().getAttribute("equipo");
		UsuarioDaoInterfaz usuarioDao = new UsuarioDao();
		int id = (Integer) request.getSession().getAttribute("id");
		Usuario u = (Usuario) usuarioDao.getUsuario(id);
		request.setAttribute("usuario",u);
		request.setAttribute("equipo",equipo);
		
		RequestDispatcher rd=request.getRequestDispatcher("/perfil.jsp");
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
