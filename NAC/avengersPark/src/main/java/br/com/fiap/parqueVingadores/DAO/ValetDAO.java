package br.com.fiap.parqueVingadores.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.parqueVingadores.beans.Carro;
import br.com.fiap.parqueVingadores.beans.Valet;
import br.com.fiap.parqueVingadores.conexao.conexao;

public class ValetDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	public ValetDAO() throws Exception{
		con = conexao.conectar();
	}
	
	
	public int addValet(Valet v) throws Exception {
		stmt = con.prepareStatement("insert into valet values(?, ?, ?, ?)");
		stmt.setString(1, v.getEntrada());
		stmt.setString(2, v.getSaida());
		stmt.setDouble(3, v.getPreco());
		stmt.setString(4, v.getVeiculo());
		
		
		return stmt.executeUpdate();
		
	}
	
public List getValets() throws Exception {
		
		List<Valet> ListaValets = new ArrayList<Valet>();
		
		stmt = con.prepareStatement("SELECT * FROM VALET");
		
		rs = stmt.executeQuery();
				
		while(rs.next()) {
			Valet v = new Valet();
			v.setVeiculo(rs.getString("veiculo"));
			v.setEntrada(rs.getString("entrada"));
			v.setSaida(rs.getString("saida"));
			v.setPreco(Double.parseDouble(rs.getString("preco")));
			ListaValets.add(v);
		}
		
		
		return ListaValets;
		
	}
	
	public void encerrar() throws Exception {
		con.close();
	}
		
}
