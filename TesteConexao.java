package Testes;

import DAO.GerenciadorBD;

public class TesteConexao {

	public static void main(String[] args) {
		if(GerenciadorBD.obterConexao() == null) {
			System.out.println("Erro ao estabelecer conexão");
		}
		else {
			System.out.println("Conexão estabelecida com sucesso!");
		}

	}

}
	