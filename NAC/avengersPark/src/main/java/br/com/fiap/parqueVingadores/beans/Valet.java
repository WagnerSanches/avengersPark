package br.com.fiap.parqueVingadores.beans;

import java.util.Date;

public class Valet {
	private double PRECO_BASE = 4.00;
	private double PRECO_ADICIONAL = 2.50;
	private long TEMPO_MINIMO = 6;
	private String entrada;
	private String saida;
	private double preco;
	private String veiculo;
	
	
	
	
	public Valet() {}
	
	public Valet(String veiculo, String entrada, String saida, double preco) {
		super();
		this.entrada = entrada;
		this.saida = saida;
		this.preco = preco;
		this.veiculo = veiculo;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public double calcularPagamento(Date entrada, Date saida) {
		double preco = 0.0;
		
		long tempoPermanecia = (saida.getTime() - entrada.getTime()) / 1000 / 60;
		long horas = tempoPermanecia / 60;
		long minutos = tempoPermanecia % 60;
		if (this.temHorasAdicionais(this.qtdeHorasAdicionais(horas))) {
			preco = this.PRECO_BASE;
			preco = preco + this.qtdeHorasAdicionais(horas) * this.PRECO_ADICIONAL;
				if (minutos > 0) {
					preco = preco + this.PRECO_ADICIONAL;
				}
				} else {
					preco = this.PRECO_BASE;
				}
				return preco;
		}
		
		public long qtdeHorasAdicionais(long horas) {
			return horas - this.TEMPO_MINIMO;
		}
		public boolean temHorasAdicionais(long horasAdicionais) {
			return horasAdicionais > 0;
		}

	
}

