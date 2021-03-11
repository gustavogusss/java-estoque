package estoque;

import javax.swing.JOptionPane;

/**
 * Classe para efetuar o processamento de consulta e inclus�o de estoque
 * 
 * @author Gustavo Metzler Pontes
 * @since 17 de fev. de 2021
 * 
 */
public class VendaCarro {

	// Vetor para armazenar os carros cadastrados
	private Carro estoque[];

	// Vari�vel auxiliar para definir o tamanho do estoque
	private int tamanho = 0;

	// Construtor da classe
	public VendaCarro() {
		processar();
	}

	// M�etodo principal do programa

	public void processar() {

		// Capturando do usu�rio o tamanho do estoque
		tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do estoque: "));

		// Definindo o tamanho do estoque de carros
		estoque = new Carro[tamanho];

		while (true) {
			escolhaUsuario();
		}
	}

	// M�todo para capturar do usu�rio a op��o
	public void escolhaUsuario() {
		String menu = "Informe a op��o desejada:\n\n" + "OP��O 1: Cadastrar Carro\n" + "OP��O 2: Listar Estoque\n"
				+ "OP��O 3: Consultar Carro\n" + "OP��O 4: Pesquisar por Modelos\n"
				+ "OP��O 5: Pesquisar por Combust�vel\n" + "OP��O 6: Listar Carros em Promo��o\n"
				+ "OP��O 7: Sair do Sistema\n";
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// M�todo para sele��o das op��es do programa
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarCarro();
			break;
		case 2:
			listarEstoque();
			break;
		case 3:
			consultarCarro();
			break;
		case 4:
			pesquisarPorModelo();
			break;
		case 5:
			pesquisarPorCombustivel();
			break;
		case 6:
			listarCarrosEmPromocao();
			break;
		case 7:
			sairDoSistema();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Cadastro de estoque", 0); // erro
			break;
		}
	}

	// M�todo para efetuar o cadastro de um novo carro no estoque
	public void cadastrarCarro() {
		// Vari�vel auxiliar para verificar se gravou o carro no estoque
		boolean gravado = false;

		// La�o para verificar espa�o em estoque
		for (int i = 0; i < estoque.length; i++) {// inicio for
			if (estoque[i] == null) {
				estoque[i] = criarCarro();
				gravado = true;
				break;
			}
		} // fim for

		// Exibindo resultado para o usu�rio
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Ve�culo gravado com sucesso!", "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque cheio!", "Cadastro de Estoque", 2);
		}
	}

	// M�todo para devolver um carro para cadastro no estoque
	public Carro criarCarro() {
		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		Carro carro = new Carro();

		// Recebendo do usu�rio a marca do carro
		marca.setNome(JOptionPane.showInputDialog("Informe o nome da marca"));
		// Recebendo do usu�rio o nome do modelo do carro
		modelo.setNome(JOptionPane.showInputDialog("Informe o nome do modelo"));

		// Atribuindo a marca ao modelo do carro
		modelo.setMarca(marca);

		// Recebendo os dados do carro
		carro.setPlaca(JOptionPane.showInputDialog("Informe a placa"));
		carro.setVelocidadeMaxima(Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade m�xima")));
		carro.setCombustivel(JOptionPane.showInputDialog("Informe o combust�vel"));

		int disponivel = Integer.parseInt(JOptionPane.showInputDialog("1 - Dispon�vel\n" + "2 - N�o dispon�vel"));

		if (disponivel == 1) {
			carro.setDisponivel(true);
		} else {
			carro.setDisponivel(false);
		}

		int promocao = Integer.parseInt(JOptionPane.showInputDialog("1 - Em promo��o\n" + "2 - N�o est� em promo��o"));

		if (promocao == 1) {
			carro.setPromocao(true);
		} else {
			carro.setPromocao(false);
		}

		carro.setValor(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor")));
		carro.setValorPromocao(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor em promo��o")));
		carro.setDesconto(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do desconto")));

		// Atribuindo o modelo ao carro
		carro.setModelo(modelo);

		return carro;
	}

	// M�todo para listar estoque total de ve�culos cadastrados
	public void listarEstoque() {
		// Vari�vel auxiliar para exibir estoque para o usu�rio
		String mensagem = "";

		// Varrendo estoque para verificar se existem carros caadastrados
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		}
		// Exibindo o estoque para o usu�rio
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
	}

	// M�todo para consultar um carro espec�fico
	public void consultarCarro() {
		// vari�vel auxiliar para montar uma mensagem para o usu�rio
		String mensagem = "Informe o ve�culo a ser consultado: \n\n";

		// Varrendo o estoque para verificar os carros cadastrados
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += "C�digo " + (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		}

		// Capturando o modelo a ser consultado
		int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

		// Inicializando a vari�vel auxiliar par exibir mensagem
		mensagem = "";
		mensagem += "Modelo.....: " + estoque[codigo - 1].getModelo().getNome() + "\n";
		mensagem += "Marca......: " + estoque[codigo - 1].getModelo().getMarca().getNome() + "\n";
		mensagem += "Placa......: " + estoque[codigo - 1].getPlaca() + "\n";
		mensagem += "Combust�vel: " + estoque[codigo - 1].getCombustivel() + "\n";
		mensagem += "Vel m�xima.: " + estoque[codigo - 1].getVelocidadeMaxima() + "\n";

		// Verificar se est� dispon�vel
		if (estoque[codigo - 1].isDisponivel()) {
			mensagem += "Dispon�vel.: SIM\n";
		} else {
			mensagem += "Dispon�vel.: N�O\n";
		}

		// vERIFICANDO SE O CARRO EST� EM PROMO��O
		if (estoque[codigo - 1].isPromocao()) {
			mensagem += "Promo��o...: SIM\n";
			mensagem += "Valor......:" + estoque[codigo - 1].getValorPromocao() + "\n";
		} else {
			mensagem += "Promo��o...: N�O\n";
			mensagem += "Valor......:" + estoque[codigo - 1].getValor() + "\n";
		}

		// Exibindo resultado
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
	}

	// M�todo para retornar todos os carros por modelo escolhido
	public void pesquisarPorModelo() {
		// Recebendo do usu�rio qual modelo a ser pesquisado
		String modelo = JOptionPane.showInputDialog("Informe o modelo para pesquisa");

		// Vari�vel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por modelo:\n\n";

		// Variavel aux para verificar se existe modelo cadastrado
		boolean existe = false;

		// Varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getModelo().getNome().equals(modelo)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		}

		if (existe) {
			// Exibindo resultado par o usuario
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}

	}

	// M�todo para retornar todos os carros por combust�vel escolhido
	public void pesquisarPorCombustivel() {
		// Recebendo do usu�rio qual modelo a ser pesquisado
		String combustivel = JOptionPane.showInputDialog("Informe o combustivel para pesquisa");

		// Vari�vel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por combustivel:\n\n";

		// Variavel aux para verificar se existe modelo cadastrado
		boolean existe = false;

		// Varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getCombustivel().equals(combustivel)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		}

		if (existe) {
			// Exibindo resultado par o usuario
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}
	}

	// M�todo para listar todos os carros em promoc��o
	public void listarCarrosEmPromocao() {
		// recebendo do usuario qual modelo a ser pesquisado
		String promocao = JOptionPane.showInputDialog("Informe a promo��o para pesquisa");
		boolean aux = false;
		if (promocao.equals("SIM")) {
			aux = true;
		}

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por promo��o:\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].isPromocao() == aux) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}
	}

	// M�todo para montar mensagem para o usu�rio
	public String mensagem(Carro carro) {
		// Variavel aux para retornar a mensagem formatada
		String msg = "\n";

		// Montando mensagem de retorno
		msg += "Modelo: " + carro.getModelo().getNome() + "\n";
		msg += "Marca: " + carro.getModelo().getMarca().getNome() + "\n";
		msg += "Placa: " + carro.getPlaca() + "\n";
		msg += "Combust�vel: " + carro.getCombustivel() + "\n";
		msg += "Velocidade m�x: " + carro.getVelocidadeMaxima() + "\n";

		// retorno
		return msg;
	}

	// M�todo para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	}
}
