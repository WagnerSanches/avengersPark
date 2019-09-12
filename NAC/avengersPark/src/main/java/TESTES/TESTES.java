package TESTES;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.fiap.parqueVingadores.DAO.UsuarioDAO;
import br.com.fiap.parqueVingadores.beans.Usuario;

public class TESTES {
	
	public static void main(String[] args) {
		UsuarioDAO udao = null;
		try {
			udao = new UsuarioDAO();
			boolean r = udao.verificarUsuario(new Usuario("wagner", "wagner@hotmail.com", "123"));	
			if(r) {
				System.out.println("USUARIO EXISTE");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date d =  new Date();
				System.out.println("NAO EDXISTE" + sdf.format(d));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				udao.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
