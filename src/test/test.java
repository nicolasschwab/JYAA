package test;

import java.util.Date;

import dao.impl.UsuarioDAOImpl;
import model.Usuario;

public class test {

	
	public static void main(String[] Args){
		Usuario user=new Usuario("nico","1234","apellido","nicolas","direccion",new Date(),"masculino","mail");
		new UsuarioDAOImpl().save(user);
	}
}
