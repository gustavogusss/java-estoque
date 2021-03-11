package estoque;

/**
 * Classe para armazenar os atributos e métodos do objeto Modelo
 * 
 * @author Gustavo Metzler Pontes
 * @since 17 de fev. de 2021
 * 
 */
public class Modelo {
	
	// Método construtor
	public Modelo() {
		
	}
	
	// Declarando atributos
	private String nome;
	private Marca marca;

	// Getters and setters
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
