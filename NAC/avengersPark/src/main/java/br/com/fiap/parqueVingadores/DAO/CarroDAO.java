package br.com.fiap.parqueVingadores.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import br.com.fiap.parqueVingadores.beans.Carro;
import br.com.fiap.parqueVingadores.conexao.conexao;

public class CarroDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	public CarroDAO() throws Exception{
		con = conexao.conectar();
	}
	
	public int adicionarCarro(Carro carro) throws Exception {
		stmt = con.prepareStatement("insert into VEICULO values(?, ?, ?, ?)");
		stmt.setString(1, carro.getPlaca());
		stmt.setString(2, carro.getMarca());
		stmt.setString(3, carro.getModelo());
		stmt.setString(4, carro.getEntrada());
		
		return stmt.executeUpdate();
	}
	
	public List getCarros() throws Exception {
		
		List<Carro> ListaCarros = new ArrayList<Carro>();
		
		stmt = con.prepareStatement("SELECT * FROM VEICULO");
		
		rs = stmt.executeQuery();
				
		while(rs.next()) {
			Carro carro = new Carro();
			carro.setPlaca(rs.getString("placa"));
			carro.setModelo(rs.getString("Modelo"));
			carro.setMarca(rs.getString("MARCA"));
			carro.setEntrada(rs.getString("ENTRADA"));
			ListaCarros.add(carro);
		}
		
		
		return ListaCarros;
	}
	public int deletCarro(String placa) throws Exception { 
		stmt = con.prepareStatement("DELETE FROM VEICULO WHERE placa = ?");
		stmt.setString(1, placa);
		return stmt.executeUpdate();
	}
	
	
	public void encerrar() throws Exception {
		con.close();
	}
}
