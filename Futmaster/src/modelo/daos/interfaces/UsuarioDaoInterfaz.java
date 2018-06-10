package modelo.daos.interfaces;

import java.util.List;

import modelo.entidades.Usuario;

public interface UsuarioDaoInterfaz {
	List<Usuario> getAll ();
	Usuario getUsuario (int id);
	Usuario getUsuarioByLogin(String correo, String pass);
}
