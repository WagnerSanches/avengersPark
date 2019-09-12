package br.com.fiap.parqueVingadores.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.parqueVingadores.beans.Usuario;
import br.com.fiap.parqueVingadores.conexao.conexao;

public class UsuarioDAO {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	public UsuarioDAO() throws Exception{
		con = conexao.conectar();
	}
	
	public boolean verificarUsuario(Usuario usuario) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE NOME = ? AND EMAIL = ? AND SENHA = ?");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setString(3, usuario.getSenha());
		
		rs = stmt.executeQuery();
		return rs.next();
	}
	
	public void encerrar() throws Exception {
		con.close();
	}
	
	
}
