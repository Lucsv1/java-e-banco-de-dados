package Testes;

import DAO.GerenciadorBD;

public class TesteGerenciadorBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(GerenciadorBD.obterConexao() == null) {
			System.out.println("Erro ao estabalecer conex�o");
		}
		else {
			System.out.println("Conex�o estabelecida com sucesso");
		}
	}
}
