package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Veiculo;

public class VeiculosDao {
	
	private Connection conexao;
	
	public void inserir(Veiculo veiculo ) {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexao.prepareStatement("INSERT INTO veiculo(id_veiculo, renavam, placa, ano) values(?,?,?,?)");
			comandoSQL.setInt(1, veiculo.getId());
			comandoSQL.setString(2, veiculo.getRenavam());
			comandoSQL.setString(3, veiculo.getPlaca());
			comandoSQL.setString(4, veiculo.getAno());
			
			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
