package modelo.entidades;

public class Jugador {

	private int id;
	private String nombre;
	private String seleccion;
	private String puesto;
	private Equipo equipo;
	private int precio;
	private int puntos;
	private boolean en_venta;
	private boolean alineado;
	
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public boolean isEn_venta() {
		return en_venta;
	}
	public void setEn_venta(boolean en_venta) {
		this.en_venta = en_venta;
	}
	public boolean isAlineado() {
		return alineado;
	}
	public void setAlineado(boolean alineado) {
		this.alineado = alineado;
	}
	
}
