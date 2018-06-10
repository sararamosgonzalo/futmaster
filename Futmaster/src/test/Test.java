package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.daos.EquipoDao;
import modelo.daos.JugadorDao;
import modelo.daos.PartidoDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.daos.interfaces.PartidoDaoInterfaz;
import modelo.entidades.Equipo;
import modelo.entidades.Jugador;
import modelo.entidades.Partido;

public class Test {

	/**
	 * @param args
	 */
	static List<Equipo> equipos;
	static List<Jugador> jugadores;
	static List<Partido> partidos;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	todos();
		//jugadorePorSeleccion("Argentina");
//jugadorePorequipo(2);
		//partidosporseleccion("España");
		partidosporjornada(1);
		//todospartidos();
		//todospartidos();
		//alineadosporequipo(2);
	}
	
	
	
	
	public static void  todos(){
		EquipoDaoInterfaz edao = new EquipoDao();
		equipos =edao.getAll();
		
		for (Equipo equipo : equipos) {
			
			System.out.println(equipo.getNombre()+" - " +equipo.getSaldo());
		}
	}
	
	public static void  jugadorePorSeleccion(String seleccion){
		JugadorDaoInterfaz edao = new JugadorDao();
		jugadores =edao.getByPorSeleccion(seleccion);
		
		for (Jugador jugador : jugadores) {
			
			System.out.println(jugador.getNombre()+ " Pertenece a: " + jugador.getEquipo().getNombre());
		}
	}
	
	public static void  jugadorePorequipo(int equipo){
		JugadorDaoInterfaz edao = new JugadorDao();
		jugadores =edao.getByPorEquipo(equipo);
		
		for (Jugador jugador : jugadores) {
			
			System.out.println(jugador.getNombre()+"  "+jugador.isAlineado()+" "+jugador.isEn_venta());
		}
	}
	
	public static void partidosporseleccion(int seleccion) {
		PartidoDaoInterfaz pdao=new PartidoDao();
		partidos= pdao.getBySeleccion(seleccion);
		
		for(Partido partido : partidos) {
			System.out.println(partido.getEquipoLocal()+" "+partido.getEquipoVisitante()+" "+partido.getFecha());
		}
	}
	
	public static void partidosporjornada(int jornada) {
		PartidoDaoInterfaz pdao=new PartidoDao();
		partidos= pdao.getByJornada(jornada);
		
		for(Partido partido : partidos) {
			System.out.println(partido.getEquipoLocal()+" "+partido.getEquipoVisitante()+" "+partido.getFecha());
		}
	}
	

	public static void  todospartidos(){
		PartidoDaoInterfaz pdao=new PartidoDao();
		partidos= pdao.getAll();
//		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
//		DateFormat df2 = new SimpleDateFormat("HH:mm");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (Partido partido : partidos) {
			DateFormat df2 = new SimpleDateFormat("HH:mm");
			System.out.println(partido.getEquipoLocal()+" "+partido.getEquipoVisitante()+"   "+df2.format(partido.getFecha()));
		}
	}
	
	public static void alineadosporequipo(int equipo) {
		JugadorDaoInterfaz edao = new JugadorDao();
		jugadores = edao.getAlineadosByEquipo(equipo);
		
		for (Jugador j :jugadores) {
			System.out.println(j.getNombre()+"  "+j.getId());
		}
	}
	
	public static void partidosporfecha() {
		PartidoDaoInterfaz pdao=new PartidoDao();
		List<Partido> partidos = pdao.getByJornada(1);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		for(Partido p:partidos) {
			//p.getFecha()
			//if(DATE_FORMAT.format(p.getFecha())  ) {}
		}
	}

}
