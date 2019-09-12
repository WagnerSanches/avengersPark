package br.com.fiap.parqueVingadores.beans;


public class Carro {
	private String placa;
	private String modelo;
	private String marca;
	private String entrada;
	
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Carro(String placa, String modelo, String marca, String entrada) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.entrada = entrada;
	}
	public Carro() {
		super();
	}
	
}
