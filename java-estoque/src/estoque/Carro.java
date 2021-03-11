package estoque;

/**
 * Classe para armazenar os atributos e métodos do objeto Carro
 * 
 * @author Gustavo Metzler Pontes
 * @since 17 de fev. de 2021
 * 
 */
public class Carro {
	
	// Construtor
	public Carro() {
		
	}
	
	// Declarando atributos
	private Modelo modelo;
	private String placa;
	private int velocidadeMaxima;
	private String combustivel;
	private boolean disponivel;
	private boolean promocao;
	private double valor;
	private double valorPromocao;
	
	
	// Geters and setters
	/**
	 * @return the valorPromocao
	 */
	public double getValorPromocao() {
		return valorPromocao;
	}

	/**
	 * @param valorPromocao the valorPromocao to set
	 */
	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	private double desconto;
	
	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the velocidadeMaxima
	 */
	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	/**
	 * @param velocidadeMaxima the velocidadeMaxima to set
	 */
	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	/**
	 * @return the combustivel
	 */
	public String getCombustivel() {
		return combustivel;
	}

	/**
	 * @param combustivel the combustivel to set
	 */
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	/**
	 * @return the disponivel
	 */
	public boolean isDisponivel() {
		return disponivel;
	}

	/**
	 * @param disponivel the disponivel to set
	 */
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	/**
	 * @return the promocao
	 */
	public boolean isPromocao() {
		return promocao;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}


	/**
	 * @return the desconto
	 */
	public double getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

}
